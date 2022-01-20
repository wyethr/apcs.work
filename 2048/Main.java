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

    float xNowIn = (((width-(5*height/6))/2) + height/30);
    float xNow = xNowIn;
    float yNow = height/12 + height/30;

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
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }


  ArrayList<Box> boxes;
  float xNow;
  float yNow;
  Doge test;
  ArrayList<Doge> doges;

}
