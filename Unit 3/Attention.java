public class Attention {

  public static boolean attention(String input) {
    String test = "Hey, you!";

    if(input.substring(0, test.length()).equals(test)) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void testAttention(String input, boolean expected) {
    Boolean result = attention(input);

    System.out.println("input: " + input +
                      " result: " + result +
                      " expected: " + expected);

    if(expected == result) {
      System.out.println("Riley is happy now");
    }
    else {
      System.out.println("Riley is sad now");
    }
  }

  public static void main(String[] args) {
    testAttention("Hello, my name is Inigo Montoya.", false);
    System.out.println("");

    testAttention("Excuse me, Dr. Kessner?", false);
    System.out.println("");

    testAttention("Hey, you! Give me your code!", true);
    System.out.println("");
  }
}
