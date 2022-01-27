import processing.core.*;
import java.util.*;

public class Doge {

  public Doge(PApplet p, float side, float x, float y, float moveFactor) {
    this.p = p;
    this.side = side;
    this.x = x;
    this.y = y;
    this.moveFactor = moveFactor;

    typeMultIn = p.random(1, 1920);

    if(typeMultIn <= 1024 ) {
      typeMult = 1;
    }
    else if(typeMultIn <= 1536) {
      typeMult = 2;
    }
    else if(typeMultIn <= 1792) {
      typeMult = 3;
    }
    else {
      typeMult = 4;
    }

    type = (int)Math.pow(2, typeMult);
  }

  public Doge(PApplet p, float width, float height) {
    this.p = p;
    this.width = width;
    this.height = height;

    side = height/6;
    moveFactor = height/30;
    float xNowIn = ((width-(5*height/6))/2) + height/30;
    //System.out.println("xNowIn = " + xNowIn);
    float yNowIn = height/12 + height/30;
    //System.out.println("yNowIn = " + yNowIn);
    //System.out.println("height/30 = " + height/30);
    //System.out.println("");

    x = xNowIn + ((int)p.random(0, 3)*(height/6 + height/30));
    y = yNowIn + ((int)p.random(0, 3)*(height/6 + height/30));

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
    x = x - side - moveFactor;
  }

  public void moveRight() {
    x = x + side + moveFactor;
  }

  public void moveDown() {
    y = y + side + moveFactor;
  }

  public void moveUp() {
    y = y - side - moveFactor;
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

  public boolean checkCollide(ArrayList<Doge> allDoges) {
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
}
