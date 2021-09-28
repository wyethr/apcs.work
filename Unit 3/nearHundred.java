public class NearHundred {

  public static boolean nearHundred(double n) {
    if(Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testNearHundred(double n, boolean expected) {
    boolean result = nearHundred(n);

    System.out.println("n: " + n +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("yay nabbits!");
    }
    else {
      System.out.println("aw dang nabbits.");
    }
  }

  public static void main(String[] args) {
    testNearHundred(93, true);
    System.out.println("");

    testNearHundred(90, true);
    System.out.println("");

    testNearHundred(189, false);
    System.out.println("");
  }
}
