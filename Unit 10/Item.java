import java.util.*;

public class Item {

  public Item(String inName, float inPrice) {
    name = inName;
    price = inPrice;
  }

  public String name() {
    return name;
  }

  public float price() {
    return price;
  }

  private String name;
  private float price;
}
