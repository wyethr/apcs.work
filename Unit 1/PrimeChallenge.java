public class PrimeChallenge {

  public static boolean find(int a) {
    int statement = 0;

    for (int i = 2; i < a; i++) {
      if(a%i == 0) {
        statement = 1;
      }
    }

    if(statement == 1) {
      return false;
    }
    else {
      return true;
    }

  }

  public static void main(String[] args) {
    for (int b = 2; b < 400; b++) {
      if(find(b) == true) {
        System.out.println(b);
      }
    }
  }
}
