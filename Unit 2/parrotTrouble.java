public class parrotTrouble {

  public static boolean parrotTrouble(boolean talking, int hour) {
    if(talking == true && hour < 7) {
      return true;
    }
    else if(talking == true && hour > 20) {
      return true;
    }
    else {
      return false;
    }

  }

  public static void testParrotTrouble(boolean talking, int hour, boolean expected) {
    boolean result = parrotTrouble(talking, hour);

    System.out.println("talking: " + talking +
                      " hour: " + hour +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("nice!");
    }
    else {
      System.out.println("whoopsies :(");
    }
  }

  public static void main(String[] args) {
    testParrotTrouble(true, 6, true);
    System.out.println("");

    testParrotTrouble(true, 7, false);
    System.out.println("");

    testParrotTrouble(false, 6, false);
    System.out.println("");
  }
}
