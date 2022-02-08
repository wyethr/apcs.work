import java.util.*;

public class AcademicTest {

  //GENDER BEND CLASS!!!!!!

  public static void main(String[] args) {
    Teacher drFemner = new Teacher("Dr. Femner", "APCS");

    Student guyley = new Student("Guyley", 256); //BC 4 TO THE 4TH POWER IS DEATH TO THE DEATH POWER
    Student manodie = new Student("Manodie", 3); //BECAUSE <3 THAT'S SO CUTE
    Student emman = new Student("Emman", 512);
    Student manshley = new Student("Manshley", 17);
    Student sydboy = new Student("Sydboy", 3);
    Student nino = new Student("Nino", 7);
    Student shaboi = new Student("Shaboi", 14);
    Student rachad = new Student("Rachad", 91);

    AcademicClass genderBendAPCS = new AcademicClass(drFemner);
    genderBendAPCS.add(guyley);
    genderBendAPCS.add(manodie);
    genderBendAPCS.add(emman);
    genderBendAPCS.add(manshley);
    genderBendAPCS.add(sydboy);
    genderBendAPCS.add(nino);
    genderBendAPCS.add(shaboi);
    genderBendAPCS.add(rachad);

    System.out.println("");
    genderBendAPCS.classInfo();

    System.out.println("");
    System.out.println("ppl whose favorite number is 3: ");
    for(String s: genderBendAPCS.favoriteNumber(3)) {
      System.out.println(s);
    }

    System.out.println("");
    System.out.println("ppl whose favorite number is odd: ");
    for(String d: genderBendAPCS.oddNumber()) {
      System.out.println(d);
    }
  }
}
