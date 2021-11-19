import java.util.*;

public class PrimeChallenge {

  public static ArrayList<Integer> prime(int n) {
    ArrayList<Integer> count = new ArrayList<Integer>();
    boolean isPrime;
    int i = 2;

    System.out.println("n = " + n);

    while(count.size() < n) {
      isPrime = true;

      for(int j = 2; j < i; j++) {

        if(i%j == 0) {
          isPrime = false;
        }
      }

      if(isPrime == true) {
        count.add(i);
      }

      i++;
    }


    return count;
  }

  public static void testPrime(int n, ArrayList<Integer> expected) {
    ArrayList<Integer> result = prime(n);

    System.out.println("expected: " + expected);
    System.out.println("result: " + result);

    if(expected.equals(result)) {
      System.out.println("Ruwu says nicee");
    }
    else {
      System.out.println("Ruwu says not nice.");
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> expected1 = new ArrayList<Integer>();
    expected1.add(2);
    testPrime(1, expected1);
    System.out.println("");

    ArrayList<Integer> expected2 = new ArrayList<Integer>();
    expected2.add(2);
    expected2.add(3);
    testPrime(2, expected2);
    System.out.println("");

    ArrayList<Integer> expected3 = new ArrayList<Integer>();
    expected3.add(2);
    expected3.add(3);
    expected3.add(5);
    testPrime(3, expected3);
    System.out.println("");

    ArrayList<Integer> expected4 = new ArrayList<Integer>();
    expected4.add(2);
    expected4.add(3);
    expected4.add(5);
    expected4.add(7);
    expected4.add(11);
    expected4.add(13);
    expected4.add(17);
    expected4.add(19);
    testPrime(8, expected4);

    prime(1);
    prime(2);
    prime(3);
    prime(8);
  }
}
