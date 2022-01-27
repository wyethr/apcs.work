import java.util.*;

public class Rectangle {

  public Rectangle(String name, double width, double height) {
    this.name = name;
    this.width = width;
    this.height = height;
  }

  public String name() {
    return name;
  }

  public String toString() {
    return name + " hello";
  }

  public double width() {
    return width;
  }

  public double height() {
    return height;
  }

  public double perimeter() {
    return 2*height + 2*width;
  }

  public double area() {
    return height*width;
  }

  private String name;

  private double width;
  private double height;
}
