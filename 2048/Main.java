import java.util.*;
import processing.core.*;

public class Main extends PApplet {

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    boxes = new ArrayList<Box>();
    doges = new ArrayList<Doge>();

    background(255);

    sideFactor = height/6;

    for(int i = 0; i < 4; i ++) {
      for(int j = 0; j < 4; j++) {
        Box b = new Box(this, i, j, sideFactor);
        boxes.add(b);
      }
    }

    Doge test = new Doge(this, sideFactor, doges, boxes);
    doges.add(test);
  }

  public void draw() {
    background(255);

    fill(0);
    text(doges.size(), 25, 25);

    rectMode(CENTER);
    noStroke();
    fill(200);
    rect(width/2, height/2, 5*height/6, 5*height/6);

    for(Box b: boxes) {
      b.display();
    }

    for(Doge d: doges) {
      d.display();
    }
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  public void keyPressed() {
    String direction = "";

    if(keyCode == LEFT) {
      direction = "left";
    }
    else if(keyCode == RIGHT) {
      direction = "right";
    }
    else if(keyCode == DOWN) {
      direction = "down";
    }
    else if(keyCode == UP) {
      direction = "up";
    }

    for(Doge d: doges) {
      //d.move(direction);
    }

    Doge e = new Doge(this, sideFactor, doges, boxes);
    doges.add(e);

    while(e.checkCollide() == true) {
      System.out.println("here");
      e.newDoge();
    }

    System.out.println("");
  }

  private float sideFactor;
  private ArrayList<Box> boxes;

  private ArrayList<Doge> doges;

}
