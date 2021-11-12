import processing.core.*;

public class Book {

  public Book(PApplet p) {
    this.p = p;
    book = p.loadImage("book.png");
    p.imageMode(PApplet.CENTER);
  }

  public void display(double x, double y, int width, int length) {
    book.resize(width/2, length/8);
    p.image(book, (float)x, (float)y);
  }

  private PImage book;
  private PApplet p;
}
