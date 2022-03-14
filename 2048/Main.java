//START BANGING ON KEYS AND SEE THE BUG! NOT COMBINING SOMETIMES

//okayokay SO for the animation stuff:
//ask dr kessner about the head branch vs the main branch
//1. choose what kind of 2048 game + design each pic
//2. add gameStates
//3. make the Doge grow when it's generated rather than just appear full-size

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

  private boolean allInPlace() {
    for(Doge d: doges) {
      if(d.position().dist(d.destination()) > 1) {
        //System.out.println(d.name() + " = " + d.position().dist(d.destination()));
        return false;
      }
    }

    return true;
  }

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    boxes = new ArrayList<Box>();
    doges = new ArrayList<Doge>();

    //System.out.println(moved);
    moved = false;

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
    nameKeeper = 1;

    //Doge new1 = new Doge(this, sideFactor, doges, boxes, 0, 0, 0, 4);
    //Doge new2 = new Doge(this, sideFactor, doges, boxes, 1, 1, 0, 4);
    //Doge new3 = new Doge(this, sideFactor, doges, boxes, 2, 2, 0, 4);
    //doges.add(new1);
    //doges.add(new2);
    //doges.add(new3);
  }

  public void draw() {
    background(255);

    fill(0);
    text("doges.size: " + doges.size(), 25, 25);
    text("nameKeeper: " + nameKeeper, 25, 50);
    text("size: (" + width + ", " + height + ")", 25, 75);

    rectMode(CENTER);
    noStroke();
    fill(200);
    rect(width/2, height/2, 5*height/6, 5*height/6);

    for(Box b: boxes) {
      b.display();
    }

    for(int i = 0; i < doges.size(); i++) {
      doges.get(i).display();
    }

    int textPlacement = 25;
    int xPlacement = 1100;

    for(Doge e: doges) {
      fill(0);

      if(textPlacement >= 700) {
        if(xPlacement == 25) {
          textPlacement = 125;
          xPlacement = 200;
        }
        else {
          textPlacement = 125;
          xPlacement = 25;
        }
      }

      text(e.name() + " - type: " + e.type(), xPlacement, textPlacement);
      textPlacement = textPlacement + 25;
      text("   (" + e.column() + ", " + e.row() + ")", xPlacement, textPlacement);
      textPlacement = textPlacement + 25;
      text("   checkCollide() is " + e.checkCollide(), xPlacement, textPlacement);
      textPlacement = textPlacement + 25;
      text("   (" + e.position().x + ", " + e.position().y + ")", xPlacement, textPlacement);
      textPlacement = textPlacement + 25;
      text("", xPlacement, textPlacement);
      textPlacement = textPlacement + 25;
    }

    //System.out.println("allInPlace = " + allInPlace());
    if(allInPlace() == true) {
      if(moved == true) {
        Doge e = new Doge(this, sideFactor, doges, boxes, nameKeeper);
        doges.add(e);
        nameKeeper++;
        //System.out.println(e.name());
        //System.out.println("(" + e.column() + ", " + e.row() + ")");
        //System.out.println("e checkCollide() is " + e.checkCollide());
        //System.out.println("(" + e.position().x + ", " + e.position().y + ")");
        //System.out.println("");

        while(e.checkCollide().equals("collide") || e.checkCollide().equals("same")) {
          e.newDoge();
          //System.out.println(e.name());
          //System.out.println("(" + e.column() + ", " + e.row() + ")");
          //System.out.println("e checkCollide() is " + e.checkCollide());
          //System.out.println("(" + e.position().x + ", " + e.position().y + ")");
          //System.out.println("");
        }

        moved = false;
      }
    }
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  public void keyPressed() {
    String direction = "";

    for(Doge d: doges) {
      d.setOffLimits();
      d.setOffLimitsMerge();
    }


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
        //System.out.println("*");
        //System.out.println("");
      }
    }

    else if(keyCode == RIGHT) {
      direction = "right";
      System.out.println("              RIGHT!!!!!");

      for(int rowRight = 0; rowRight < 4; rowRight++) {
        //System.out.println("Row: " + rowRight);
        //System.out.println("");
        for(int columnRight = 3; columnRight > -1; columnRight--) {
          //System.out.println("(" + columnRight + ", " + rowRight + ")");

          if(getDoge(rowRight, columnRight) != null) {
            getDoge(rowRight, columnRight).move(direction);
            //System.out.println("FOUND DOGE");
          }
          //System.out.println("");
        }
        //System.out.println("*");
        //System.out.println("");
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
        //System.out.println("*");
        //System.out.println("");
      }
    }
    else if(keyCode == UP) {
      direction = "up";
      System.out.println("              UP!!!!!");


      for(int columnUp = 0; columnUp < 4; columnUp++) {
        //System.out.println("Column: " + columnUp);
        //System.out.println("");
        for(int rowUp = 0; rowUp < 4; rowUp++) {
          //System.out.println("(" + columnUp + ", " + rowUp + ")");

          if(getDoge(rowUp, columnUp) != null) {
            getDoge(rowUp, columnUp).move(direction);
            //System.out.println("FOUND DOGE");
          }
          //System.out.println("");
        }
        //System.out.println("*");
        //System.out.println("");
      }
    }

    System.out.println("");
    System.out.println("*");
    System.out.println("");

    moved = true;

  }

  private float sideFactor;
  private ArrayList<Box> boxes;

  private ArrayList<Doge> doges;

  private int nameKeeper;
  private boolean moved;

}
