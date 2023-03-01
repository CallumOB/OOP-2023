package ie.tudublin;

public class PitchSpeller {
    float[] frequencies = { 293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f, 659.25f, 739.99f,
            783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f };
    String[] spellings = { "D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B", "c", "d", "e", "f",
            "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''" };

    public String spell(float frequency) {
        float closest = frequencies[frequencies.length - 1] - frequencies[0];
        int index = 0;

        for (int i = frequencies.length - 1; i > 0; i--) {
            if (frequencies[i] >= frequency && frequencies[i] - frequency < closest) {
                closest = frequencies[i] - frequency;
                index = i;
            } // end if 
        } // end for 

        return spellings[index];
    } // end spell()     
} // end PitchSpeller()
