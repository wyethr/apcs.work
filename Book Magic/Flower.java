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
    randomX = (float)p.random(-1f, 1f);
    xPositions = new ArrayList<Float>();
    yPositions = new ArrayList<Float>();

    stemRadius = (float)p.random(5*width/1000, 10*width/1000);

    centerRadius = (float)p.random(stemRadius, stemRadius*2);
    centerMax = (float)p.random(stemRadius, stemRadius*10);

    petalCount = (int)p.random(4, 20);
    petalAngle = (float)360/petalCount;
    petalWidth = (float)(2*centerRadius*3.14159)/petalCount;
    petalMaxW = (float)((petalWidth/centerRadius)*(2*centerMax*3.14159)/petalCount);
    petalLength = (float)p.random(centerRadius*2, centerRadius*5);
    petalMaxL = (float)(petalLength*centerMax/centerRadius);
    petalR = (int)p.random(0, 255);
    petalB = (int)p.random(0, 255);
    petalG = (int)p.random(0, 255);
    petalLayer = (int)p.random(0, 4);
  }

  public void display() {
    p.noStroke();
    p.fill(24, 103, 47);
    p.pushMatrix();
    p.translate(translateX, translateY);
    for(int i = 0; i < xPositions.size(); i++) {
      p.ellipse(xPositions.get(i), yPositions.get(i), stemRadius, stemRadius);
    }

    p.pushMatrix();
    p.translate(x, y);
    p.fill(petalR, petalB, petalG);

    for(int i = 1; i <= petalCount; i++) {
      p.ellipse(0, 0, petalWidth, petalLength);
      p.rotate((float)p.radians(petalAngle));
    }

    p.popMatrix();

    //PETAL LAYER STUFF I HAD TO DITCH BC YOU CAN'T PUSH/POP MATRIX > 32 TIMES
//    if(petalLayer > 1) {
//      for(int i = 1; i <= petalLayer; i++) {
//        p.pushMatrix();
//        p.translate(x, y);
//        petalR = (int)p.random(0, 255);
//        petalB = (int)p.random(0, 255);
//        petalG = (int)p.random(0, 255);
//        p.fill(petalR, petalB, petalG);
//        p.rotate((float)(1/2*360/petalCount));
//
//        for(int j = 1; j <= petalCount; j++) {
//          p.ellipse(0, 0, petalWidth, petalLength);
//          p.rotate((float)p.radians(petalAngle));
//        }
//      }
//    }

    p.fill(255, 219, 75);
    p.ellipse(x, y, centerRadius, centerRadius);

    p.popMatrix();
  }

  public void grow() {
    t += 0.5;
    y = y - p.noise(t)*(float)5;
    yPositions.add(y);
    x = x + ((p.noise(t + 1000)+randomX));
    xPositions.add(x);

    if(centerRadius < centerMax && t > 5) {
      centerRadius = centerRadius+centerMax/100;

      petalWidth = petalWidth + petalMaxW/100;
      petalLength = petalLength + petalMaxL/100;
    }
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
  private float width;
  private float height;

  private float stemRadius;

  private float centerRadius;
  private float centerMax;

  private int petalCount;
  private float petalAngle;
  private float petalWidth;
  private float petalLength;
  private float petalMaxW;
  private float petalMaxL;
  private int petalR;
  private int petalB;
  private int petalG;
  private int petalLayer;
}
