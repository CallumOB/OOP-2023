package ie.tudublin;

public class Main {

	public static void audio2() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new Audio2());
	}

	public static void main(String[] args) {
		PitchSpeller ps = new PitchSpeller();
		
		System.out.println(ps.spell(330));
        System.out.println(ps.spell(420));
        System.out.println(ps.spell(1980));
		
		// audio2();
	}

}