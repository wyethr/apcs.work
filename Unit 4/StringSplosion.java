public class StringSplosion {

  public static String stringSplosion(String string) {
    String counter = "";

    for(int i = 0; i < string.length(); i++) {
      counter = counter + string.substring(0, i + 1);
    }

    return counter;
  }

  public static void testStringSplosion(String string, String expected) {
    String result = stringSplosion(string);

    System.out.println("string: " + string +
                      " result: " + result +
                      " expected: " + expected);

    if(result.equals(expected))
      System.out.println("Riley has fun after school!");
    else
      System.out.println("Riley misses her serve");

    System.out.println("");
  }

  public static void main(String[] args) {
    testStringSplosion("Code", "CCoCodCode");
    testStringSplosion("abc", "aababc");
    testStringSplosion("ab", "aab");
  }

}
