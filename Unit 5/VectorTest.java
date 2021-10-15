public class VectorTest {

  public static void main(String[] args) {
    Vector iIn = new Vector(1, 0);
    Vector iNo = new Vector(1, 0);
    Vector iMo = new Vector(1, 0);
    Vector i = new Vector(1, 0);
    Vector j = new Vector(0, 1);

    System.out.println("i's x = " + i.x());
    System.out.println("i's y = " + i.y());
    System.out.println("magnitude i = " + i.magnitude());
    System.out.println("direction i = " + i.direction());
    iIn.add(j);
    System.out.println("i + j = " + iIn.x() + ", " + iIn.y());
    iNo.scalarMultiply(2);
    System.out.println("i * 2 = " + iNo.x() + ", " + iNo.y());
    System.out.println("i * j = " + iMo.dotProduct(j));
    System.out.println("i - j = " + i.angle(j));
  }
}
