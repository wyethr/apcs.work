public class MonkeyTrouble {

  public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    if(aSmile == true && bSmile == true) {
      return true;
    }
    else if(aSmile == false && bSmile == false) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testMonkeyTrouble(boolean aSmile, boolean bSmile, boolean expected) {
    boolean result = monkeyTrouble(aSmile, bSmile);

    System.out.println("aSmile: " + aSmile +
                      " bSmile: " + bSmile +
                      " expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("YAYYY");
    }
    else {
      System.out.println("LESS YAYYY");
    }
  }

  public static void main(String[] args) {
    testMonkeyTrouble(true, true, true);
    System.out.println("");

    testMonkeyTrouble(false, false, true);
    System.out.println("");

    testMonkeyTrouble(true, false, false);
    System.out.println("");
  }
}
