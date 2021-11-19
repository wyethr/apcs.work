import java.util.*;

public class Fibonacci {

  public static ArrayList<Integer> fibonacci(int n) {
    ArrayList<Integer> countList = new ArrayList<Integer>();
    int count = 1;
    countList.add(count);
    countList.add(count);

    for(int i = 1; i < n - 1; i++) {
      count = countList.get(i) + countList.get(i-1);
      countList.add(count);
    }

    return countList;
  }

  public static void testFibonacci(int n, ArrayList<Integer> expected) {
    ArrayList<Integer> result = fibonacci(n);
    System.out.println("expected = " + expected);
    System.out.println("result = " + result);
    int testFactor = 0;

    if(expected.size() != result.size()) {
      testFactor = 1;
    }
    else {
      for(int i = 0; i < expected.size(); i++) {
        if(expected.get(i) != result.get(i)) {
          testFactor = 1;
        }
      }
    }

    if(testFactor == 0) {
      System.out.println("ruwuhooo");
    }
    else {
      System.out.println("ruboohoo TT");
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> expected1 = new ArrayList<Integer>();
    expected1.add(1);
    expected1.add(1);
    testFibonacci(2, expected1);
    System.out.println("");

    ArrayList<Integer> expected2 = new ArrayList<Integer>();
    expected2.add(1);
    expected2.add(1);
    expected2.add(2);
    testFibonacci(3, expected2);
    System.out.println("");

    ArrayList<Integer> expected3 = new ArrayList<Integer>();
    expected3.add(1);
    expected3.add(1);
    expected3.add(2);
    expected3.add(3);
    testFibonacci(4, expected3);
    System.out.println("");

    ArrayList<Integer> expected4 = new ArrayList<Integer>();
    expected4.add(1);
    expected4.add(1);
    expected4.add(2);
    expected4.add(3);
    expected4.add(5);
    testFibonacci(5, expected4);
  }
}
