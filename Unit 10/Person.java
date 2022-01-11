import java.util.*;

public class Person {

  public Person(String inName, int inPets) {
    name = inName;
    pets = inPets;
  }

  public String name() {
    return name;
  }

  public int pets() {
    return pets;
  }

  private String name;
  private int pets;
}
