import java.util.*;

public class VehicleStats {

  public VehicleStats(ArrayList<Vehicle> vehiclesIn) {
    vehicles = vehiclesIn;
  }

  public int totalWheelCount() {
    int count = 0;

    for(Vehicle v: vehicles) {
      count = count + v.wheelCount();
    }

    return count;
  }

  public ArrayList<Vehicle> totalHumanPowered() {
    ArrayList<Vehicle> count = new ArrayList<Vehicle>();

    for(Vehicle v: vehicles) {
      if(v.isHumanPowered() == true) {
        count.add(v);
      }
    }

    return count;
  }

  private ArrayList<Vehicle> vehicles;
}
