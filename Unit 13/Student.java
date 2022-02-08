public class Student {

  public Student(String name, int favoriteNumber) {
    this.name = name;
    this.favoriteNumber = favoriteNumber;
  }

  public String name() {
    return name;
  }

  public int favoriteNumber() {
    return favoriteNumber;
  }

  private String name;
  private int favoriteNumber;
}
