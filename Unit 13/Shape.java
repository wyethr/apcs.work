public class Shape {

  public Shape(String name, int side) {
    this.name = name;
    this.side = side;
  }

  public String name() {
    return name;
  }

  public int side() {
    return side;
  }

  protected String name;
  protected int side;
}
