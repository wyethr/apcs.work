import java.util.*;
import processing.core.*;

public class Main extends PApplet {

  protected int highestOnBoard() {
    if(doges.size() <= 0) {
      return 0;
    }

    Doge count = doges.get(0);

    for(Doge d: doges) {
      if(d.type() > count.type()) {
        count = d;
      }
    }

    return count.type();
  }

  private boolean beatGame() {
    for(Doge d: doges) {
      if(d.type() == 26) {
        return true;
      }
    }

    return false;
  }

  private boolean full() {
    int count = 0;

    for(Box b: boxes) {
      for(Doge d: doges) {
        if(d.row() == b.row() && d.column() == b.column()) {
          count++;
        }
      }
    }

    if(count >= boxes.size()) {
      return true;
    }
    else {
      return false;
    }
  }

  private boolean loseGame() {
    if(moving == true) {
      return false;
    }

    if(full() == false) {
      return false;
    }

    for(Doge check2: doges) {
      Doge toLeft = getDoge(check2.row() - 1, check2.column());
      if(toLeft != null && toLeft.type() == check2.type()) {
        return false;
      }

      Doge toRight = getDoge(check2.row() + 1, check2.column());
      if(toRight != null && toRight.type() == check2.type()) {
        return false;
      }

      Doge toUp = getDoge(check2.row(), check2.column() - 1);
      if(toUp != null && toUp.type() == check2.type()) {
        return false;
      }

      Doge toDown = getDoge(check2.row(), check2.column() + 1);
      if(toDown != null && toDown.type() == check2.type()) {
        return false;
      }

    }

    return true;
  }

  private Doge getDoge(int row, int column) {
    for(Doge d: doges) {
      if(d.row() == row && d.column() == column) {
        return d;
      }
    }

    return null;
  }

  public void updateScore(int type) {
    score = score + (int)Math.pow(2, type);

    ScoreAdd newScoreAdd = new ScoreAdd(this, (int)Math.pow(2, type));
    scoreAdds.add(newScoreAdd);

    if(random(100) < 20 && encouragements.size() < 1) {
      Encouragement newE = new Encouragement(this);
      encouragements.add(newE);
    }
  }

  private boolean allInPlace() {
    for(Doge d: doges) {
      if(d.position().dist(d.destination()) > 1) {
        //System.out.println(d.name() + " = " + d.position().dist(d.destination()));
        return false;
      }
    }

    return true;
  }

  private float decideColor(float ideal) {
    int count = (int)random(0, 2);

    if(count == 0) {
      return ideal;
    }
    else {
      return -1*ideal;
    }
  }

  public void initialize() {
    scoreX = (((width-(5*height/6))/2));
    scoreY = height/60 + height/36;

    boxes = new ArrayList<Box>();
    doges = new ArrayList<Doge>();
    encouragements = new ArrayList<Encouragement>();
    scoreAdds = new ArrayList<ScoreAdd>();

    alreadyWon = false;

    font = createFont("AlfaSlabOne-Regular.ttf", height/50);
    textFont(font);

    score = 0;

    moving = false;

    //System.out.println(moved);
    moved = false;

    background(255);

    sideFactor = height/6;

    for(int i = 0; i < 4; i ++) {
      for(int j = 0; j < 4; j++) {
        Box b = new Box(this, i, j, sideFactor);
        boxes.add(b);
      }
    }

    Doge start1 = new Doge(this, sideFactor, doges, boxes, 0);
    Doge start2 = new Doge(this, sideFactor, doges, boxes, 1);
    doges.add(start2);
    doges.add(start1);

    Doge test = new Doge(this, sideFactor, doges, boxes, 2, 1, 0, 26);
    //doges.add(test);

    while(start2.checkCollide().equals("collide") || start2.checkCollide().equals("same")) {
      start2.newDoge();
      //System.out.println(e.name());
      //System.out.println("(" + e.column() + ", " + e.row() + ")");
      //System.out.println("e checkCollide() is " + e.checkCollide());
      //System.out.println("(" + e.position().x + ", " + e.position().y + ")");
      //System.out.println("");
    }

    nameKeeper = 1;

    //Doge new1 = new Doge(this, sideFactor, doges, boxes, 0, 0, 0, 25);
    //Doge new2 = new Doge(this, sideFactor, doges, boxes, 1, 1, 0, 25);
    //Doge new3 = new Doge(this, sideFactor, doges, boxes, 2, 2, 0, 4);
    //doges.add(new1);
    //doges.add(new2);
    //for(Doge now: doges) {
      //System.out.println(now.name() + ": " + now.type());
    //}
    //doges.add(new3);

    //for(int i = 1; i <= boxes.size(); i++) {
      //System.out.println("type: " + i);
      //Doge newCreate = new Doge(this, sideFactor, doges, boxes, i, boxes.get(i - 1).row(), boxes.get(i - 1).column(), i);
      //doges.add(newCreate);
    //}

    gameState = "play";

    two = loadImage("2 - 2048.png");
    four = loadImage("4 - 2048.png");
    zero = loadImage("0 - 2048.png");
    eight = loadImage("8 - 2048.png");

    full2048 = loadImage("2048.png");
    full2048.resize((int)11*width/96, (int)2*height/24);

    two.resize((int)2*width/96, (int)2*height/24);
    zero.resize((int)3*width/96, (int)2*height/24);
    four.resize((int)3*width/96, (int)2*height/24);
    eight.resize((int)3*width/96, (int)2*height/24);

    colorFactorRed = (int)random(255);
    colorFactorGreen = (int)random(255);
    colorFactorBlue = (int)random(255);

    backgroundColor = color(colorFactorRed, colorFactorGreen, colorFactorBlue);
    colorChangeRed = decideColor((float)0.5);
    colorChangeGreen = decideColor((float)0.5);
    colorChangeBlue = decideColor((float)0.5);

    //while(colorChangeRed != -1 && colorChangeRed != 1) {
    //  colorChangeRed = (int)random(-1, 2);
    //}

    //while(colorChangeGreen != -1 && colorChangeGreen != 1) {
    //  colorChangeGreen = (int)random(-1, 2);
    //}

    //while(colorChangeBlue != -1 && colorChangeBlue != 1) {
    //  colorChangeBlue = (int)random(-1, 2);
    //}

  }

  public void settings() {
    size(1440, 775);
  }

  public void setup() {
    initialize();

    highScore = 0;
  }

  public void draw() {
    if(gameState.equals("intro")) {
      background(255);
      fill(0);

      image(two, 0, 0);
      image(zero, width/4, 0);
      image(four, width/2, 0);
      image(eight, 3*width/4, 0);
    }
    else if(gameState.equals("play")) {
      //System.out.println("encouragements.size() = " + encouragements.size());
      //System.out.println("loseGame = " + loseGame());
      textSize(height/50);
      backgroundColor = color(colorFactorRed, colorFactorGreen, colorFactorBlue);
      background(backgroundColor);
      int colorMax = 255;
      int colorMin = 0;

      if(colorFactorRed >= colorMax || colorFactorRed <= colorMin) {
        colorChangeRed = colorChangeRed*-1;
      }

      if(colorFactorGreen >= colorMax || colorFactorGreen <= colorMin) {
        colorChangeGreen = colorChangeGreen*-1;
      }

      if(colorFactorBlue >= colorMax || colorFactorBlue <= colorMin) {
        colorChangeBlue = colorChangeBlue*-1;
      }

      colorFactorRed = colorFactorRed + colorChangeRed;
      colorFactorGreen = colorFactorGreen + colorChangeGreen;
      colorFactorBlue = colorFactorBlue + colorChangeBlue;


      fill(0);
      //text("doges.size: " + doges.size(), 25, 25);
      //text("nameKeeper: " + nameKeeper, 25, 50);
      //text("size: (" + width + ", " + height + ")", 25, 75);

      rectMode(CENTER);
      noStroke();
      fill(200, 50);
      rect(width/2, height/2, 5*height/6, 5*height/6);

      rectMode(CORNER);
      rect((((width-(5*height/6))/2)), height/60, 2*height/12, height/24);
      fill(255);
      textMode(CENTER);
      textAlign(LEFT, BASELINE);
      text("   Score: " + score, scoreX, scoreY);
      //      text("   Score: " + score, (((width-(5*height/6))/2)), height/60 + height/36);

      rectMode(CORNERS);
      fill(200, 50);
      rect(5*height/6 + ((width - (5*height/6))/2), height/60, 5*height/6 + ((width - (5*height/6))/2) - 2*height/12, height/60 + height/24);
      fill(255);
      text("   High: " + highScore, 5*height/6 + ((width - (5*height/6))/2) - 2*height/12, scoreY);

      rectMode(CORNER);

      imageMode(CENTER);
      float aboveWidth = 3*width/96;
      float twoAboveWidth = 6*width/96 + width/192;
      image(full2048, width/2, height/24);
      //text("ASL 2048", width/2, 5*height/6 + 10*(height - 5*height/6)/11);

      //image(two, (((width-(5*height/6))/2)) + 3*height/14 + twoAboveWidth, height/24);
      //image(zero, (((width-(5*height/6))/2)) + 3*height/14 + 3*aboveWidth, height/24);
      //image(four, (((width-(5*height/6))/2)) + 3*height/14 + 4*aboveWidth, height/24);
      //image(eight, (((width-(5*height/6))/2)) + 3*height/14 + 5*aboveWidth, height/24);

      for(Box b: boxes) {
        b.display();
      }

      for(int i = 0; i < doges.size(); i++) {
        doges.get(i).display();
      }

      int textPlacement = 25;
      int xPlacement = 1100;

      if(alreadyWon == false && beatGame() == true) {
        rectMode(CENTER);
        stroke(backgroundColor);
        strokeWeight(height/500);
        fill(255);
        rect(width/2, height/2, height/3, height/3);

        textMode(CENTER);
        fill(backgroundColor);
        float youWonSize = height/25;
        textSize(youWonSize);
        textAlign(LEFT, BASELINE);
        text("YOU WON!", width/2 - (float)(2.9*youWonSize), height/2);
        youWonSize = height/65;
        textSize(youWonSize);
        textAlign(CENTER);
        text("press delete to continue this game", width/2, height/2 + 2*youWonSize);
        text("press return to restart", width/2, height/2 + 4*youWonSize);

        //text("press delete to continue this game", width/2 - (float)(9*youWonSize), height/2 + 2*youWonSize);
        //text("press return to restart", width/2 - (float)(9*youWonSize), height/2 + 4*youWonSize);
      }

      if(loseGame() == true && moved == false) {
        rectMode(CENTER);
        stroke(backgroundColor);
        strokeWeight(height/500);
        fill(255);
        rect(width/2, height/2, height/3, height/3);

        textMode(CENTER);
        fill(backgroundColor);
        float youWonSize = height/25;
        textSize(youWonSize);
        textAlign(LEFT, BASELINE);
        text("YOU LOSE!", width/2 - (float)(2.9*youWonSize), height/2);
        //textAlign(CENTER, CENTER);
        //text("YOU LOSE!", width/2, height/2);
        youWonSize = height/65;
        textSize(youWonSize);
        text("press return to restart", width/2 - (float)(6*youWonSize), height/2 + 2*youWonSize);
      }

      for(Doge e: doges) {
        fill(0);

        if(textPlacement >= 700) {
          if(xPlacement == 25) {
            textPlacement = 125;
            xPlacement = 200;
          }
          else {
            textPlacement = 125;
            xPlacement = 25;
          }
        }

        //text(e.name() + " - type: " + e.type(), xPlacement, textPlacement);
        //textPlacement = textPlacement + 25;
        //text("   (" + e.column() + ", " + e.row() + ")", xPlacement, textPlacement);
        //textPlacement = textPlacement + 25;
        //text("   checkCollide() is " + e.checkCollide(), xPlacement, textPlacement);
        //textPlacement = textPlacement + 25;
        //text("   (" + e.position().x + ", " + e.position().y + ")", xPlacement, textPlacement);
        //textPlacement = textPlacement + 25;
        //text("", xPlacement, textPlacement);
        //textPlacement = textPlacement + 25;
      }

      //System.out.println("allInPlace = " + allInPlace());
      if(allInPlace() == true) {
        if(full() == true) {
          moved = false;
        }
        if(moved == true) {
          Doge e = new Doge(this, sideFactor, doges, boxes, nameKeeper);
          doges.add(e);
          nameKeeper++;
          //System.out.println(e.name());
          //System.out.println("(" + e.column() + ", " + e.row() + ")");
          //System.out.println("e checkCollide() is " + e.checkCollide());
          //System.out.println("(" + e.position().x + ", " + e.position().y + ")");
          //System.out.println("");

          while(e.checkCollide().equals("collide") || e.checkCollide().equals("same")) {
            e.newDoge();
            //System.out.println(e.name());
            //System.out.println("(" + e.column() + ", " + e.row() + ")");
            //System.out.println("e checkCollide() is " + e.checkCollide());
            //System.out.println("(" + e.position().x + ", " + e.position().y + ")");
            //System.out.println("");
          }

          moved = false;
        }
      }

      for(Encouragement e: encouragements) {
        e.update();
        e.display();
      }

      for(int eCheck = 0; eCheck < encouragements.size(); eCheck++) {
        if(encouragements.get(eCheck).opacity() <= 0) {
          encouragements.remove(encouragements.get(eCheck));
        }
      }

      for(ScoreAdd s: scoreAdds) {
        s.display();
        s.update();
      }

      for(int sCheck = 0; sCheck < scoreAdds.size(); sCheck++) {
        if(scoreAdds.get(sCheck).opacity() <= 0) {
          scoreAdds.remove(scoreAdds.get(sCheck));
        }
      }

      if(score > highScore) {
        highScore = score;
      }

      textAlign(CENTER, BASELINE);
      textSize(height/14);
      fill(255);
      text("ASL 2048", width/2, 5*height/6 + 10*(height - 5*height/6)/11);

    }

  }

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  public void keyPressed() {
    if(gameState.equals("intro")) {
      if(key == ENTER || key == RETURN) {
        gameState = "play";
      }
    }
    else if(gameState.equals("play")) {
      String direction = "";

      for(Doge d: doges) {
        d.setOffLimits();
        d.setOffLimitsMerge();
      }

      if(alreadyWon == true || beatGame() == false) {
        if(loseGame() == false) {
          if(keyCode == LEFT) {
            direction = "left";
            System.out.println("              LEFT!!!!!");

            for(int rowLeft = 0; rowLeft < 4; rowLeft++) {
              //System.out.println("Row: " + rowLeft);
              //System.out.println("");
              for(int columnLeft = 0; columnLeft < 4; columnLeft++) {
                //System.out.println("(" + columnLeft + ", " + rowLeft + ")");

                if(getDoge(rowLeft, columnLeft) != null) {
                  getDoge(rowLeft, columnLeft).move(direction);
                  //System.out.println("FOUND DOGE");
                }
                //System.out.println("");
              }
              //System.out.println("*");
              //System.out.println("");
            }
          }

          else if(keyCode == RIGHT) {
            direction = "right";
            System.out.println("              RIGHT!!!!!");

            for(int rowRight = 0; rowRight < 4; rowRight++) {
              //System.out.println("Row: " + rowRight);
              //System.out.println("");
              for(int columnRight = 3; columnRight > -1; columnRight--) {
                //System.out.println("(" + columnRight + ", " + rowRight + ")");

                if(getDoge(rowRight, columnRight) != null) {
                  getDoge(rowRight, columnRight).move(direction);
                  //System.out.println("FOUND DOGE");
                }
                //System.out.println("");
              }
              //System.out.println("*");
              //System.out.println("");
            }
          }
          else if(keyCode == DOWN) {
            direction = "down";
            System.out.println("              DOWN!!!!!");


            for(int columnDown = 0; columnDown < 4; columnDown++) {
              //System.out.println("Column: " + columnDown);
              //System.out.println("");
              for(int rowDown = 3; rowDown > -1; rowDown--) {
                //System.out.println("(" + columnDown + ", " + rowDown + ")");

                if(getDoge(rowDown, columnDown) != null) {
                  getDoge(rowDown, columnDown).move(direction);
                  //System.out.println("FOUND DOGE");
                }
                //System.out.println("");
              }
              //System.out.println("*");
              //System.out.println("");
            }
          }
          else if(keyCode == UP) {
            direction = "up";
            System.out.println("              UP!!!!!");


            for(int columnUp = 0; columnUp < 4; columnUp++) {
              //System.out.println("Column: " + columnUp);
              //System.out.println("");
              for(int rowUp = 0; rowUp < 4; rowUp++) {
                //System.out.println("(" + columnUp + ", " + rowUp + ")");

                if(getDoge(rowUp, columnUp) != null) {
                  getDoge(rowUp, columnUp).move(direction);
                  //System.out.println("FOUND DOGE");
                }
                //System.out.println("");
              }
              //System.out.println("*");
              //System.out.println("");
            }
          }
        }
      }

      if(alreadyWon == false && beatGame() == true) {
        if(keyCode == DELETE || keyCode == BACKSPACE) {
          alreadyWon = true;
        }
        else if(keyCode == RETURN || keyCode == ENTER) {
          initialize();
        }
      }

      if(loseGame() == true) {
        if(keyCode == RETURN || keyCode == ENTER) {
          initialize();
        }
      }

      System.out.println("");
      System.out.println("*");
      System.out.println("");

      if(alreadyWon == true || beatGame() == false) {
        if(loseGame() == false) {
          if(keyCode == LEFT || keyCode == RIGHT || keyCode == DOWN || keyCode == UP) {
            moved = true;
          }
        }
      }
    }

  }

  public float scoreX() {
    return scoreX;
  }

  public float scoreY() {
    return scoreY;
  }

  private float sideFactor;
  private ArrayList<Box> boxes;

  private ArrayList<Doge> doges;
  private ArrayList<Encouragement> encouragements;
  private ArrayList<ScoreAdd> scoreAdds;

  private int nameKeeper;
  private boolean moved;

  private int score;
  private int highScore;
  private String gameState;

  private PImage two;
  private PImage four;
  private PImage zero;
  private PImage eight;

  private PImage full2048;

  private float playButtonX;
  private float playButtonY;
  private float playButtonWidth;
  private float playButtonHeight;

  private boolean alreadyWon;

  private PFont font;

  protected int backgroundColor;
  private float colorFactorRed;
  private float colorChangeRed;
  private float colorFactorGreen;
  private float colorChangeGreen;
  private float colorFactorBlue;
  private float colorChangeBlue;

  private float scoreX;
  private float scoreY;

  protected boolean moving;

}
