public class CountOccurrences {

  public static int countOccurrences(String source, String target) {
    int counter = 0;

    for(int i = 0; i + target.length() <= source.length(); i++) {
      if(source.substring(i, i + target.length()).equals(target)) {
        counter ++;
      }
    }

    return counter;
  }

  public static void testCountOccurrences(String source, String target, int expected) {
    int result = countOccurrences(source, target);

    System.out.println("source: " + source +
                      " target: " + target +
                      " expected: " + expected +
                      " result: " + result);

    if(result == expected) {
      System.out.println("Riley is breathing, people, she is breathing");
    }
    else {
      System.out.println("OMFG RILEY IS NOT BREATHING FKJDLSJFSK");
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    testCountOccurrences("Mississippi", "iss", 2);
    testCountOccurrences("banananana", "na", 4);
    testCountOccurrences("taotao", "tao", 2);
    testCountOccurrences("tabooo", "boo", 1);
  }
}
