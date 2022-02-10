public class Test {

  public static void main(String[] args) {
    int[][] array = new int[4][4];

    int count = 1000;

    for(int[] r: array) {
      System.out.println("r = " + r);
      System.out.println("");
      for(int s: r) {
        s = count;
        //System.out.println("s = " + s);
        //System.out.println("count = " + count);
        //System.out.println("");
        count = count + 100;
      }
      count = count + 700;
    }

    for(int[] row: array) {
      for(int value: row) {
        System.out.print(value + " ");
      }
      System.out.println("");
    }

  }
}
