public class Vampire {

  public static boolean isVampire(float hour, boolean awake) {
    if(hour > 6 && hour < 22 && awake == false) {
      return true;
    }
    else if (hour < 6 && awake == true) {
      return true;
    }
    else if (hour > 22 && awake == true) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testIsVampire(float hour, boolean awake, boolean expected) {
    boolean result = isVampire(hour, awake);

    System.out.println("hour: " + hour +
                      " awake: " + awake +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("nice job hon <3");
    }
    else {
      System.out.println("aw, try again :(");
    }
  }

  public static void main(String[] args) {
    testIsVampire(6.5f, false, true);
    System.out.println("");

    testIsVampire(6.5f, true, false);
    System.out.println("");

    testIsVampire(5f, true, true);
    System.out.println("");

    testIsVampire(22.01f, true, true);
    System.out.println("");

    testIsVampire(24f, false, false);
    System.out.println("");

    testIsVampire(4f, false, false);
    System.out.println("");
  }
}
