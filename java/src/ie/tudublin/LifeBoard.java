package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    boolean[][] next;
    private int size;
    PApplet p;
    float cellWidth;

    public LifeBoard(int size, PApplet p) {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width / (float)size;
    }

    public boolean getCell(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return board[row][col];
        } else {
            return false;
        }
    }

    public int countCells(int row, int col) {
        int count = 0; 

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 && j != 0) {
                    if (getCell(row + i, row + j)) {
                        count++;
                    }
                }
            } // end for
        } // end for 

        return count;
    }

    public void applyRules() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int count = countCells(row, col);
                // < 2 > 3 dises
                // 2-3 survives
                // dead with 3 neighbours: comes to life
                if (board[row][col] == true) {
                    if (count < 2 || count > 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                    
                    if (count == 3) {
                        next[row][col] = true;
                    }
                }
                board = next;
                next = new boolean[size][size];
            }
        }

        boolean[][] temp = board;
        board = next;
        next = temp;

    }

    public void randomise() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                float dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            } // end for 
        } // end for 
    }

    public void render() {
        applyRules();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                float x = col * cellWidth;
                float y = row * cellWidth;

                if (board[row][col]) {
                    p.fill(p.random(0, 255), 255, 255);
                } else {
                    p.fill(0);
                }
                p.rect(x, y, cellWidth, cellWidth);
            }
        }
    }
    
    public int getSize() {
        return size;
    }
}
