public class RectangleTest {

  public static void main(String[] args) {
    Rectangle test = new Rectangle(2, 5);

    System.out.println("base = " + test.base());
    System.out.println("height = " + test.height());
    System.out.println("area = " + test.area());
    System.out.println("perimeter = " + test.perimeter());
    System.out.println("diagnol length = " + test.diagnolLength());
  }
}
