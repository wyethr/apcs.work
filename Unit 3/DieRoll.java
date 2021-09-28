public class DieRoll {

  public static int rollDie() {
    double c = Math.random() * 10 + 1;

    while(c >= 7) {
      c = Math.random() * 10 + 1;
    }

    return (int) c;

  }

  public static void main(String[] args) {
    for(int i = 0; i < 20; i++) {
      System.out.println(rollDie());
    }
  }
}
