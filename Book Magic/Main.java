import processing.core.*;
import java.util.*;

public class Main extends PApplet {

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    background(0);
    book = new Book(this);
    flowers = new ArrayList<Flower>();
    flowerIndex = 0;
  }

  public void draw() {
    background(0);
    for(Flower f: flowers) {
      f.display();
    }
    book.display((double)width/2, (double)7*height/8, (int)width, (int)height);
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
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  private Book book;
  private ArrayList<Flower> flowers;
  private int flowerIndex;
}
