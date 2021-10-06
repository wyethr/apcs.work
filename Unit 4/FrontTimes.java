public class FrontTimes {

  public static String frontTimes(String string, int n) {

    String counter = "";

    for(int i = 1; i <= n; i++) {
      if(string.length() < 3)
        counter = counter + string;
      else
        counter = counter + string.substring(0, 3);
    }

    return counter;
  }

  public static void testFrontTimes(String string, int n, String expected) {
    String result = frontTimes(string, n);

    System.out.println("string: " + string +
                      " n: " + n +
                      " expected: " + expected +
                      " result: " + result);

    if(expected.equals(result)) {
      System.out.println("HAPPY RILEY IMPLOSION! BECAUSE I ALREADY USED EXPLOSION!");
    }
    else {
      System.out.println("regular boring ole riley implosion");
    }

    System.out.println("");

  }

  public static void main(String[] args) {
    testFrontTimes("Chocolate", 2, "ChoCho");
    testFrontTimes("Chocolate", 3, "ChoChoCho");
    testFrontTimes("Abc", 3, "AbcAbcAbc");
    testFrontTimes("ab", 2, "abab");
  }
}
