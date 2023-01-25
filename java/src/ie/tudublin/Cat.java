package ie.tudublin;

public class Cat {
    private int numLives;
    String name;

    public Cat(String name) {
        numLives = 9;
        this.name = name;
    }

    public void kill() {
        if (numLives > 0) {
            numLives--;
            System.out.println("Ouch!");
        } else {
            System.out.println("Dead\n");
        }
    } // end setLives


}
