import java.util.*;
import processing.core.*;

public class ScoreAdd {

  public ScoreAdd(Main p) {
    this.p = p;

    x = p.scoreX() + p.height/12;
    y = p.scoreY() + p.height/48;
  }

  public void display() {
    p.text("+ 123", x, y);
  }

  protected Main p;

  protected float x;
  protected float y;

}
