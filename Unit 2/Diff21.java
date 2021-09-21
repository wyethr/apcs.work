public class Diff21 {

  public static int diff21(int n) {
    if(n > 21) {
      return (21 - n)*2;
    }
    else {
      return 21-n;
    }
  }

  public static void testDiff21(int n, int expected) {
    int result = diff21(n);

    System.out.println("n: " + n +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("success!");
    }
    else {
      System.out.println("whoopsies");
    }
  }

  public static void main(String[] args) {
    System.out.println("for diff(19) -");
    testDiff21(19, 2);
    System.out.println("");

    System.out.println("for diff(10) -");
    testDiff21(10, 11);
    System.out.println("");

    System.out.println("for diff(21) -");
    testDiff21(21, 0);
    System.out.println("");
  }

}
