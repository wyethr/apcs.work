import processing.core.*;

public class Practice extends PApplet {

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    d = new PracticeTest(this);
  }

  public void draw() {
    d.update();
    d.display();
  }

  public static void main(String[] args) {
    PApplet.main("Practice");
  }

  private PracticeTest d;

}
