//THE! CHECK! COLLIDE! FOR! EACH! DOESN'T! WORK!
//URGHHH
//JFKDLSJFKLDSJFKDLS BUT IT WORKS ON EACH INDIVIDUAL ARROW IT JUST-
//FHDKSFHKDSLAJFAAAAAAAAAA

import java.util.*;
import processing.core.*;

public class Main extends PApplet {

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    background(255);

    boxes = new ArrayList<Box>();
    doges = new ArrayList<Doge>();

    xNowIn = (((width-(5*height/6))/2) + height/30);
    float xNow = xNowIn;
    yNowIn = height/12 + height/30;
    float yNow = yNowIn;
    yFactor = height/6 + height/30;
    sideFactor = height/6;

    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 4; j++) {
        Box b = new Box(this, i, j, sideFactor, width, height);
        boxes.add(b);
      }
    }

    //for(int i = 1; i <= 16; i++) {
    //  if(i != 1 && i%4 == 1) {
      //  yNow = yNow + yFactor;
    //    xNow = xNowIn;
  //    }

  //    Box b = new Box(this, xNow, yNow, sideFactor);
  //    boxes.add(b);

//      xNow = xNow + yFactor;
//    }


    Doge test = new Doge(this, width, height, xNowIn, yNowIn, yFactor, sideFactor, doges, boxes);
    doges.add(test);
  }

  public void draw() {

    //drawing the background:
    background(255);

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

    rectMode(CORNER);
    fill(0);
    text("doges.size() + " + doges.size(), 25, 25);
    text("allDoges.size() + " + doges.size(), 25, 50);

  }

  public void keyPressed() {
    if(keyCode == LEFT) {
      for(Doge d: doges) {
        d.moveLeft();
      }
    }

    else if(keyCode == RIGHT) {
      for(Doge d: doges) {
        d.moveRight();
      }
    }

    else if(keyCode == DOWN) {
      for(Doge d: doges) {
        d.moveDown();
      }
    }

    else if(keyCode == UP) {
      for(Doge d: doges) {
        d.moveUp();
      }
    }

    Doge e = new Doge(this, width, height, xNowIn, yNowIn, yFactor, sideFactor, doges, boxes);

    while(e.checkCollide() == true) {
      e.newDoge();
      //e = new Doge(this, width, height, xNowIn, yNowIn, yFactor, sideFactor, doges, boxes);
      //System.out.println("here at making the new e");
      //System.out.println("(" + e.x() + ", " + e.y() + ")");
    }
    //System.out.println("");

    doges.add(e);
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  private ArrayList<Box> boxes;

  float xNow;
  float yNow;
  float xNowIn;
  float yNowIn;
  float yFactor;
  float sideFactor;

  Doge test;
  ArrayList<Doge> doges;
}
