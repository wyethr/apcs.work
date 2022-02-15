import java.util.*;

public class AcademicClass {

  public AcademicClass(Teacher teacher) {
    this.teacher = teacher;
    students = new ArrayList<Student>();
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public void add(Student student) {
    students.add(student);
  }

  public Teacher teacher() {
    return teacher;
  }

  public ArrayList<Student> students() {
    return students;
  }

  public void classInfo() {
    System.out.println("teacher: " + teacher.name());

    System.out.println("");
    System.out.println("students: ");
    for(Student a: students) {
      System.out.println(a.name());
    }
  }

  public ArrayList<String> favoriteNumber(int n) {
    ArrayList<String> count = new ArrayList<String>();

    for(Student b: students) {
      if(b.favoriteNumber() == n) {
        count.add(b.name() + ": " + b.favoriteNumber());
      }
    }

    return count;
  }

  public ArrayList<String> oddNumber() {
    ArrayList<String> count = new ArrayList<String>();

    for(Student b: students) {
      if(b.favoriteNumber()%2 == 1) {
        count.add(b.name() + ": " + b.favoriteNumber());
      }
    }

    return count;
  }

  private Teacher teacher;
  private ArrayList<Student> students;
}
