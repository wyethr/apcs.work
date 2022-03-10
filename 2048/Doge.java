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

    offLimits = false;

    selectRowColumn();

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

    float xStart = xNow + column*yFactor;
    float yStart = yNow + row*yFactor;

    position = new PVector(xStart, yStart);
    destination = new PVector(200, 200);

    vFactor = 1;
  }

  public Doge(PApplet p, float side, ArrayList<Doge> doges, ArrayList<Box> boxes, int name, int row, int column, int type) {
    this.p = p;
    this.width = width;
    this.height = height;
    this.side = side;
    this.doges = doges;
    this.boxes = new ArrayList<Box>();
    this.name = name;

    this.row = row;
    this.column = column;
    this.type = type;

    offLimits = false;

    //selectRowColumn();

    int typeMultIn = (int)p.random(0, 3);

    if(typeMultIn <= 2) {
      typeMult = 1;
    }
    else {
      typeMult = 2;
    }

    //type = (int)Math.pow(2, typeMult);

    for(Box b: boxes) {
      this.boxes.add(b.copy());
    }

    velocity = new PVector(0, 0);

    float xNow = (((p.width-(5*p.height/6))/2) + p.height/30);
    float yNow = p.height/12 + p.height/30;
    float yFactor = p.height/6 + p.height/30;

    float xStart = xNow + column*yFactor;
    float yStart = yNow + row*yFactor;

    position = new PVector(xStart, yStart);
    destination = new PVector(200, 200);

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

    p.fill(0, 50);
    p.rectMode(p.CORNER);
    p.rect(position.x, position.y, side, side);
    p.text("name " + name + " : " + "type " + type + ": (" + column + ", " + row + ")", x, y);
  }

  public void move(String direction) {
    //System.out.println(name + "'s original position: (" + row + ", " + column + ")");
    //System.out.println(name + " offLimits = " + offLimits);
    //System.out.println("");

    if(direction.equals("left") ) {
      while(column > 0 && checkCollide(direction).equals("no collide")) {
        column--;
        velocity.x = -1*vFactor;
        velocity.y = 0;
        //System.out.println("     " + name + ": " + checkCollide(direction));
      }

      if(checkCollide(direction).equals("same") && findSame(direction).offLimits() == false) {
        doges.remove(findSame(direction));
        column--;
        type = type*2;
        offLimits = true;
        velocity.x = -1*vFactor;
        velocity.y = 0;
      }
    }
    else if(direction.equals("right") ) {
      while(column < 3 && checkCollide(direction).equals("no collide") ) {
        column++;
        velocity.x = vFactor;
        velocity.y = 0;
        //System.out.println("     " + name + ": " + checkCollide(direction));
      }

      if(checkCollide(direction).equals("same") && findSame(direction).offLimits() == false) {
        doges.remove(findSame(direction));
        column++;
        type = type*2;
        offLimits = true;
        velocity.x = vFactor;
        velocity.y = 0;
      }
    }
    else if(direction.equals("up") ) {
      while(row > 0 && checkCollide(direction).equals("no collide")) {
        row--;
        velocity.x = 0;
        velocity.y = -1*vFactor;
        //System.out.println("     " + name + ": " + checkCollide(direction));
      }

      if(checkCollide(direction).equals("same")  && findSame(direction).offLimits() == false) {
        doges.remove(findSame(direction));
        row--;
        type = type*2;
        offLimits = true;
        velocity.x = 0;
        velocity.y = -1*vFactor;
      }
    }
    else if(direction.equals("down") ) {
      while(row < 3 && checkCollide(direction).equals("no collide") ) {
        row++;
        velocity.x = 0;
        velocity.y = vFactor;
        //System.out.println("     " + name + ": " + checkCollide(direction));

      }

      if(checkCollide(direction).equals("same")  && findSame(direction).offLimits() == false) {
        doges.remove(findSame(direction));
        row++;
        type = type*2;
        offLimits = true;
        velocity.x = 0;
        velocity.y = vFactor;
      }
    }

    //System.out.println(name + " moves to (" + row + ", " + column + ")");
    //System.out.println("");
    //System.out.println("#");
    //System.out.println("");

  }

  public String checkCollide(String direction) {
    int newColumn = column;
    int newRow = row;

    //System.out.println("other doges length: " + doges.size());
    //System.out.println("");

    //System.out.println("     " + name + "'s og row: " + row);
    //System.out.println("     " + name + "'s og column: " + column);
    //System.out.println("");

    //System.out.println("     " + name + "'s og newColumn: " + newColumn);
    //System.out.println("     " + name + "'s og newRow: " + newRow);
    //System.out.println("");

    if(direction.equals("right")) {
      newColumn++;
    }
    else if(direction.equals("left") ) {
      newColumn--;
    }
    else if(direction.equals("up")) {
      newRow--;
    }
    else if(direction.equals("down") ) {
      newRow++;
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

      else if(other.row() == newRow && other.column() == newColumn) {
        //System.out.println("     COLLIDE!");
        //System.out.println("");
        //System.out.println("     *");
        //System.out.println("");

        if(other.type() == type) {
          //System.out.println(name + ": " + "same");
          return "same";
        }

        //System.out.println(name + ": " + "collide with " + other.name());
        return "collide with " + other.name();
      }

      //System.out.println("");
      //System.out.println("     *");
      //System.out.println("");

    }

    //System.out.println(name + ": " + "no collide");
    return "no collide";
  }

  public boolean checkCollide() {
    //System.out.println("     " + name);
    for(Doge other: doges) {
      //System.out.println("");
      //System.out.println(other.name() + ": ");
      //System.out.println("row = " + row + " - " + other.row());
      //System.out.println("column = " + column + " - " + other.column());
      if(other.equals(this)) {
      }

      else if(other.row() == row && other.column() == column) {
        //System.out.println("      COLLIDE");
        return true;
      }
    }

    //System.out.println("      NO COLLIDE");
    return false;
  }

  public void newDoge() {
    Box get = boxes.get((int)p.random(0, boxes.size()));
    row = get.row();
    column = get.column();

    float xNow = (((p.width-(5*p.height/6))/2) + p.height/30);
    float yNow = p.height/12 + p.height/30;
    float yFactor = p.height/6 + p.height/30;

    float xStart = xNow + column*yFactor;
    float yStart = yNow + row*yFactor;

    position = new PVector(xStart, yStart);

    boxes.remove(get);
  }

  public ArrayList<Box> boxes() {
    return boxes;
  }

  public int name() {
    return name;
  }

  public Doge findSame(String direction) {
    int newColumn = column;
    int newRow = row;

    //System.out.println("other doges length: " + doges.size());
    //System.out.println("");

//    System.out.println("     " + name + "'s og row: " + row);
//    System.out.println("     " + name + "'s og column: " + column);
    //System.out.println("");

//    System.out.println("     " + name + "'s og newColumn: " + newColumn);
//    System.out.println("     " + name + "'s og newRow: " + newRow);
    //System.out.println("");

    if(direction.equals("right")) {
      newColumn++;
    }
    else if(direction.equals("left") ) {
      newColumn--;
    }
    else if(direction.equals("up")) {
      newRow--;
    }
    else if(direction.equals("down") ) {
      newRow++;
    }

    //System.out.println(name + "'s new xBit: " + xBit);
    //System.out.println(name + "'s new yBit: " + yBit);
    //System.out.println("");

    for(Doge other: doges) {
    //  System.out.println("     OTHER " + other.name() + "'s row: " + other.row());
    //  System.out.println("     OTHER " + other.name() + "'s column: " + other.column());

      if(other.equals(this)) {
        //System.out.println("");
        //System.out.println("     *");
        //System.out.println("");
      }

      else if(other.row() == newRow && other.column() == newColumn) {
      //  System.out.println("     COLLIDE!");
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

  public void selectRowColumn() {
    row = (int)p.random(0, 4);
    column = (int)p.random(0, 4);
  }

  public int type() {
    return type;
  }

  public boolean offLimits() {
    return offLimits;
  }

  public void setOffLimits() {
    offLimits = false;
  }

  public float destinationX() {
    return destination.x;
  }

  public float destinationY() {
    return destination.y;
  }

  public float positionX() {
    return position.x;
  }

  public float positionY() {
    return position.y;
  }

  public PVector position() {
    return position;
  }

  public PVector destination() {
    return destination;
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

  protected boolean offLimits;

  protected PVector velocity;
  protected PVector position;
  protected PVector destination;

  protected int vFactor;

}
