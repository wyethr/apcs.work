public class CountLucky {

  public static int countLucky(int[] values) {
    int count = 0;

    for(int i = 0; i < values.length; i++) {
      if(values[i]%7 == 0) {
        count++;
      }
      else if(values[i]%10 == 7) {
        count ++;
      }
    }

    return count;
  }

  public static void testCountLucky(int[] values, int expected) {
    int result = countLucky(values);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("ruwu gets airpods");
    }
    else {
      System.out.println("ruwu doesn't get airpods");
    }
  }

  public static void main(String[] args) {
    int[] test1 = {1, 2, 3};
    testCountLucky(test1, 0);
    System.out.println("");

    int[] test2 = {7, 13, 17};
    testCountLucky(test2, 2);
    System.out.println("");

    int[] test3 = {107, 207};
    testCountLucky(test3, 2);
    System.out.println("");
  }
}
