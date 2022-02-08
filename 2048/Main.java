//OKAY SO POSSIBLE SOLUTION:
//1) YOU HAVE THE DOGE() CONSTRUCTOR IMPORT AN ARRAYLIST OF boxes
//AND THEN YOU HAVE IT ASSIGN OG X + Y BASED OFF OF A RANDOM BOX'S X + Y
//AND THEN IF THAT DOESN'T WORK FOR E YOU ELIMINATE THE BOX THAT YOU ORIGINALLY PUT IN

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

    for(int i = 1; i <= 16; i++) {
      if(i != 1 && i%4 == 1) {
        yNow = yNow + yFactor;
        xNow = xNowIn;
      }

      Box b = new Box(this, xNow, yNow, sideFactor);
      boxes.add(b);

      xNow = xNow + yFactor;
    }


    Doge test = new Doge(this, width, height, xNowIn, yNowIn, yFactor, sideFactor, doges);
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
    text(doges.size(), 25, 25);


  }

  public void keyPressed() {
    if(keyCode == LEFT) {
      for(int i = 0; i < 4; i++) {
        for(Doge d: doges) {
          d.moveLeft();
        }
      }
    }

    else if(keyCode == RIGHT) {
      for(int j = 0; j < 4; j++) {
        for(Doge d: doges) {
          d.moveRight();
        }
      }
    }

    else if(keyCode == DOWN) {
      for(int k = 0; k < 4; k++) {
        for(Doge d: doges) {
          d.moveDown();
        }
      }
    }

    else if(keyCode == UP) {
      for(int l = 0; l < 4; l++) {
        for(Doge d: doges) {
          d.moveUp();
        }
      }
    }

    Doge e = new Doge(this, width, height, xNowIn, yNowIn, yFactor, sideFactor, doges);

    while(e.checkCollide() == true) {
      e = new Doge(this, width, height, xNowIn, yNowIn, yFactor, sideFactor, doges);
      System.out.println("here at making the new e");
      System.out.println("(" + e.x() + ", " + e.y() + ")");
    }
    System.out.println("");

    doges.add(e);
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }


  ArrayList<Box> boxes;

  float xNow;
  float yNow;
  float xNowIn;
  float yNowIn;
  float yFactor;
  float sideFactor;

  Doge test;
  ArrayList<Doge> doges;
}
