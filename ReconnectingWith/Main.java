import java.util.*;
import processing.core.*;

public class Main extends PApplet {

  public void settings() {
    size(600, 400);
  }

  public void setup() {
    background(255);

    PImage image = loadImage("1.JPG");
    String[] text = loadStrings("1.txt");
    image.resize(width, height);

    String[] words = split(text[0], " ");
    System.out.println("words length: " + words.length);

    float x = 0;
    float y = 0;
    int textSize = 12;
    textAlign(LEFT, TOP);

    for(int i = 0; i < words.length; i++) {
      fill(image.get((int)x, (int)y));
      text(words[i], x, y);
      //System.out.println("words[i] = " + words[i]);
      System.out.println("x: " + x);
      System.out.println("y: " + y);

      x = x + textWidth(words[i]) + 10;

      if(x > width) {
        x = 0 - random(0, 15);
        y = y + 12;
      }
    }

  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

}
