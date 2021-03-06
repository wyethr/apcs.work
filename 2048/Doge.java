import java.util.*;
import processing.core.*;
import processing.sound.*;

public class Doge {

  public Doge(Main p, float side, ArrayList<Doge> doges, ArrayList<Box> boxes, int name) {
    this.p = p;
    this.width = width;
    this.height = height;
    this.side = side;
    this.doges = doges;
    this.boxes = new ArrayList<Box>();
    this.name = name;

    offLimits = false;

    selectRowColumn();

    selectType();

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

    vFactor = 50;

    offLimitsMerge = false;

    image = p.loadImage(type + ".png");
    image.resize((int)side, (int)side);

    System.out.println(name + ": " + typeLetter());
    say = new SoundFile(p, typeLetter() + ".wav");

    played = false;

  }

  public Doge(Main p, float side, ArrayList<Doge> doges, ArrayList<Box> boxes, int name, int column, int row, int type) {
    this.p = p;
    this.width = width;
    this.height = height;
    this.side = side;
    this.doges = doges;
    this.boxes = new ArrayList<Box>();
    this.name = name;

    offLimits = false;


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

    vFactor = 50;

    offLimitsMerge = false;

    this.type = type;
    this.row = row;
    this.column = column;

    System.out.println(name + ": " + type);

    image = p.loadImage(type + ".png");
    image.resize((int)side, (int)side);

    say = new SoundFile(p, typeLetter() + ".wav");

    played = false;
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
    p.imageMode(p.CORNER);

    float xNow = (((p.width-(5*p.height/6))/2) + p.height/30);
    float yNow = p.height/12 + p.height/30;
    float yFactor = p.height/6 + p.height/30;

    x = xNow + column*yFactor;
    y = yNow + row*yFactor;

    destination.x = x;
    destination.y = y;

    if(position.dist(destination) < vFactor) {
      velocity.x = 0;
      velocity.y = 0;

      position.x = x;
      position.y = y;
    }

    //System.out.println(name + " is checkCollide = " + checkCollide());
    if(checkCollide().equals("same")) {
      //System.out.println(name + " is colliding with " + findSame().name());
      //System.out.println("    " + name + " is offLimitsMerge() " + offLimitsMerge);
      //System.out.println("    " + findSame().name() + " is offLimitsMerge() " + findSame().offLimitsMerge);
    }
    if(checkCollide().equals("same") && findSame().offLimitsMerge() == false) {
      //System.out.println(name + " is offLimits = " + offLimits);

      offLimits = true;

      Doge findSame = findSame();

      p.moving = true;

      //System.out.println(findSame.position().dist(position));

      //System.out.println("    " + findSame.position().dist(position) + " - " + vFactor);

      if(findSame.position().dist(position) <= vFactor) {
        doges.remove(findSame);
        //System.out.println("REMOVED " + findSame.name());
        type++;
        say = new SoundFile(p, typeLetter() + ".wav");
        p.updateScore(type);
        offLimitsMerge = true;

        image = p.loadImage(type + ".png");
        image.resize((int)side, (int)side);

        p.moving = false;
      }
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

    if(p.mouseX >= position.x && p.mouseX <= position.x + side && p.mouseY >= position.y && p.mouseY <= position.y + side) {
      p.fill(p.backgroundColor);
      p.rectMode(p.CORNER);
      p.rect(position.x, position.y, side, side);
      p.fill(255);
      p.textSize(3*side/4);
      p.textAlign(p.CENTER, p.CENTER);
      p.text(typeLetter(), position.x + side/2, position.y + side/2 - (float).125*p.textAscent());
      if(played == false) {
        played = true;
        say.cue(0);
        say.play();
      }
    }
    else {
      played = false;
      p.fill(255);
      p.rectMode(p.CORNER);
      p.rect(position.x, position.y, side, side);
      p.image(image, position.x, position.y);
      //p.text("name " + name + " : " + "type " + type + ": (" + column + ", " + row + ")", x, y);
    }

  }

  public void move(String direction) {
    //System.out.println(name + "'s original position: (" + row + ", " + column + ")");
    //System.out.println(name + " offLimits = " + offLimits);
    //System.out.println("");

    if(velocity.x == 0 && velocity.y == 0) {
      //System.out.println("     " + name + ": " + checkCollide(direction));

      if(direction.equals("left") ) {
        while(column > 0 && checkCollide(direction).equals("no collide")) {
          column--;
          velocity.x = -1*vFactor;
          velocity.y = 0;
          //System.out.println("     " + name + ": " + checkCollide(direction));
        }

        while(column > 0 && checkCollide(direction).equals("same") && findSameTo(direction).offLimits == false) {
          //System.out.println(name + " is moving up to same");
          offLimits = true;
          findSameTo(direction).offLimits = true;
          column--;
          velocity.x = -1*vFactor;
          velocity.y = 0;
          //System.out.println("     " + name + ": " + checkCollide(direction));
        }

      }
      else if(direction.equals("right") ) {
        while(column < 3 && checkCollide(direction).equals("no collide") ) {
          column++;
          velocity.x = vFactor;
          velocity.y = 0;
          //System.out.println("     " + name + ": " + checkCollide(direction));
        }

        while(column < 3 && checkCollide(direction).equals("same") && findSameTo(direction).offLimits == false) {
          //System.out.println(name + " is moving up to same");
          offLimits = true;
          findSameTo(direction).offLimits = true;
          column++;
          velocity.x = vFactor;
          velocity.y = 0;
          //System.out.println("     " + name + ": " + checkCollide(direction));
        }
      }
      else if(direction.equals("up") ) {
        while(row > 0 && checkCollide(direction).equals("no collide")) {
          row--;
          velocity.x = 0;
          velocity.y = -1*vFactor;
          //System.out.println("     " + name + ": " + checkCollide(direction));
        }

        while(row > 0 && checkCollide(direction).equals("same") && findSameTo(direction).offLimits == false) {
          //System.out.println(name + " is moving up to same");
          offLimits = true;
          findSameTo(direction).offLimits = true;
          row--;
          velocity.x = 0;
          velocity.y = -1*vFactor;
          //System.out.println("     " + name + ": " + checkCollide(direction));
        }
      }
      else if(direction.equals("down") ) {
        while(row < 3 && checkCollide(direction).equals("no collide") ) {
          row++;
          velocity.x = 0;
          velocity.y = vFactor;
          //System.out.println("     " + name + ": " + checkCollide(direction));

        }

        while(row < 3 && checkCollide(direction).equals("same") && findSameTo(direction).offLimits == false) {
          //System.out.println(name + " is moving up to same");
          offLimits = true;
          findSameTo(direction).offLimits = true;
          row++;
          velocity.x = 0;
          velocity.y = vFactor;
          //System.out.println("     " + name + ": " + checkCollide(direction));

        }
      }

      //System.out.println(name + " moves to (" + row + ", " + column + ")");
      //System.out.println("");
      //System.out.println("#");
      //System.out.println("");

    }
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

        if(other.type() == type && other.type() != 26) {
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

  public String checkCollide() {
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
        if(other.type() == type && type != 26) {
          return "same";
        }

        return "collide";
      }
    }

    //System.out.println("      NO COLLIDE");
    return "no collide";
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

  public Doge findSame() {
    for(Doge other: doges) {
      if(other.equals(this)) {
      }
      else if(other.row() == row && other.column == column) {
        return other;
      }
    }

    return null;
  }

  public Doge findSameTo(String direction) {
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

  public void selectType() {
    int a = 1;
    int b = 2;

    if(p.highestOnBoard() >= 16) {
      for(int i = 0; i < p.highestOnBoard() - 15; i++) {
        a++;
        b++;
      }
    }

    int typeMultIn = (int)p.random(0, 10);

    if(typeMultIn >= 2) {
      type = a;
    }
    else {
      type = b;
    }
  }

  public void selectRowColumn() {
    row = (int)p.random(0, 4);
    column = (int)p.random(0, 4);
  }

  public String typeLetter() {
    if(type == 1) {
      return "A";
    }
    else if(type == 2) {
      return "B";
    }
    else if(type == 3) {
      return "C";
    }
    else if(type == 4) {
      return "D";
    }
    else if(type == 5) {
      return "E";
    }
    else if(type == 6) {
      return "F";
    }
    else if(type == 7) {
      return "G";
    }
    else if(type == 8) {
      return "H";
    }
    else if(type == 9) {
      return "I";
    }
    else if(type == 10) {
      return "J";
    }
    else if(type == 11) {
      return "K";
    }
    else if(type == 12) {
      return "L";
    }
    else if(type == 13) {
      return "M";
    }
    else if(type == 14) {
      return "N";
    }
    else if(type == 15) {
      return "O";
    }
    else if(type == 16) {
      return "P";
    }
    else if(type == 17) {
      return "Q";
    }
    else if(type == 18) {
      return "R";
    }
    else if(type == 19) {
      return "S";
    }
    else if(type == 20) {
      return "T";
    }
    else if(type == 21) {
      return "U";
    }
    else if(type == 22) {
      return "V";
    }
    else if(type == 23) {
      return "W";
    }
    else if(type == 24) {
      return "X";
    }
    else if(type == 25) {
      return "Y";
    }
    else if(type == 26) {
      return "Z";
    }
    else {
      return "";
    }
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

  public boolean remove() {
    return remove;
  }

  public boolean offLimitsMerge() {
    return offLimitsMerge;
  }

  public void setOffLimitsMerge() {
    offLimitsMerge = false;
  }

  protected Main p;

  protected ArrayList<Box> boxes;

  protected float width;
  protected float height;
  protected float side;

  protected int row;
  protected int column;

  protected float x;
  protected float y;

  protected int type;

  protected ArrayList<Doge> doges;

  protected int name;

  protected boolean offLimits;

  protected PVector velocity;
  protected PVector position;
  protected PVector destination;

  protected int vFactor;

  protected boolean remove;
  protected boolean offLimitsMerge;

  protected PImage image;

  protected SoundFile say;
  protected boolean played;

}
