import processing.core.*;
import java.util.*;

public class Main extends PApplet {

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    background(0);
    book = new Book(this);
    flower = new Flower(this, (double)width/2, (double)7.25*height/8, height, width);
  }

  public void draw() {
    background(0);
    flower.display();
    book.display((double)width/2, (double)7*height/8, (int)width, (int)height);
  }

  public void keyPressed() {
    flower.grow();
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  private Book book;
  private Flower flower;

}
