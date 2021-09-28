public class MissingChar {

  public static String missingChar(String str, int n) {
    String newstr = new String(str.substring(0, n) + str.substring(n + 1, str.length()));

    return newstr;
  }

  public static void testMissingChar(String str, int n, String expected) {
    String result = missingChar(str, n);

    System.out.println("string: " + str +
                      " n: " + n +
                      " expected: " + expected +
                      " result: " + result);

    if(expected.equals(result)) {
      System.out.println("riley smiles :)");
    }
    else {
      System.out.println("riley frowns :(");
    }
  }

  public static void main(String[] args) {
    testMissingChar("kitten", 1, "ktten");
    System.out.println("");

    testMissingChar("kitten", 0, "itten");
    System.out.println("");

    testMissingChar("kitten", 4, "kittn");
  }

}
