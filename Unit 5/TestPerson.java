public class TestPerson {

  public static void main(String[] args) {
    Person riley = new Person("Riley", 1);
    Person emma = new Person("Emma", 2);
    Person melodie = new Person("Melodie", 3);

    System.out.println(riley.greeting());
    System.out.println(emma.greeting());
    System.out.println(melodie.greeting());

    System.out.println(riley.pets());
    System.out.println(riley.name());
  }
}
