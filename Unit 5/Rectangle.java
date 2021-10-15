public class Rectangle {

  public Rectangle(double baseIn, double heightIn) {
    base = baseIn;
    height = heightIn;
  }

  public double base() {
    return base;
  }

  public double height() {
    return height;
  }

  public double area() {
    return base*height;
  }

  public double perimeter() {
    return 2*base + 2*height;
  }

  public double diagnolLength() {
    return Math.sqrt(base*base + height*height);
  }

  private double base;
  private double height;
}
