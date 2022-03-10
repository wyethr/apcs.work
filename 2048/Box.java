import processing.core.*;
import java.util.*;

public class Box {

  public Box(PApplet p, int row, int column, float side) {
    this.p = p;
    this.row = row;
    this.column = column;
    this.side = side;

    float xNow = (((p.width-(5*p.height/6))/2) + p.height/30);
    float yNow = p.height/12 + p.height/30;
    float yFactor = p.height/6 + p.height/30;

    x = xNow + column*yFactor;
    y = yNow + row*yFactor;
  }

  public int row() {
    return row;
  }

  public int column() {
    return column;
  }

  public float side() {
    return side;
  }

  public float x() {
    return x;
  }

  public float y() {
    return y;
  }

  public void display() {
    p.fill(255);
    p.rectMode(p.CORNER);
    p.rect(x, y, side, side);
  }

  public Box copy() {
    return new Box(p, row, column, side);
  }

  private PApplet p;

  private int row;
  private int column;
  private float side;

  private float x;
  private float y;
}
