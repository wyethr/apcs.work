public class ApproximatingE {

  public static double approximate_e(int n) {
    double count = 1.0;
    double denominator = 1.0;

    for(int i = 0; i < n; i++) {
      double newDenom = 1.0;

      for(int j = 1; j <= denominator; j++) {
        newDenom = newDenom*j;
      }

      count = count + 1/newDenom;
      denominator ++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println("e = " + approximate_e(10000));
  }
}
