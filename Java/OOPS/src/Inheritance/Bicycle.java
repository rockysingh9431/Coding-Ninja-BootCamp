package src.Inheritance;

import src.Interface.VehicleInterface;

public class Bicycle extends Vehicle implements VehicleInterface {
  String color;
  int numDoors;

  Bicycle() {
    System.out.println("Bicycle");
  }

  public boolean isMotorized() {
    return false;
  }

  public String EngineCapacity() {
    return "No Engine";
  }
}
