public class Person {

  public Person(String nameIn, int petsIn) {
    name = nameIn;
    pets = petsIn;
  }

  public String greeting() {
    return "Hello, my name is " + name + " and I have " + pets + " pets.";
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
