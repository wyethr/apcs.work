public class Array667 {

  public static int array667(int[] values) {
    int count = 0;

    for(int i = 0; i < values.length - 1; i++) {
      if(values[i] == 6 && values[i + 1] == 6) {
        count++;
      }
      else if(values [i] == 6 && values[i + 1] == 7) {
        count++;
      }
    }

    return count;
  }

  public static void testArray667(int[] values, int expected) {
    int result = array667(values);

    System.out.println("expecetd: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("Ruwuhoo");
    }
    else {
      System.out.println("Rubuhoo");
    }
  }

  public static void main(String[] args) {
    int[] test1 = {6, 6, 2};
    testArray667(test1, 1);
    System.out.println("");

    int[] test2 = {6, 6, 2, 6};
    testArray667(test2, 1);
    System.out.println("");

    int[] test3 = {6, 7, 2, 6};
    testArray667(test3, 1);
    System.out.println("");

    int[] test4 = {9, 8, 6, 8};
    testArray667(test4, 0);
  }
}
