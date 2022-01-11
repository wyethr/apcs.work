import java.util.*;

public class ItemCalculator {

  public ItemCalculator(ArrayList<Item> itemsIn) {
    items = itemsIn;
  }

  public void printList() {
    for(Item i: items) {
      System.out.println(i.name());
      System.out.println(i.price());
      System.out.println("");
    }
  }

  public float averagePrice() {
    float count = 0;

    for(Item i: items) {
      count = count + i.price();
    }

    return count/items.size();
  }

  public String mostExpensive() {
    Item most = items.get(0);

    for(int i = 0; i < items.size(); i++) {
      if(items.get(i).price() > most.price()) {
        most = items.get(i);
      }
    }

    return most.name();
  }

  private ArrayList<Item> items;

}
