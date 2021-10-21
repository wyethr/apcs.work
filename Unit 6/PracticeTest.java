import processing.core.*;

public class PracticeTest {

  public PracticeTest(PApplet p) {
    this.p = p;
    this.x = p.random(0, p.width);
    this.y = p.random(0, p.height);
    this.r = p.random(0, 10);
  }

  void update() {
    r = r + 10;
  }

  void display() {
    p.ellipse(x, y, r, r);
  }

  private PApplet p;

  private float x;
  private float y;

  private float r;
}
