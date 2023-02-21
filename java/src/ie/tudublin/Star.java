package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;
import processing.core.PApplet;
import java.util.ArrayList;

public class Star {
    boolean hab;
    String displayName;
    float distance;
    float xG, yG, zG, absMag;
    ArrayList<Star> stars = new ArrayList<Star>();

    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    public Star(TableRow tr)
 	{
 		this(
 			tr.getInt("Hab?") == 1, 
 			tr.getString("Display Name"), 
 			tr.getFloat("Distance"),
 			tr.getFloat("Xg"),
 			tr.getFloat("Yg"),
 			tr.getFloat("Zg"),
 			tr.getFloat("AbsMag")
 		);
 	}

    void loadStars() {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for (TableRow r : table.rows()) {
            Star s = new Star(r);
            stars.add(s);
        }
    }
}
