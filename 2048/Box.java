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

  public boolean checkCollide(Doge other) {

    if(other.x() >= x && other.x() <= x + side && other.y() >= y && other.y() <= y + side) {
      return true;
    }

    return false;

  }

  private PApplet p;
  private float x;
  private float y;
  private float side;

}
