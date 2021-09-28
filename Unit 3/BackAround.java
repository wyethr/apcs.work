public class BackAround {

  public static String backAround(String str) {
    String lastletter = str.substring(str.length() - 1);
    String newstr = lastletter + str + lastletter;

    return newstr;
  }

  public static void testBackAround(String str, String expected) {
    String result = backAround(str);

    System.out.println("string: " + str +
                      " expected: " + expected +
                      " result: " + result);

    if(expected.equals(result)) {
      System.out.println("omg look riley's legit jumping");
    }
    else {
      System.out.println("oop and now riley flopped");
    }
  }

  public static void main(String[] args) {
    testBackAround("cat", "tcatt");
    System.out.println("");

    testBackAround("Hello", "oHelloo");
    System.out.println("");

    testBackAround("a", "aaa");
    System.out.println("");
  }
}
