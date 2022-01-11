import processing.core.*;
import java.util.*;

public class Main extends PApplet {

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    background(255);
    book = new Book(this);
    flowers = new ArrayList<Flower>();
    flowerIndex = 0;
    leftOrRight = (int)random(0, 2)*2 - 1;
    upOrDown = -1;
    waveShow = 2;
  }

  public void draw() {

    background(255);
    for(Flower f: flowers) {
      f.display();

      if(waveShow == 1) {
        f.wave(3*f.getLength()/4, leftOrRight, upOrDown);
      }
    }

    book.display((double)width/2, (double)7*height/8, (int)width, (int)height);
    fill(255);
    rect(0, 7*height/8 + height/4, width, 7*height/8 + height/4, width, height, 0, height);
  }

  public void keyPressed() {
    if(keyCode == UP) {
      if(flowers.size() == 0) {
        Flower f = new Flower(this, (double)width/2, (double)7.25*height/8, width, height);
        flowers.add(f);
      }
      flowers.get(flowerIndex).grow();
    }
    else if(keyCode == RIGHT) {
      flowerIndex++;

      if(flowerIndex > flowers.size() - 1) {
        Flower f = new Flower(this, (double)width/2, (double)7.25*height/8, width, height);
        flowers.add(f);
      }

    }
    else if(keyCode == LEFT) {
      if(flowerIndex > 0) {
        flowerIndex--;
      }
    }
    else if(keyCode == SHIFT) {
      if(waveShow == 2)
        waveShow = 1;
      else {
        waveShow = 2;
      }
    }
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  private Book book;
  private ArrayList<Flower> flowers;
  private int flowerIndex;
  private int upOrDown;
  private int leftOrRight;
  private int waveShow;
}
