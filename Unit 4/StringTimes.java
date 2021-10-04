public class StringTimes {

  public static String stringTimes(String string, int n) {
    int i = 1;
    String resulting = string;

    while (i < n) {
      resulting = resulting + string;
      i++;
    }

    return resulting;
  }

  public static void testStringTimes(String string, int n, String expected) {
    String result = stringTimes(string, n);

    System.out.println("string: " + string +
                      " int n: " + n +
                      " expected: " + expected +
                      " result: " + result);

    if(result.equals(expected)) {
      System.out.println("riley is grinning omg");
    }
    else {
      System.out.println("nuhuh riley is not grinning no siree");
    }
  }

  public static void main(String[] args) {
    testStringTimes("Hi", 2, "HiHi");
    System.out.println("");

    testStringTimes("Hi", 3, "HiHiHi");
    System.out.println("");

    testStringTimes("Hi", 1, "Hi");
  }
}
