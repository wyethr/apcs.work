public class LoneTeen {

  public static boolean loneTeen(int a, int b) {
    if(13 <= a && a <= 19) {
      if(13 <= b && b <= 19) {
        return false;
      }
      else {
        return true;
      }
    }
    else if(13 <= b && b <= 19) {
      if(13 <= a && a <= 19) {
        return false;
      }
      else {
        return true;
      }
    }
    else {
      return false;
    }
  }

  public static void testLoneTeen(int a, int b, boolean expected) {
    boolean result = loneTeen(a, b);

    System.out.println("a: " + a +
                      " b: " + b +
                      " expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("successful, i'd say");
    }
    else {
      System.out.println("hmm... maybe not");
    }
  }

  public static void main(String[] args) {
    testLoneTeen(13, 99, true);
    System.out.println("");

    testLoneTeen(21, 19, true);
    System.out.println("");

    testLoneTeen(13, 13, false);
    System.out.println("");
  }
}
