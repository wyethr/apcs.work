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

    velocity = new PVector(0, 0);

    float xNow = (((p.width-(5*p.height/6))/2) + p.height/30);
    float yNow = p.height/12 + p.height/30;
    float yFactor = p.height/6 + p.height/30;

    float xIsh = xNow + column*yFactor;
    float yIsh = yNow + row*yFactor;

    position = new PVector(xIsh, yIsh);
    destination = position;

    vFactor = 1;
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

    x = xNow + column*yFactor;
    y = yNow + row*yFactor;

    destination.x = x;
    destination.y = y;

    System.out.println("difference between = " + position.dist(destination));

    if(position.dist(destination) < vFactor) {
      velocity.x = 0;
      velocity.y = 0;

      position = destination;
    }

    //System.out.println("position.x = " + position.x);
    //System.out.println("position.y = " + position.y);
    //System.out.println("");

    //System.out.println("destination.x = " + destination.x);
    //System.out.println("destination.y = " + destination.y);
    //System.out.println("");

    //System.out.println("velocity.x = " + velocity.x);
    //System.out.println("velocity.y = " + velocity.y);
    //System.out.println("");
    //System.out.println("*");
    //System.out.println("");

    position.add(velocity);
    x = xNow + row*yFactor;
    y = yNow + column*yFactor;

    p.fill(0, 50);
    p.rectMode(p.CORNER);
    p.rect(x, y, side, side);
    p.text("" + type, x, y);
  }

  public void move(String direction) {
    //System.out.println(name + "'s original position: (" + row + ", " + column + ")");

    if(direction == "left") {
      while(row > 0 && checkCollide(direction) == "no collide") {
        row--;
      }

      if(checkCollide(direction) == "same") {
        doges.remove(findSame(direction));
        row--;
        type = type*2;
      }
    }
    else if(direction == "right") {
      while(row < 3 && checkCollide(direction) == "no collide") {
        row++;
      }

      if(checkCollide(direction) == "same") {
        doges.remove(findSame(direction));
        row++;
        type = type*2;
      }
    }
    else if(direction == "up") {
      while(column > 0 && checkCollide(direction) == "no collide") {
        column--;
      }

      if(checkCollide(direction) == "same") {
        doges.remove(findSame(direction));
        column--;
        type = type*2;
      }
    }
    else if(direction == "down") {
      while(column < 3 && checkCollide(direction) == "no collide") {
        column++;
      }

      if(checkCollide(direction) == "same") {
        doges.remove(findSame(direction));
        column++;
        type = type*2;
      }
    }

    //System.out.println(name + " moves to (" + row + ", " + column + ")");
    //System.out.println("");
    //System.out.println("#");
    //System.out.println("");

  }

  public String checkCollide(String direction) {
    int xBit = row;
    int yBit = column;

    //System.out.println("other doges length: " + doges.size());
    //System.out.println("");

    //System.out.println(name + "'s og row: " + row);
    //System.out.println(name + "'s og column: " + column);
    //System.out.println("");

    //System.out.println(name + "'s og xBit: " + xBit);
    //System.out.println(name + "'s og yBit: " + yBit);
    //System.out.println("");

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

    //System.out.println(name + "'s new xBit: " + xBit);
    //System.out.println(name + "'s new yBit: " + yBit);
    //System.out.println("");

    for(Doge other: doges) {
      //System.out.println("     OTHER " + other.name() + "'s row: " + other.row());
      //System.out.println("     OTHER " + other.name() + "'s column: " + other.column());

      if(other.equals(this)) {
        //System.out.println("");
        //System.out.println("     *");
        //System.out.println("");
      }

      else if(other.row() == xBit && other.column() == yBit) {
        //System.out.println("     COLLIDE!");
        //System.out.println("");
        //System.out.println("     *");
        //System.out.println("");

        if(other.type() == type) {
          return "same";
        }

        return "collide";
      }

      //System.out.println("");
      //System.out.println("     *");
      //System.out.println("");

    }

    return "no collide";
  }

  public boolean checkCollide() {
    for(Doge other: doges) {
      if(other.equals(this)) {
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

  public int name() {
    return name;
  }

  public Doge findSame(String direction) {
    int xBit = row;
    int yBit = column;

    //System.out.println("other doges length: " + doges.size());
    //System.out.println("");

    //System.out.println(name + "'s og row: " + row);
    //System.out.println(name + "'s og column: " + column);
    //System.out.println("");

    //System.out.println(name + "'s og xBit: " + xBit);
    //System.out.println(name + "'s og yBit: " + yBit);
    //System.out.println("");

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

    //System.out.println(name + "'s new xBit: " + xBit);
    //System.out.println(name + "'s new yBit: " + yBit);
    //System.out.println("");

    for(Doge other: doges) {
      //System.out.println("     OTHER " + other.name() + "'s row: " + other.row());
      //System.out.println("     OTHER " + other.name() + "'s column: " + other.column());

      if(other.equals(this)) {
        //System.out.println("");
        //System.out.println("     *");
        //System.out.println("");
      }

      else if(other.row() == xBit && other.column() == yBit) {
        //System.out.println("     COLLIDE!");
        //System.out.println("");
        //System.out.println("     *");
        //System.out.println("");

        if(other.type() == type) {
          return other;
        }
      }

      //System.out.println("");
      //System.out.println("     *");
      //System.out.println("");

    }

    return null;
  }

  public int type() {
    return type;
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

  protected PVector destination;
  protected PVector position;
  protected PVector velocity;

  protected int vFactor;

}
