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

    for(int i = 1; i <= 16; i++) {
      if(i != 1 && i%4 == 1) {
        yNow = yNow + height/6 + height/30;
        xNow = xNowIn;
      }

      Box b = new Box(this, xNow, yNow, height/6);
      boxes.add(b);

      xNow = xNow + height/6 + height/30;
    }


    test = new Doge(this, height/6, (((width-(5*height/6))/2) + height/30 + height/6 + height/30), (height/12 + height/30), height/30);
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
      for(Doge d: doges) {
        while(d.x() > xNowIn + height/30) {
          d.moveLeft();
        }
      }
    }

    else if(keyCode == RIGHT) {
      for(Doge d: doges) {
        while(d.x() < (((width-(5*height/6))/2) + height/30) + (3*(height/6 + height/30))) {
          d.moveRight();
        }
      }
    }

    else if(keyCode == DOWN) {
      for(Doge d: doges) {
        while(d.y() < (yNowIn + (3*(height/6 + height/30)))) {
          d.moveDown();
        }
      }
    }

    else if(keyCode == UP) {
      for(Doge d: doges) {
        while(d.y() > yNowIn + height/30) {
          d.moveUp();
        }
      }
    }

    Doge e = new Doge(this, width, height);

    if(e.checkCollide(doges) == false) {
      System.out.println("skip here");
    }
    while(e.checkCollide(doges) == true) {
      System.out.println("here");
      System.out.println("old x = " + e.x());
      System.out.println("old y = " + e.y());
      System.out.println("");

      e = new Doge(this, width, height);
      System.out.println("new x = " + e.x());
      System.out.println("new y = " + e.y());
    }
    doges.add(e);


    for(Doge f: doges) {
      f.checkCollide(doges);
    }
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }


  ArrayList<Box> boxes;

  float xNow;
  float yNow;
  float xNowIn;
  float yNowIn;

  Doge test;
  ArrayList<Doge> doges;
}
