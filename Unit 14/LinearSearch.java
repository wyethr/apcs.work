import java.util.*;

public class LinearSearch {

  public static ArrayList<Integer> insertSort(ArrayList<Integer> values) {
    ArrayList<Integer> count = new ArrayList<Integer>();
    boolean add = true;

    for(int i = 0; i < values.size(); i++) {
      for(int j = 0; j < count.size(); j++) {

        add = true;

        if(values.get(i) < count.get(j)) {
          //System.out.println("values i = " + i);
          //System.out.println("values = " + values.get(i));
          //System.out.println("position = " + j);
          //System.out.println("count = " + count.get(j));
          //System.out.println("");
          count.add(j, values.get(i));
          add = false;
          break;
        }
      }

      if(add == true) {
        //System.out.println("END " + values.get(i));
        count.add(values.get(i));
      }
    }

    return count;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> values) {
    for(int j = 0; j < values.size(); j++) {
      for(int i = 0; i < j; i++) {
        if(values.get(i) > values.get(i + 1)) {
          Collections.swap(values, i, i+1);
        }
      }
    }

    return values;
  }

  public static void main(String[] args) {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(2);
    test.add(4);
    test.add(1);
    test.add(3);

    ArrayList<Integer> insertSortTest = insertSort(test);
    System.out.println("insertSortTest: ");
    for(int a: insertSortTest) {
      System.out.print(a + " ");
    }
    System.out.println("");

    ArrayList<Integer> bubbleSortTest = bubbleSort(test);
    System.out.println("bubbleSortTest: ");
    for(int b: bubbleSortTest) {
      System.out.print(b + " ");
    }
    System.out.println("");
  }
}
