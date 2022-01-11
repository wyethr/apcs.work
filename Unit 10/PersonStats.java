import java.util.*;

public class PersonStats {

  public PersonStats(ArrayList<Person> inPersons) {
    persons = inPersons;
  }

  public float averagePets() {
    int count = 0;

    for(Person p: persons) {
      count = count + p.pets();
    }

    return count/persons.size();
  }

  public String mostPets() {
    Person count = persons.get(0);

    for(Person p: persons) {
      if(p.pets() > count.pets()) {
        count = p;
      }
    }

    return count.name();
  }

  public ArrayList<Person> overTwoPets() {
    ArrayList<Person> count = new ArrayList<Person>();

    for(Person p: persons) {
      if(p.pets() >= 2) {
        count.add(p);
      }
    }

    return count;
  }

  private ArrayList<Person> persons;
}
