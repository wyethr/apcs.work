public class FactorialChallenge {

  public static int factorial(int x) {
    int y = 1;

    for(int i = 1; i <= x; i++) {
      y = y*i;
    }

    return y;
  }

  public static double exp(float x) {
    double e = 1;

    for(int i = 1; i < 10; i++) {
      e = e + Math.pow(x, i)/factorial(i);
    }

    return e;
  }

  public static double cos(double x) {
    double e = 1;
    int sanity = -1;

    for(int i = 1; i < 10; i++) {
      if(i%2 == 0) {
        double term = sanity*Math.pow(x, i)/factorial(i);
        e = e + term;
        sanity = sanity*-1;
      }
    }

    return e;
  }

  public static double sin(double x) {
    double e = 0;
    int sanity = 1;

    for(int i = 1; i < 10; i++) {
      if(i%2 == 1) {
        double term = sanity*Math.pow(x, i)/factorial(i);
        e = e + term;
        sanity = sanity*-1;
      }
    }

    return e;
  }

  public static double tan(double x) {
    return sin(x)/cos(x);
  }

  public static double cot(double x) {
    return cos(x)/sin(x);
  }

  public static void main(String[] args) {
    System.out.println("cos of pi: " + cos(3.14159));
    System.out.println("sin of pi: " + sin(3.14159));
    System.out.println("tan of pi: " + tan(3.14159/4));
    System.out.println("cot of pi: " + cot(3.14159/4));
  }
}
