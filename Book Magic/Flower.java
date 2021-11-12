import processing.core.*;
import java.util.*;

public class Flower {

  public Flower(PApplet p, double xIn, double yIn, double hIn, double wIn) {
    this.p = p;
    t = 0;
    translateX = (float)xIn;
    translateY = (float)yIn;
    width = (float)wIn;
    height = (float)hIn;
    randomX = (float)p.random(-0.5f, 0.5f);

    System.out.println("translateX = " + translateX);
    System.out.println("translateY = " + translateY);
    System.out.println("width = " + width);
    System.out.println("height = " + height);
    System.out.println("startingX = " + startingX);
    System.out.println("startingY = " + startingY);
    stemRadius = 5;
    xPositions = new ArrayList<Float>();
    yPositions = new ArrayList<Float>();
  }

  public void display() {
    p.noStroke();
    p.fill(255);
    p.pushMatrix();
    p.translate(translateX, translateY);
    for(int i = 0; i < xPositions.size(); i++) {
      p.ellipse(xPositions.get(i), yPositions.get(i), stemRadius, stemRadius);
    }
    p.popMatrix();

  }

  public void grow() {
    t += 0.5;
    y = y - p.noise(t)*(float)5;
    System.out.println(y);
    yPositions.add(y);
    x = x + ((p.noise(t + 1000)-randomX));
    System.out.println(x);
    xPositions.add(x);
  }

  private PApplet p;
  private ArrayList<Float> xPositions;
  private ArrayList<Float> yPositions;
  private float randomX;
  private float startingX;
  private float startingY;
  private float translateX;
  private float translateY;
  private float x;
  private float y;
  private float t;
  private float stemRadius;
  private float width;
  private float height;
}
