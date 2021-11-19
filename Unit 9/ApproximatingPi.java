public class ApproximatingPi {

  public static double approximate_pi(int n) {
    double denominator = 3;
    double count = 4;
    double countFactor = -1;

    for(int i = 0; i < n; i++) {
      count = count + countFactor*(4.0/denominator);
      denominator = denominator + 2.0;
      countFactor = countFactor*-1.0;
    }

    return count;
  }


  public static void main(String[] args) {
    System.out.println("pi = " + approximate_pi(10000000));
  }

}
