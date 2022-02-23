import java.util.*;
import processing.core.*;

public class Doge {

  public Doge(PApplet p, float side, ArrayList<Doge> doges, ArrayList<Box> boxes, int name) {
    this.p = p;
    this.width = width;
    this.height = height;
    this.side = side;
    this.doges = doges;
    this.boxes = new ArrayList<Box>();
    this.name = name;

    row = (int)p.random(0, 4);
    column = (int)p.random(0, 4);

    int typeMultIn = (int)p.random(0, 3);

    if(typeMultIn <= 2) {
      typeMult = 1;
    }
    else {
      typeMult = 2;
    }

    type = (int)Math.pow(2, typeMult);

    for(Box b: boxes) {
      this.boxes.add(b.copy());
    }
  }

  public float width() {
    return width;
  }

  public float height() {
    return height;
  }

  public float side() {
    return side;
  }

  public int row() {
    return row;
  }

  public int column() {
    return column;
  }

  public void display() {
    float xNow = (((p.width-(5*p.height/6))/2) + p.height/30);
    float yNow = p.height/12 + p.height/30;
    float yFactor = p.height/6 + p.height/30;

    x = xNow + row*yFactor;
    y = yNow + column*yFactor;

    p.fill(0, 50);
    p.rectMode(p.CORNER);
    p.rect(x, y, side, side);
    p.text("" + name, x, y);
  }

  public void move(String direction) {
    System.out.println(name + "'s original position: (" + row + ", " + column + ")");
    if(direction == "left") {
      while(row > 0 && checkCollide(direction) == false)
        row--;
    }
    else if(direction == "right") {
      while(row < 3 && checkCollide(direction) == false) {
        row++;
      }
    }
    else if(direction == "up") {
      while(column > 0 && checkCollide(direction) == false)
        column--;
    }
    else if(direction == "down") {
      while(column < 3 && checkCollide(direction) == false)
        column++;
    }

    System.out.println(name + " moves to (" + row + ", " + column + ")");
    System.out.println("");

  }

  public boolean checkCollide(String direction) {
    int xBit = row;
    int yBit = column;

    if(direction == "right") {
      xBit++;
    }
    else if(direction == "left") {
      xBit--;
    }
    else if(direction == "up") {
      yBit--;
    }
    else if(direction == "down") {
      yBit++;
    }

    for(Doge other: doges) {
      if(other.equals(this)) {
        break;
      }

      else if(other.row() == xBit && other.column() == yBit) {
        return true;
      }
    }

    return false;
  }

  public boolean checkCollide() {
    for(Doge other: doges) {
      if(other.equals(this)) {
        break;
      }

      else if(other.row() == row && other.column() == column) {
        return true;
      }
    }

    return false;
  }

  public void newDoge() {
    Box get = boxes.get((int)p.random(0, boxes.size()));
    row = get.row();
    column = get.column();

    boxes.remove(get);
  }

  public ArrayList<Box> boxes() {
    return boxes;
  }

  protected PApplet p;

  protected ArrayList<Box> boxes;

  protected float width;
  protected float height;
  protected float side;

  protected int row;
  protected int column;

  protected float x;
  protected float y;

  protected int typeMult;
  protected int type;

  protected ArrayList<Doge> doges;

  protected int name;

}
