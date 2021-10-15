public class TestMagicEightBall {

  public static void main(String[] args) {
    MagicEightBall wyeth = new MagicEightBall();

    System.out.println("How is Riley doing?");
    System.out.println(wyeth.ask("How is Riley doing?"));
    System.out.println("Aw oh no is Riley alright?");
    System.out.println(wyeth.ask("Aw oh no is Riley alright?"));
    System.out.println("Well can she stop crying?");
    System.out.println(wyeth.ask("Well can she stop crying?"));
  }
}
