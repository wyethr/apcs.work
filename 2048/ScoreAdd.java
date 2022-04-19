import java.util.*;
import processing.core.*;

public class ScoreAdd {

  public ScoreAdd(Main p, int amount) {
    this.p = p;

    x = p.scoreX() + p.height/12;
    y = p.scoreY();
    //y = p.scoreY() + p.height/48;

    this.amount = amount;

    length = 25;
    opacity = 255;
  }

  public void display() {
    p.textAlign(p.LEFT, p.BASELINE);
    p.fill(200, opacity);
    p.textSize(p.height/50);
    p.text("+ " + amount, x, y);
  }

  public void update() {
    opacity = opacity - 255/length;

    y = y - 10/length;
  }

  public float opacity() {
    return opacity;
  }

  protected Main p;

  protected float x;
  protected float y;

  protected int amount;

  protected float opacity;
  protected float length;

}
