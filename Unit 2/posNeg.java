public class PosNeg {

  public static boolean posNeg(int a, int b, boolean negative) {
    if(negative == false && a > 0 && b < 0) {
      return true;
    }
    else if(negative == false && a < 0 && b > 0) {
      return true;
    }
    else if(negative == true && a < 0 && b < 0) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testPosNeg(int a, int b, boolean negative, boolean expected) {
    boolean result = posNeg(a, b, negative);

    System.out.println("a: " + a +
                      " b: " + b +
                      " negative: " + negative +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("nice going!");
    }
    else {
      System.out.println("nice goin- nah, jk haha");
    }
  }

  public static void main(String[] args) {
    testPosNeg(1, -1, false, true);
    System.out.println("");

    testPosNeg(-1, 1, false, true);
    System.out.println("");

    testPosNeg(-4, -5, true, true);
    System.out.println("");
  }
}
