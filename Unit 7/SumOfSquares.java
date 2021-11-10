public class SumOfSquares {

  public static double sumOfSquares(double[] values) {
    double count = 0;

    for(int i = 0; i < values.length; i++) {
      double add = values[i] * values[i];
      count = add + count;
    }

    return count;
  }

  public static void testSumOfSquares(double[] values, double expected) {
    double result = sumOfSquares(values);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("Ruwu's game is a success!");
    }
    else {
      System.out.println("Ruwu's game flops. Badly.");
    }
  }

  public static void main(String[] args) {
    double[] test1 = {0};
    testSumOfSquares(test1, 0);
    System.out.println("");

    double[] test2 = {1.0, 2.0, 3.0};
    testSumOfSquares(test2, 14.0);
    System.out.println("");

    double[] test3 = {2.0, 2.0, 2.0};
    testSumOfSquares(test3, 12.0);
  }
}
