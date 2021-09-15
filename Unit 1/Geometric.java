public class Geometric {
  public static void find() {
    int a = 3;
    int b;

    for (int i = 0; i < 10; i++) {
      b = a*2;
      System.out.println(b);
      a = b;
    }
  }

  public static void main(String[] args) {
    System.out.println(3);
    find();
  }
}
