public class SumOfSquares {

  public static double sumOfSquares(int n) {
    double i = 1;
    double counter = 0;

    while(i <= n) {
      counter = counter + Math.pow(i, 2);
      i++;
    }

    return counter;
  }

  public static void testSumOfSquares(int n, double expected) {
    double result = sumOfSquares(n);

    System.out.println("int: " + n +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("riley wowza, folks!");
    }
    else {
      System.out.println("riley wah-wah-wah, ppl");
    }

    System.out.println("");
  }

  public static void main(String[] args) {

    testSumOfSquares(1, 1);
    testSumOfSquares(2, 5);
    testSumOfSquares(3, 14);
    testSumOfSquares(4, 30);
    testSumOfSquares(5, 55);
  }
}
