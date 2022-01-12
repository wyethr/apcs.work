public class Animal {

  public Animal(String name, int legCount, boolean furriness) {
    this.name = name;
    this.legCount = legCount;
    this.furriness = furriness;
  }

  public String name() {
    return name;
  }

  public int legCount() {
    return legCount;
  }

  public boolean furriness() {
    return furriness;
  }

  protected String name;
  protected int legCount;
  protected boolean furriness;
}
