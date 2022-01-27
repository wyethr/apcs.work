import java.util.*;

public class ArrayInitialization {

  public static void printIntArray(int[][] values) {
    for(int[] row: values) {
      for(int value: row) {
        System.out.print(value + " ");
      }
      System.out.println("");
    }
  }

  public static void printStringArray(String[][] values) {
    for(String[] row: values) {
      for(String value: row) {
        System.out.print(value + "");
      }
      System.out.println("");
    }
  }

  public static void printDoubleArray(double[][] values) {
    for(double[] row: values) {
      for(double value: row) {
        System.out.print(value + " ");
      }
      System.out.println("");
    }
  }

  public static int smallestInt(int[][] values) {
    int count = values[1][1];

    for(int[] row: values) {
      for(int value: row) {
        if(value < count) {
          count = value;
        }
      }
    }

    return count;
  }

  public static float sum(float[][] values) {
    float count = 0;

    for(float[] row: values) {
      for(float value: row) {
        count = count + value;
      }
    }

    return count;
  }

  public static int countA(String[][] values) {
    int count = 0;

    for(String[] row: values) {
      for(String value: row) {
        if(value.substring(0, 1).equals("A")) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {

    int[][] values = new int[10][10];

    for(int i = 0; i < values.length; i++) {
      for(int j = 0; j < values[i].length; j++) {
        if(j == i) {
          values[i][j] = 1;
        }
        else {
          values[i][j] = 0;
        }
      }
    }

    String[][] hierarchy = {{"Wyeth"},
                            {"Emma", "Shaye", "Nina", "Sydney"},
                            {"Ruwu", "Aubrey", "Dlow"},
                            {"Amanda"}};

    printIntArray(values);
    System.out.println("");

    printStringArray(hierarchy);
    System.out.println("");

    double[][] newValues = new double[5][5];

    for(int i = 0; i < newValues.length; i++) {
      for(int j = 0; j < newValues[i].length; j++) {
        newValues[i][j] = 10*(i+1) + j + 1;
      }
    }

    printDoubleArray(newValues);
    System.out.println("");

    int[][] newNewValues = new int[6][5];

    for(int i = 0; i < newNewValues.length; i++) {
      for(int j = 0; j < newNewValues[i].length; j++) {
        newNewValues[i][j] = i + 1;
      }
    }

    printIntArray(newNewValues);
    System.out.println("");

    int[][] newestValues = {{2, 3},
                            {4, 5, 6},
                            {7, 1, 8, 9},
                            {10}};

    System.out.println("smallestInt = " + smallestInt(newestValues));
    System.out.println("");

    float[][] newerNewestValues = {{(float)2.0, (float)3.0},
                                  {(float)4.0}};

    System.out.println("sum = " + sum(newerNewestValues));
    System.out.println("");

    System.out.println("countA = " + countA(hierarchy));
    System.out.println("");
  }

}
