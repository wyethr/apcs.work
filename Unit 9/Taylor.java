public class Taylor {

  public static double sin(double x, int n) {
    double count = x;
    double denominator = 3.0;
    double countFactor = 1.0;

    for(int i = 0; i < n; i++) {
      double newDenom = 1.0;
      double newNum = 1.0;

      for(int j = 0; j < denominator; j++) {
        newDenom = newDenom*j;
      }

      for(int k = 0; k < denominator; k++) {
        newNum = newNum*x;
      }

      count = count + countFactor*newNum/newDenom;

      countFactor = countFactor*-1.0;
      denominator = denominator + 2.0;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println("sin(1/2) = " + sin(.5, 1000));
    System.out.println("sin(0) = " + sin(0, 10000));
  }
}
