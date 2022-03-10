//KINDA BROKEN BUT LOW-KEY WORKING - DOESN'T MOVE OVER ENTIRELY

import java.util.*;
import processing.core.*;

public class Main extends PApplet {

  private Doge getDoge(int row, int column) {
    for(Doge d: doges) {
      if(d.row() == row && d.column() == column) {
        return d;
      }
    }

    return null;
  }

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

    Doge test = new Doge(this, sideFactor, doges, boxes, 0);
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
      System.out.println("              LEFT!!!!!");

      for(int rowLeft = 0; rowLeft < 4; rowLeft++) {
        //System.out.println("Row: " + rowLeft);
        //System.out.println("");
        for(int columnLeft = 0; columnLeft < 4; columnLeft++) {
          //System.out.println("(" + columnLeft + ", " + rowLeft + ")");
          if(getDoge(rowLeft, columnLeft) != null) {
            getDoge(rowLeft, columnLeft).move(direction);
            //System.out.println("FOUND DOGE");
          }
          //System.out.println("");
        }
      //  System.out.println("*");
      //  System.out.println("");
      }
    }
    else if(keyCode == RIGHT) {
      direction = "right";
      System.out.println("              RIGHT!!!!!");

      for(int rowRight = 0; rowRight < 4; rowRight++) {
    //    System.out.println("Row: " + rowRight);
    //    System.out.println("");
        for(int columnRight = 3; columnRight > -1; columnRight--) {
      //    System.out.println("(" + columnRight + ", " + rowRight + ")");

          if(getDoge(rowRight, columnRight) != null) {
            getDoge(rowRight, columnRight).move(direction);
      //      System.out.println("FOUND DOGE");
          }
      //    System.out.println("");
        }
      //  System.out.println("*");
      //  System.out.println("");
      }
    }
    else if(keyCode == DOWN) {
      direction = "down";
      System.out.println("              DOWN!!!!!");


      for(int columnDown = 0; columnDown < 4; columnDown++) {
        //System.out.println("Column: " + columnDown);
        //System.out.println("");
        for(int rowDown = 3; rowDown > -1; rowDown--) {
          //System.out.println("(" + columnDown + ", " + rowDown + ")");

          if(getDoge(rowDown, columnDown) != null) {
            getDoge(rowDown, columnDown).move(direction);
            //System.out.println("FOUND DOGE");
          }
          //System.out.println("");
        }
      //  System.out.println("*");
      //  System.out.println("");
      }
    }
    else if(keyCode == UP) {
      direction = "up";
      System.out.println("              UP!!!!!");


      for(int columnUp = 0; columnUp < 4; columnUp++) {
        for(int rowUp = 0; rowUp < 4; rowUp++) {
          if(getDoge(rowUp, columnUp) != null) {
            getDoge(rowUp, columnUp).move(direction);
          }
        }
      }
    }

    //for(Doge d: doges) {
      //d.move(direction);
    //}

    System.out.println("");

    Doge e = new Doge(this, sideFactor, doges, boxes, doges.size());
    doges.add(e);

    while(e.checkCollide() == true) {
      e.newDoge();
    }
  }

  private float sideFactor;
  private ArrayList<Box> boxes;

  private ArrayList<Doge> doges;

}
