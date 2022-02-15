import processing.core.*;
import java.util.*;

public class Box {

  public Box(PApplet p, int row, int column, float side, float width, float height) {
    this.p = p;
    this.row = row;
    this.column = column;
    this.side = side;
    this.width = width;
    this.height = height;

    System.out.println("(" + row + ", " + column + ")");
    System.out.println("");

    x = 0;
    y = 0;
  }

  public float x() {
    return x;
  }

  public float y() {
    return y;
  }

  public void display() {
    float xNow = (((width-(5*height/6))/2) + height/30);
    float yNow = height/12 + height/30;
    float yFactor = height/6 + height/30;

    x = xNow + column*yFactor;
    y = yNow + row*yFactor;

    p.fill(255);
    p.rectMode(p.CORNER);
    p.rect(x, y, side, side);
  }

  public boolean checkCollide(Doge other) {

    if(other.x() >= x && other.x() <= x + side && other.y() >= y && other.y() <= y + side) {
      return true;
    }

    return false;

  }

  public Box copy() {
    return new Box(p, row, column, side, width, height);
  }

  private PApplet p;
  private float x;
  private float y;
  private float side;

  private int row;
  private int column;

  private float width;
  private float height;

}
