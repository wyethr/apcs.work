public class CoinFlip {

  public static String coinflip() {
    String heads = "Heads";
    String tails = "Tails";

    double flip = Math.random();

    if(flip > 0.5) {
      return heads;
    }
    else {
      return tails;
    }
  }

  public static void main(String[] args) {
    for(int i = 0; i < 20; i++) {
      System.out.println(coinflip());
    }
  }
}
