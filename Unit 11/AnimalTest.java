import java.util.*;

public class AnimalTest {

  public static void main(String[] args) {
    ArrayList<Animal> test1 = new ArrayList<Animal>();

    Animal dlowHuman = new Animal("human", 2, true);
    Cat dlowCat = new Cat("cat", 4, true);
    Sponge dlowSponge = new Sponge("sponge", 0, false);
    Centipede dlowCentipede = new Centipede("centipede", 100, false);

    test1.add(dlowHuman);
    test1.add(dlowCat);
    test1.add(dlowSponge);
    test1.add(dlowCentipede);

    AnimalCalculator test2 = new AnimalCalculator(test1);

    for(Animal a: test1) {
      System.out.println(a.name() + ":");
      System.out.println(a.legCount());
      System.out.println(a.furriness());
      System.out.println("");
    }

    test2.listAll();
    System.out.println(test2.averageLegCount());
    System.out.println("");

    System.out.println(test2.lowestLegCount().name());
  }
}
