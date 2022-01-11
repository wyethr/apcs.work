import java.util.*;

public class ItemTest {

  public static void main(String[] args) {
    Item ruwu = new Item("ruwu", (float)1);
    Item emma = new Item("emma", (float)20);
    Item dlow = new Item("dlow", (float)10);
    ArrayList<Item> itemCalculatorArrayList = new ArrayList<Item>();
    itemCalculatorArrayList.add(ruwu);
    itemCalculatorArrayList.add(emma);
    itemCalculatorArrayList.add(dlow);
    ItemCalculator itemCalculatorTest = new ItemCalculator(itemCalculatorArrayList);

    System.out.println("ruwu name = " + ruwu.name());
    System.out.println("dlow name = " + dlow.name());
    System.out.println("ruwu price = " + ruwu.price());
    System.out.println("dlow price = " + dlow.price());
    System.out.println("");

    System.out.println("itemCalculatorTest.printList() = ");
    itemCalculatorTest.printList();

    System.out.println("itemCalculatorTest.averagePrice() = " + itemCalculatorTest.averagePrice());
    System.out.println("");

    System.out.println("itemCalculatorTest.mostExpensive() = " + itemCalculatorTest.mostExpensive());
  }
}
