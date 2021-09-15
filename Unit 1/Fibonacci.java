public class Fibonacci {
  public static void find() {
    int a = 1, b = 1, c;
    System.out.println(a);
    System.out.println(b);

    for(int i = 0; i < 10; i++) {
      c = a + b;
      System.out.println(c);

      a = b;
      b = c;
    }
  }

  public static void main(String[] args) {
    find();
  }
}
