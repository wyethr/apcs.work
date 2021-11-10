import java.util.*;

public class SumOfSquares {

  public static double sumOfSquares(ArrayList<Double> values) {
    double count = 0;

    for(double d: values) {
      count = count + d*d;
    }

    return count;
  }

  public static void testSumOfSquares(ArrayList<Double> values, double expected) {
    double result = sumOfSquares(values);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("ruwuuu!!!");
    }
    else {
      System.out.println("boohoo!!!");
    }
  }

  public static void main(String[] args) {
    ArrayList<Double> test1 = new ArrayList<Double>();
    test1.add(0.0);
    testSumOfSquares(test1, 0);
    System.out.println("");

    ArrayList<Double> test2 = new ArrayList<Double>();
    test2.add(1.0);
    test2.add(2.0);
    test2.add(3.0);
    testSumOfSquares(test2, 14.0);
    System.out.println("");

    ArrayList<Double> test3 = new ArrayList<Double>();
    test3.add(2.0);
    test3.add(2.0);
    test3.add(2.0);
    testSumOfSquares(test3, 12.0);
  }
}
