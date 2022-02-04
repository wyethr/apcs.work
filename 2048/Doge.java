import processing.core.*;
import java.util.*;

public class Doge {

  public Doge(PApplet p, float width, float height, float xNowIn, float yNowIn, float yFactor, float sideFactor, ArrayList<Doge> manyDoges) {
    this.p = p;
    this.width = width;
    this.height = height;
    this.xNowIn = xNowIn;
    this.yNowIn = yNowIn;
    allDoges = manyDoges;

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
      if(leftCollide() == false) {
        x = x - moveFactor;
      }
      else {
        break;
      }
    }
  }

  public void moveRight() {
    while(x < (((width-(5*height/6))/2) + height/30) + (3*(height/6 + height/30))) {
      if(rightCollide() == false) {
        x = x + moveFactor;
      }
      else {
        return;
      }
    }
  }

  public void moveDown() {
    while(y < (yNowIn + (3*(height/6 + height/30)))) {
      if(downCollide() == false) {
        y = y + moveFactor;
      }
      else {
        return;
      }
    }
  }

  public void moveUp() {
    while(y > yNowIn + height/30) {
      if(upCollide() == false) {
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

  public boolean rightCollide() {
    float xBit = x + moveFactor;
    float yBit = y;

    for(Doge other: allDoges) {
      //System.out.println("other.x = " + other.x);
      //System.out.println("other.y = " + other.y);

      if(other.equals(this)) {
        continue;
      }

      else if(other.x == xBit && other.y == yBit) {
       return true;
      }
    }

    return false;

  }

  public boolean leftCollide() {
    float xBit = x - moveFactor;
    float yBit = y;

    for(Doge other: allDoges) {
      //System.out.println("other.x = " + other.x);
      //System.out.println("other.y = " + other.y);

      if(other.equals(this)) {
        continue;
      }

      else if(other.x == xBit && other.y == yBit) {
       return true;
      }
    }

    return false;

  }

  public boolean upCollide() {
    float xBit = x;
    float yBit = y - moveFactor;

    for(Doge other: allDoges) {
      //System.out.println("other.x = " + other.x);
      //System.out.println("other.y = " + other.y);

      if(other.equals(this)) {
        continue;
      }

      else if(other.x == xBit && other.y == yBit) {
       return true;
      }
    }

    return false;

  }

  public boolean downCollide() {
    float xBit = x;
    float yBit = y + moveFactor;

    for(Doge other: allDoges) {
      //System.out.println("other.x = " + other.x);
      //System.out.println("other.y = " + other.y);

      if(other.equals(this)) {
        continue;
      }

      else if(other.x == xBit && other.y == yBit) {
       return true;
      }
    }

    return false;

  }

  public boolean doMove() {
    return doMove;
  }

  public void changeDoMove() {
    if(doMove == true) {
      doMove = false;
    }
    else {
      doMove = true;
    }
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

  protected boolean doMove;
  protected float xNowIn;
  protected float yNowIn;
}
