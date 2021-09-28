public class HasTeen {

  public static boolean hasTeen(int a, int b, int c) {
    if(13 <= a && a <= 19)
      return true;
    else if(13 <= b && b <= 19)
      return true;
    else if(13 <= c && c <= 19)
      return true;
    else
      return false;
  }

  public static void testHasTeen(int a, int b, int c, boolean expected) {
    boolean result = hasTeen(a, b, c);

    System.out.println("a: " + a +
                      " b: " + b +
                      " c: " + c);

    if(result == expected) {
      System.out.println("happy math cheersss");
    }
    else {
      System.out.println("sad math cheers :(");
    }
  }

  public static void main(String[] args) {
    testHasTeen(13, 20, 10, true);
    System.out.println("");

    testHasTeen(20, 19, 10, true);
    System.out.println("");

    testHasTeen(20, 10, 13, true);
    System.out.println("");
  }

}
