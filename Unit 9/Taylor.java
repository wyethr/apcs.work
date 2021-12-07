public class Taylor {

  public static double sin(double x, int n) {
    double count = x;
    double denominator = 3.0;
    double countFactor = -1.0;

    for(int i = 1; i <= n; i++) {
      //System.out.println("i = " + i);
      double newDenom = 1.0;
      double newNum = 1.0;

      for(double j = 1.0; j <= denominator; j++) {
        newDenom = newDenom*j;
        //System.out.println("j = " + j);
        //System.out.println("newDenom = " + newDenom);
      }

      for(double k = 1.0; k <= denominator; k++) {
        newNum = newNum*x;
      }

      System.out.println("i = " + i);
      System.out.println("newNum = " + newNum);
      System.out.println("newDom = " + newDenom);
      System.out.println("");

      count = count + countFactor*newNum/newDenom;

      countFactor = countFactor*-1.0;
      denominator = denominator + 2.0;

      //System.out.println("count = " + count);
      //System.out.println("");
    }

    System.out.println("count = " + count);

    return count;
  }

  public static void main(String[] args) {
    //System.out.println("sin(1/2) = " + sin(.5, 300));
    //System.out.println("sin(0) = " + sin(0, 300));
    //System.out.println("sin(pi) = " + sin(3.14159, 300));

    sin(3.14159, 10);

  }
}
