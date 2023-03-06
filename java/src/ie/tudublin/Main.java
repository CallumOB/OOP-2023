package ie.tudublin;

public class Main {
	public static void life() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new Life());
	}

	public static void main(String[] args) {

		life();
	}

}