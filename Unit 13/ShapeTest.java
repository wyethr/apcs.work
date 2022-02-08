public class ShapeTest {

  public static void main(String[] args) {
    Shape circle = new Shape("circle", 0);
    Shape square = new Shape("square", 4);
    Shape triangle = new Shape("triangle", 3);

    System.out.println("circle.name() = " + circle.name());
    System.out.println("circle.side() = " + circle.side());
    System.out.println("");

    ShapeCollection test1 = new ShapeCollection();
    test1.addShape(circle);
    test1.addShape(square);
    test1.addShape(triangle);

    System.out.println("test1's shapes: ");
    for(Shape d: test1.shapes()) {
      System.out.println(d.name());
    }

    System.out.println("");

    System.out.println("square's sides = " + test1.numberOfSides("square"));
    System.out.println("");

    System.out.println("test1's average number of sides = " + test1.averageNumberOfSides());
    System.out.println("");

    System.out.println("test1's even shapes: ");
    for(Shape f: test1.evenShapes()) {
      System.out.println(f.name());
    }
  }
}
