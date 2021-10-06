public class StringMatch {

  public static int stringMatch(String a, String b) {
    int counter = 0;
    String c;

    if(a.length() < b.length()) {
      c = a;
    }
    else {
      c = b;
    }

    for(int i = c.length() - 2; i >= 0; i--) {
      if(a.substring(i, i + 2).equals(b.substring(i, i+2)))
          counter++;
    }

    return counter;
  }

  public static void testStringMatch(String a, String b, int expected) {
    int result = stringMatch(a, b);

    System.out.println("a: " + a +
                      " b: " + b +
                      " expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("Riley ayo!");
    }
    else {
      System.out.println("Riley ayo?");
    }

    System.out.println("");

  }

  public static void main(String[] args) {
    testStringMatch("xxcaazz", "xxbaaz", 3);
    testStringMatch("abc", "abc", 2);
    testStringMatch("abc", "axc", 0);
  }
}
