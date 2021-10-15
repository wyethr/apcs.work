public class TestScoreKeeper {

  public static void main(String[] args) {
    ScoreKeeper test = new ScoreKeeper();

    System.out.println("initial score: " + test.score());
    test.scoreNormal();
    System.out.println("after scoreNormal(): " + test.score());
    test.scoreBonus();
    System.out.println("after scoreBonus(): " + test.score());
  }
}
