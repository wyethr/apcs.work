import processing.core.*;
import java.util.*;

public class Doge {

  public Doge(PApplet p, float side, float x, float y, float moveFactor) {
    this.p = p;
    this.side = side;
    this.x = x;
    this.y = y;
    this.moveFactor = moveFactor;

    typeMultIn = p.random(1, 2042);

    if(typeMultIn <= 1024 ) {
      typeMult = 1;
    }
    else if(typeMultIn <= 1536) {
      typeMult = 2;
    }
    else if(typeMultIn <= 1792) {
      typeMult = 3;
    }
    else if(typeMultIn <= 1920) {
      typeMult = 4;
    }
    else if(typeMultIn <= 1984) {
      typeMult = 5;
    }
    else if(typeMultIn <= 2016) {
      typeMult = 6;
    }
    else if(typeMultIn <= 2032) {
      typeMult = 7;
    }
    else if(typeMultIn <= 2040) {
      typeMult = 8;
    }
    else {
      typeMult = 9;
    }

    type = (int)Math.pow(2, typeMult);
  }

  public void display() {
    p.fill(200);
    p.rectMode(p.CORNER);
    p.rect(x, y, side, side);
    p.fill(0);
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

  public void checkCollide(Doge other, ArrayList<Doge> allDoges) {
    if(other.x == x && other.y == other.y) {
      allDoges.remove(other);
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
}
