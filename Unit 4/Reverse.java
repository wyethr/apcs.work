public class Reverse {

  public static String reverse(String string) {
    int i = string.length();
    String resulting = "";

    while(i >= 0) {
      if(i + 1 > string.length()) {
        resulting = string.substring(i);
      }
      else {
        resulting =  resulting + string.substring(i, i+1);
      }
      i--;
    }

    return resulting;
  }

  public static void testReverse(String string, String expected) {
    String result = reverse(string);

    System.out.println("string: " + string +
                      " expected: " + expected +
                      " result: " + result);

    if(result.equals(expected)) {
      System.out.println("Riley claps!");
    }
    else {
      System.out.println("Riley fails to bang her hands together - smh");
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    testReverse("bad", "dab");
    testReverse("Hello, world!", "!dlrow ,olleH");
    testReverse("tacocat", "tacocat");
    testReverse("dang", "gnad");
    testReverse("1!1", "1!1");
  }
}
