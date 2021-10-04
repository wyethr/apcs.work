public class DoubleX {

  public static boolean doubleX(String string) {

    for(int i = 0; i < string.length() - 1; i++) {
      if(string.substring(i, i+2).equals("xx")) {
        return true;
      }
    }

    return false;
  }

  public static void testDoubleX(String string, boolean expected) {

    boolean result = doubleX(string);

    System.out.println("string: " + string +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("riley wooo");
    }
    else {
      System.out.println("riley no wooo");
    }
  }

  public static void main(String[] args) {
    testDoubleX("axxbb", true);
    System.out.println("");

    testDoubleX("axaxax", false);
    System.out.println("");

    testDoubleX("xxxxx", true);
    System.out.println("");
  }
}
