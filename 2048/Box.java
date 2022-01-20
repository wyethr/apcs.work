import processing.core.*;
import java.util.*;

public class Box {

  public Box(PApplet p, float x, float y, float side) {
    this.p = p;
    this.x = x;
    this.y = y;
    this.side = side;
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

  private PApplet p;
  private float x;
  private float y;
  private float side;

}
