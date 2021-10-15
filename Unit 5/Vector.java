public class Vector {

  public Vector(double xIn, double yIn) {
    x = xIn;
    y = yIn;
  }

  public double x() {
    return x;
  }

  public double y() {
    return y;
  }

  public double magnitude() {
    return Math.sqrt(x*x + y*y);
  }

  public double direction() {
    return Math.atan2(y, x);
  }

  public void add(Vector u) {
    x = u.x() + x;
    y = u.y() + y;
  }

  public void scalarMultiply(double k) {
    x = k*x;
    y = k*y;
  }

  public double dotProduct(Vector u) {
    return x*u.x() + y*u.y();
  }

  public double angle(Vector u) {
    return Math.acos(dotProduct(u)/u.magnitude()*magnitude());
  }

  private double x;
  private double y;
}
