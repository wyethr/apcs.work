public class MagicEightBall {

  public MagicEightBall() {

  }

  public String ask(String question) {
    double count = Math.random();

    if(count < 1/8.0)
      return replyOne;
    else if (count > 1/8.0 && count < 2/8.0)
      return replyTwo;
    else if (count > 2/8.0 && count < 3/8.0)
      return replyThree;
    else if (count > 3/8.0 && count < 4/8.0)
      return replyFour;
    else if (count > 4/8.0 && count < 5/8.0)
      return replyFive;
    else if (count > 5/8.0 && count < 6/8.0)
      return replySix;
    else if (count > 6/8.0 && count < 7/8.0)
      return replySeven;
    else
      return replyEight;
  }

  private static final String replyOne = "your question brings riley sadness";
  private static final String replyTwo = "your question brings riley despair";
  private static final String replyThree = "your question brings riley deep, dark, unmoving sorrow";
  private static final String replyFour = "you just literally made riley cry - gosh you must suck";
  private static final String replyFive = "oml and now riley is writhing in agony on the floor, nice going";
  private static final String replySix = "and great, you just made riley collapse";
  private static final String replySeven = "well riley is in pain now, so i hope you're happy with yourself";
  private static final String replyEight = "you can't even comprehend the magnitude of anguish riley is experiencing right now";
}
