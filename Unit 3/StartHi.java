public class StartHi {

  public static boolean startHi(String string) {
    String check = "hi";

    if(string.substring(0, 2).equals(check)) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testStartHi(String string, Boolean expected) {
    Boolean result = startHi(string);

    System.out.println("string: " + string +
                      " result: " + result +
                      " expected: " + expected);

    if(result.equals(expected)) {
      System.out.println("nice going");
    }
    else {
      System.out.println("nice going, but sarcastic");
    }
  }

  public static void main(String[] args) {
    testStartHi("hi there", true);
    System.out.println("");

    testStartHi("hi", true);
    System.out.println("");

    testStartHi("hello hi", false);
    System.out.println("");
  }

}
