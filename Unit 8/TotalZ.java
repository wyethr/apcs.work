import java.util.*;

public class TotalZ {

  public static int countZNames(ArrayList<String> strings) {
    int count = 0;

    for(String string: strings) {
      if(string.substring(0,1).equals("z") || string.substring(0,1).equals("Z")) {
        count = count + string.length();
      }
    }

    return count;
  }

  public static void testCountZNames(ArrayList<String> strings, int expected) {
    int result = countZNames(strings);

    System.out.println("expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("RUWU FIXES HER CODE");
    }
    else {
      System.out.println("rusu's game remains broken, forever.");
    }
  }

  public static void main(String[] args) {
    ArrayList<String> test1 = new ArrayList<String>();
    test1.add("Dr. Kessner");
    test1.add("Dr. Sands");
    testCountZNames(test1, 0);
    System.out.println("");

    ArrayList<String> test2 = new ArrayList<String>();
    test2.add("Zorro");
    test2.add("zero");
    test2.add("zippy");
    testCountZNames(test2, 14);
    System.out.println("");
  }
}
