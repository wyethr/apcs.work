import processing.core.*;
import java.util.*;

public class Doge {

  public Doge(PApplet p, float width, float height, float xNowIn, float yNowIn, float yFactor, float sideFactor, ArrayList<Doge> manyDoges, ArrayList<Box> boxesIn) {
    this.p = p;
    this.width = width;
    this.height = height;
    this.xNowIn = xNowIn;
    this.yNowIn = yNowIn;
    boxes = new ArrayList<Box>();
    allDoges = manyDoges;
    for(Box b: boxesIn) {
      boxes.add(b.copy());
    }

    side = sideFactor;
    moveFactor = yFactor;
    //System.out.println("xNowIn = " + xNowIn);
    //System.out.println("yNowIn = " + yNowIn);
    //System.out.println("height/30 = " + height/30);
    //System.out.println("");

    x = xNowIn + ((int)p.random(0, 3)*(yFactor));
    y = yNowIn + ((int)p.random(0, 3)*(yFactor));

    //System.out.println("x = " + x);
    //System.out.println("y = " + y);
    //System.out.println("");

    typeMultIn = p.random(1, 1536);

    if(typeMultIn <= 1024 ) {
      typeMult = 1;
    }
    else {//if(typeMultIn <= 1536) {
      typeMult = 2;
    }

    type = (int)Math.pow(2, typeMult);
  }

  public void display() {
    p.fill(0);
    p.rectMode(p.CORNER);
    p.rect(x, y, side, side);
    p.text("" + type, x, y);
  }

  public void moveLeft() {
    while(x > xNowIn + height/30) {
      if(checkCollide("left") == false) {
        x = x - moveFactor;
      }
      else {
        break;
      }
    }
  }

  public void moveRight() {
    while(x < xNowIn + (2*(height/6 + height/30))) {
      if(checkCollide("right") == false) {
        x = x + moveFactor;
      }
      else {
        return;
      }
    }
  }

  public void moveDown() {
    while(y < (yNowIn + (2*(height/6 + height/30)))) {
      if(checkCollide("down") == false) {
        y = y + moveFactor;
      }
      else {
        return;
      }
    }
  }

  public void moveUp() {
    while(y > yNowIn + height/30) {
      if(checkCollide("up") == false) {
        y = y - moveFactor;
      }
      else {
        return;
      }
    }
  }

  public float x() {
    return x;
  }

  public float y() {
    return y;
  }

  public float side() {
    return side;
  }

  public int type() {
    return type;
  }

  public boolean checkCollide() {
    //System.out.println("x = " + x);
    //System.out.println("y = " + y);
    //System.out.println("");

    for(Doge other: allDoges) {
      //System.out.println("other.x = " + other.x);
      //System.out.println("other.y = " + other.y);

      if(other.equals(this)) {
        continue;
      }

      else if(other.x == x && other.y == y) {
       return true;
      }
    }

    return false;

  }

  public boolean checkCollide(String direction) {
    float xBit = x;
    float yBit = y;

    if(direction == "right") {
      xBit = xBit + moveFactor;
    }
    else if(direction == "left") {
      xBit = xBit - moveFactor;
    }
    else if(direction == "up") {
      yBit = yBit - moveFactor;
    }
    else if(direction == "down") {
      yBit = yBit + moveFactor;
    }

    for(Doge other: allDoges) {
      if(other.equals(this)) {
        break;
      }

      else if(other.x == xBit && other.y == yBit) {
        return true;
      }
    }

    return false;

  }

  public boolean checkSingleCollide(String direction, Doge other) {
    float xBit = x;
    float yBit = y;

    if(direction == "right") {
      xBit = xBit + moveFactor;
    }
    else if(direction == "left") {
      xBit = xBit - moveFactor;
    }
    else if(direction == "up") {
      yBit = yBit - moveFactor;
    }
    else if(direction == "down") {
      yBit = yBit + moveFactor;
    }

    if(other.equals(this)) {
      return false;
    }
    else if(other.x == xBit && other.y == yBit) {
      return true;
    }
    else {
      return false;
    }
  }

  public void newDoge() {
    System.out.println("boxes length = " + boxes.size());
    Box get = boxes.get((int)p.random(0, boxes.size()));
    x = get.x();
    y = get.y();

    boxes.remove(get);
  }

  protected PApplet p;

  protected int type;
  protected int typeMult;
  protected float typeMultIn;

  protected float x;
  protected float y;
  protected float side;
  protected float moveFactor;

  protected float width;
  protected float height;

  protected ArrayList<Doge> allDoges;

  protected float xNowIn;
  protected float yNowIn;

  private ArrayList<Box> boxes;
}
