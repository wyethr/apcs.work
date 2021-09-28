public class MixStart {

  public static boolean mixStart(String string) {
    String mix = "ix";

    if(string.substring(1, 3).equals(mix)) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testMixStart(String string, Boolean expected) {
    Boolean result = mixStart(string);

    System.out.println("string: " + string +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("woooo");
    }
    else {
      System.out.println("boooo");
    }
  }

  public static void main(String[] args) {
    testMixStart("mix snacks", true);
    System.out.println("");

    testMixStart("pix snacks", true);
    System.out.println("");

    testMixStart("piz snacks", false);
    System.out.println("");
  }
}
