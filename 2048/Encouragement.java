import java.util.*;
import processing.core.*;

public class Encouragement {

  public Encouragement(Main p) {
    this.p = p;

    x = p.random(p.width/5, 4*p.width/5);
    y = p.random(p.height/5, 4*p.height/5);

    r = p.random(255);
    g = p.random(255);
    b = p.random(255);

    opacity = 1;
    opacityFactor = 15;

    word = setWord();
  }

  public void display() {
    p.textSize(p.height/20);
    p.fill(r, g, b, opacity);
    p.text(word, x, y);
  }

  public void update() {
    if(opacity >= 255) {
      opacityFactor = opacityFactor*-1;
    }

    opacity = opacity + opacityFactor;
  }

  public String setWord() {
    int decide = (int)p.random(10);
    if(decide == 1) {
      return "wahoo";
    }
    else if(decide == 2) {
      return "you're doing great";
    }
    else if(decide == 3) {
      return "loving it";
    }
    else if(decide == 4) {
      return "what a natural";
    }
    else if(decide == 5) {
      return "awesome";
    }
    else if(decide == 6) {
      return "perfection";
    }
    else if(decide == 7) {
      return "amazing";
    }
    else if(decide == 8) {
      return "wow";
    }
    else if(decide == 9) {
      return "beautiful work";
    }
    else if(decide == 10) {
      return "impressive";
    }
    else {
      return "nice job";
    }
  }

  public String word() {
    return word;
  }

  public float x() {
    return x;
  }

  public float y() {
    return y;
  }

  public float opacity() {
    return opacity;
  }

  protected Main p;

  private float x;
  private float y;

  private String word;

  private float r;
  private float g;
  private float b;

  private float opacity;
  private float opacityFactor;
}
