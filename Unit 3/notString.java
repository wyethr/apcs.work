public class NotString{

  public static String notString(String string) {
    String check = "not";

    if (string.length() < 3) {
      return check + " " + string;
    }
    else if(string.substring(0, 3).equals(check)) {
      return string;
    }
    else {
      return check + " " + string;
    }
  }

  public static void testNotString(String string, String expected) {
    String result = notString(string);

    System.out.println("string: " + string +
                      " expected: " + expected +
                      " result: " + result);

    if(expected.equals(result)) {
      System.out.println("whoooop");
    }
    else {
      System.out.println("nooooop");
    }
  }

  public static void main(String[] args) {
    testNotString("candy", "not candy");
    System.out.println("");

    testNotString("x", "not x");
    System.out.println("");

    testNotString("not bad", "not bad");
  }
}
