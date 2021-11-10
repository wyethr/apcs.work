public class TotalZ {

  public static int countZNames(String[] strings) {
    int count = 0;

    for(int i = 0; i < strings.length; i++) {
      if(strings[i].substring(0, 1).equals("z") || strings[i].substring(0, 1).equals("Z"))
        count = count + strings[i].length();
    }

    return count;
  }

  public static void testCountZNames(String[] strings, int expected) {
    int result = countZNames(strings);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(expected == result) {
      System.out.println("ruwu no mumu");
    }
    else {
      System.out.println("mumu = murdered, btw :)");
    }
  }

  public static void main(String[] args) {
    String[] test1 = {"Dr. Kessner", "Dr. Sands"};
    testCountZNames(test1, 0);
    System.out.println("");

    String[] test2 = {"Zorro", "zero", "zippy"};
    testCountZNames(test2, 14);
  }
}
