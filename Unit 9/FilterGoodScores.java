import java.util.*;

public class FilterGoodScores {

  public static ArrayList<Integer> filterGoodScores(ArrayList<Integer> values) {
    ArrayList<Integer> count = new ArrayList<Integer>();

    if(values.size() == 0) {
      count.add(0);
      return count;
    }

    for(int i: values) {
      if(i > 90) {
        count.add(i);
      }
    }

    return count;
  }

  public static void testFilterGoodScores(ArrayList<Integer> values, ArrayList<Integer> expected) {
    ArrayList<Integer> result = filterGoodScores(values);
    int testFactor = 1;

    System.out.println("expected: ");
    for(int e: expected) {
      System.out.println(e + " ");
    }

    System.out.println("result: ");
    for(int r: result) {
      System.out.println(r + " ");
    }

    if(expected.size() != result.size()) {
      testFactor = 0;
    }
    else {
      for(int i = 0; i < expected.size(); i++) {
        if(expected.get(i) != result.get(i)) {
          testFactor = 0;
        }
      }
  }

    if(testFactor == 1) {
      System.out.println("RUWAYOO");
    }
    else {
      System.out.println("runono :(");
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> test1 = new ArrayList<Integer>();
    test1.add(51);
    test1.add(52);
    test1.add(53);
    test1.add(100);
    ArrayList<Integer> expected1 = new ArrayList<Integer>();
    expected1.add(100);
    testFilterGoodScores(test1, expected1);
    System.out.println("");

    ArrayList<Integer> test2 = new ArrayList<Integer>();
    test2.add(92);
    test2.add(89);
    test2.add(90);
    test2.add(99);
    ArrayList<Integer> expected2 = new ArrayList<Integer>();
    expected2.add(92);
    expected2.add(99);
    testFilterGoodScores(test2, expected2);
    System.out.println("");

    ArrayList<Integer> test3 = new ArrayList<Integer>();
    test3.add(2);
    test3.add(1);
    ArrayList<Integer> expected3 = new ArrayList<Integer>();
    testFilterGoodScores(test3, expected3);
  }
}
