import java.util.*;

public class ReverseAll {

  // lol i didn't wanna write a reverse() function so instead i tried this.

  public static ArrayList<String> reverseAll(ArrayList<String> strings) {
    ArrayList<String> stringCount = new ArrayList<String>();
    String count = "";

    for(String s: strings) {
      count = s.substring(s.length());
      for(int i = s.length() - 1; i >= 0; i--) {
        count = count + s.substring(i, i+1);
      }
      stringCount.add(count);
      System.out.println(count);
      count = "";
    }

    return stringCount;
  }

  public static void testReverseAll(ArrayList<String> strings, ArrayList<String> expected) {
    ArrayList<String> result = reverseAll(strings);
    int testFactor = 1;

    System.out.println("result: " + result);
    System.out.println("expected: " + expected);

    if(expected.equals(result)) {
      System.out.println("ruwu's code gets fixeddd");
    }
    else {
      System.out.println("ruwu's code doesn't get fixed");
    }
  }

  public static void main(String[] args) {
    ArrayList<String> test1 = new ArrayList<String>();
    test1.add("abcd");
    test1.add("xyz");
    ArrayList<String> expected1 = new ArrayList<String>();
    expected1.add("dcba");
    expected1.add("zyx");
    testReverseAll(test1, expected1);
    System.out.println("");

    ArrayList<String> test2 = new ArrayList<String>();
    test2.add("1234");
    test2.add("5678");
    ArrayList<String> expected2 = new ArrayList<String>();
    expected2.add("4321");
    expected2.add("8765");
    testReverseAll(test2, expected2);

  }
}
