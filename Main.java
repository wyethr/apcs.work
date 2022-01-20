import java.util.*;
import processing.core.*;


public class Main extends PApplet {

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    background(255);
  }

  public void draw() {
    //drawing the background:

    rectMode(CENTER);

    rect(width/2, height/2, 4*height/5, 4*width/5);
  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }
}
