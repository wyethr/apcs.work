import java.util.*;

public class RectangleTest {

  public static double perimeterAverage(Rectangle[][] chess) {
    double perimeterCount = 0;
    double totalNumber = 0;

    for(Rectangle[] row: chess) {
      for(Rectangle value: row) {
        perimeterCount = perimeterCount + value.perimeter();
        totalNumber++;
      }
    }

    return perimeterCount/totalNumber;
  }

  public static Rectangle biggestArea(Rectangle[][] chess) {
    Rectangle areaCount = chess[1][1];

    for(Rectangle[] row: chess) {
      for(Rectangle value: row) {
        if(value.area() > areaCount.area()) {
          areaCount = value;
        }
      }
    }

    return areaCount;
  }

  public static void main(String[] args) {
    Rectangle[][] chess = new Rectangle[8][8];

    for(int i = 0; i < chess.length; i++) {
      for(int j = 0; j < chess[i].length; j++) {
        chess[i][j] = new Rectangle("(" + i + ", " + j + ")", 4, 4);
      }
    }

    System.out.println("");
    System.out.println("perimeterAverage = " + perimeterAverage(chess));

    Rectangle[][] notChess = new Rectangle[8][8];

    for(int i = 0; i < notChess.length; i++) {
      for(int j = 0; j < notChess[i].length; j++) {
        notChess[i][j] = new Rectangle("(" + i + ", " + j + ")", i, j);
      }
    }

    System.out.println("");
    System.out.println("biggestArea = " + biggestArea(notChess));
  }
}
