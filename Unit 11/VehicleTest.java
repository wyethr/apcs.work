import java.util.*;

public class VehicleTest {

  public static void main(String[] args) {
    ArrayList<Vehicle> test1 = new ArrayList<Vehicle>();

    Car car = new Car();
    Motorcycle motorcycle = new Motorcycle();
    Bicycle bicycle = new Bicycle();
    Unicycle unicycle = new Unicycle();

    test1.add(car);
    test1.add(motorcycle);
    test1.add(bicycle);
    test1.add(unicycle);

    VehicleStats test2 = new VehicleStats(test1);

    for(Vehicle v: test1) {
      System.out.println(v.name() + ":");
      System.out.println(v.wheelCount());
      System.out.println(v.isHumanPowered());
      System.out.println("");
    }

    System.out.println("total wheel count: " + test2.totalWheelCount());
    System.out.println("");

    System.out.println("total human powered count:");
    ArrayList<Vehicle> test3 = test2.totalHumanPowered();
    for(Vehicle v: test3) {
      System.out.println(v.name());
    }
  }
}
