import java.util.*;

public class CountLucky {

  public static int countLucky(ArrayList<Integer> values) {

    int count = 0;

    for(int value: values) {
      if(value == 7)
        count ++;
      else if(value%10 == 7)
        count ++;
    }

    return count;
  }

  public static void testCountLucky(ArrayList<Integer> values, int expected) {
    int result = countLucky(values);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("Riley goes RUWUUU");
    }
    else {
      System.out.println("Riley goes boohoo :(");
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> test1 = new ArrayList<Integer>();
    test1.add(1);
    test1.add(2);
    test1.add(3);
    testCountLucky(test1, 0);
    System.out.println("");

    ArrayList<Integer> test2 = new ArrayList<Integer>();
    test2.add(7);
    test2.add(13);
    test2.add(17);
    testCountLucky(test2, 2);
    System.out.println("");

    ArrayList<Integer> test3 = new ArrayList<Integer>();
    test3.add(107);
    test3.add(207);
    testCountLucky(test3, 2);
    System.out.println("");
  }
}
