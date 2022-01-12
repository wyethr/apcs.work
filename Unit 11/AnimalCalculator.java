import java.util.*;

public class AnimalCalculator {

  public AnimalCalculator(ArrayList<Animal> animals) {
    this.animals = animals;
  }

  public void listAll() {
    for(Animal a: animals) {
      System.out.println("name: " + a.name());
      System.out.println("number of legs: " + a.legCount());

      if(a.furriness == true) {
        System.out.println("furry");
      }
      else {
        System.out.println("not furry... (but low-key kinda furry)");
      }

      System.out.println("");
    }
  }

  public float averageLegCount() {
    int count = 0;

    for(Animal a: animals) {
      count = count + a.legCount();
    }

    return (float)count/(float)animals.size();
  }

  public Animal lowestLegCount() {
    Animal count = animals.get(0);

    for(Animal a: animals) {
      if(a.legCount() < count.legCount()) {
        count = a;
      }
    }

    return count;
  }

  private ArrayList<Animal> animals;
}
