public class ArrayCount9 {

  public static int arrayCount9(int[] values) {
    int total = 0;

    for(int i = 0; i < values.length; i++) {
      if(values[i] == 9)
        total++;
    }

    return total;
  }

  public static void testArrayCount9(int[] values, int expected) {
    int result = arrayCount9(values);

    System.out.println("numbers: " + values +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("Riley explosion happy!");
    }
    else {
      System.out.println("Riley non-explosion non-happy!");
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 9};
    testArrayCount9(nums, 1);
    System.out.println("");

    int[] nums2 = {1, 9, 9};
    testArrayCount9(nums2, 2);
    System.out.println("");

    int[] nums3 = {1, 9, 9, 3, 9};
    testArrayCount9(nums3, 3);
  }
}
