public class ScoreKeeper {

  public ScoreKeeper() {
    score = 0;
  }

  public int score() {
    return score;
  }

  public void scoreNormal() {
    score = score + 100;
  }

  public void scoreBonus() {
    score = score + 1000;
  }

  private int score;
}
