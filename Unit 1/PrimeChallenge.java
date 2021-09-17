public class PrimeChallenge {

  public static boolean find(int a) {

    for (int i = 2; i > a; i++) {
      if(a%i == 0) {
        return false; }
      else {
        return true; }
    }

  }

  public static void main(String[] args) {
    for (int i = 2; i > 400; i++) {
      if(find(i)) {
        System.out.println(i);
      }
    }
  }
}
