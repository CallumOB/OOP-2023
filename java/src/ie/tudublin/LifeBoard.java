package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    private int size;
    PApplet p;
    float cellWidth;

    public LifeBoard(int size, PApplet p) {
        this.size = size;
        board = new boolean[size][size];
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
                    if (getCell(i, j)) {
                        count++;
                    }
                }
            } // end for
        } // end for 

        return count;
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
