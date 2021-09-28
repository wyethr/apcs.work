public class Greetings {

  public static String greetings(String name) {
    String nue = "Omg hi, " + name + ", I'm, like, so happy to see you!";

    return nue;
  }

  public static void testGreetings(String name, String expected) {
    String result = greetings(name);

    System.out.println("name: " + name +
                      " expected: " + expected +
                      " result: " + result);

    if(result.equals(expected)) {
      System.out.println("Riley wow!");
    }
    else {
      System.out.println("Riley not wow!");
    }
  }

  public static void main(String[] args) {
    testGreetings("Dr. Kessner", "Omg hi, Dr. Kessner, I'm, like, so happy to see you!");
    System.out.println("");

    testGreetings("Ascii Cat", "Omg hi, Ascii Cat, I'm, like, so happy to see you!");
    System.out.println("");

    testGreetings("Sydneys", "Omg hi, Sydneys, I'm, like, so happy to see you!");
    System.out.println("");
  }
}
