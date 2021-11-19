import java.util.*;

public class FindMax {

  public static double findMax(ArrayList<Double> values) {
    if(values.size() == 0)
      return 0;

    double maximum = values.get(0);

    for(double d: values) {
      if(d > maximum)
        maximum = d;
    }

    return maximum;
  }

  public static void testFindMax(ArrayList<Double> values, double expected) {
    double result = findMax(values);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("ruwu goes woooo");
    }
    else {
      System.out.println("ruwu goes booo");
    }
  }

  public static void main(String[] args) {
    ArrayList<Double> test1 = new ArrayList<Double>();
    test1.add(1.0);
    test1.add(2.1);
    test1.add(5.3);
    testFindMax(test1, 5.3);
    System.out.println("");

    ArrayList<Double> test2 = new ArrayList<Double>();
    test2.add(0.0);
    test2.add(-35.0);
    test2.add(90.1);
    testFindMax(test2, 90.1);
    System.out.println("");

    ArrayList<Double> test3 = new ArrayList<Double>();
    test3.add(10.0);
    test3.add(11.0);
    test3.add(9.0);
    testFindMax(test3, 11.0);
  }
}
