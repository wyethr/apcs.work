public class FibonacciChallenge1 {

  public static void find() {
    int a = 1, b = 1;
    System.out.println(a);
    System.out.println(b);

    for(int i = 0; i < 10; i++) {
      System.out.println(a + b);
      b = a + b;
      a = b - a;
    }

  }

  public static void main(String[] args) {
    find();
  }
}
