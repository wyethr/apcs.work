public class FibonacciChallenge2 {

  public static void find() {
    float a = 1, b = 1;

    for (int i = 0; i < 10; i++) {
      System.out.println(a/b);

      b = a + b;
      a = b - a;
    }

  }

  public static void main(String[] args) {
    find();
  }
}
