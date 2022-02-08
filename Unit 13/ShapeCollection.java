import java.util.*;

public class ShapeCollection {

  public ShapeCollection() {
    shapes = new ArrayList<Shape>();
  }

  public void addShape(Shape s) {
    shapes.add(s);
  }

  public ArrayList<Shape> shapes() {
    return shapes;
  }

  public int numberOfSides(String shapeName) {
    for(Shape d: shapes) {
      if(shapeName.equals(d.name())) {
        return d.side();
      }
    }

    return 999;
  }

  public double averageNumberOfSides() {
    double count = 0;

    for(Shape d: shapes) {
      count = count + (double)d.side();
    }

    return count/shapes.size();
  }

  public ArrayList<Shape> evenShapes() {
    ArrayList<Shape> count = new ArrayList<Shape>();

    for(Shape d: shapes) {
      if(d.side()%2 == 0) {
        count.add(d);
      }
    }

    return count;
  }

  protected ArrayList<Shape> shapes;
}
