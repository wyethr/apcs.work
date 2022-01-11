import java.util.*;

public class PersonTest {

  public static void main(String[] args) {
    Person ruwu = new Person("ruwu", (int)1);
    Person dlow = new Person("dlow", (int)21);
    Person emma = new Person("emma", (int)2);
    ArrayList<Person> inPersons = new ArrayList<Person>();
    inPersons.add(ruwu);
    inPersons.add(dlow);
    inPersons.add(emma);
    PersonStats persons = new PersonStats(inPersons);

    System.out.println("ruwu name = " + ruwu.name());
    System.out.println("dlow name = " + dlow.name());
    System.out.println("ruwu pets = " + ruwu.pets());
    System.out.println("dlow pets = " + dlow.pets());
    System.out.println("");

    System.out.println("average pets = " + persons.averagePets());
    System.out.println("");
    System.out.println("most number of pets = " + persons.mostPets());
    System.out.println("");
    System.out.println("people with more than two pets = ");
    for(Person p: persons.overTwoPets()) {
      System.out.println(p.name());
    }
  }

}
