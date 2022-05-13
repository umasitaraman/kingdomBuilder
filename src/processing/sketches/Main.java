package processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet sketch;
    public PImage castleImage;
    public PImage starImage;
    public PImage mapImage;

    private  Castle castle1;
    private  Castle castle2;
    private  Castle castle3;

    private final int starSize = 15;
    private final int detailFontSize = 14;



    public void settings() {
        castleImage = loadImage("castle.png");
        starImage = loadImage("CapitolStar.png");
        mapImage = loadImage("map.png");
        size(600, 600);
        sketch = this;


    }

    public void setup() {
        background(0);
        imageMode(CENTER);
        textAlign(CENTER);

        castle1 = new Castle (
          "Bob",
          647432,
          "12345",
          1000,
          "The Sphere",
          true,
          314,
          105
        );
        castle2 = new Castle (
                "Bob2",
                328,
                "58394",
                1500,
                "The cube",
                false,
                365,
                300
        );
        castle3 = new Castle (
                "Bob3",
                48328,
                "35434",
                5000,
                "The cone",
                false,
                100,
                100
        );
    }

    public void draw() {
        image(mapImage,width/2, height/2, width, height);

        drawCastle(castle1);
        drawCastle(castle2);
        drawCastle(castle3);

    }

    //  Uncomment when ready to draw castles
    public void drawCastle(Castle castle) {
        float squareBase = sqrt(castle.getArea());
        image(castleImage, castle.getLatitude(), castle.getLongitude(), squareBase, squareBase);

        if (castle.isCapitol()) {
            image(starImage, castle.getLatitude() + squareBase/2 , castle.getLongitude() - squareBase/2, starSize, starSize);
        }

        if (dist(castle.getLatitude(), castle.getLongitude(), mouseX, mouseY) < squareBase/2) {
            textSize(detailFontSize);
            fill(0);

            text(castle.getName(), castle.getLatitude(), castle.getLongitude() + squareBase/2 + detailFontSize);
            text(castle.getPopulation(), castle.getLatitude(), castle.getLongitude() + squareBase/2 + detailFontSize * 2);
            text(castle.getLandmark(), castle.getLatitude(), castle.getLongitude() + squareBase/2 + detailFontSize * 3);
        }


    }

    public static void main(String... args) {

        PApplet.main("processing.sketches.Main");

    }
}
