public class ArrayFront9 {

  public static boolean arrayFront9(int[] values) {

    if(values.length < 4) {
      for(int i = 0; i < values.length; i++) {
        if(values[i] == 9)
          return true;
      }
      return false;
    }

    for(int i = 0; i < 4; i++) {
      if(values[i] == 9)
        return true;
    }

    return false;
  }

  public static void testArrayFront9(int[] values, boolean expected) {

    boolean result = arrayFront9(values);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("Ruwu BOOPTYDOOP");
    }
    else {
      System.out.println("Ruwu no booptydoop");
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    int[] test1 = {1, 2, 9, 3, 4};
    testArrayFront9(test1, true);

    int[] test2 = {1, 2, 3, 4, 9};
    testArrayFront9(test2, false);

    int[] test3 = {1, 2, 3, 4, 5};
    testArrayFront9(test3, false);

    int[] test4 = {1, 9};
    testArrayFront9(test4, true);
  }
}
