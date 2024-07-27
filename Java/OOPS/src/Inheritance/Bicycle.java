package src.Inheritance;

import src.Interface.VehicleInterface;

public class Bicycle extends Vehicle implements VehicleInterface {
  String color;
  int numDoors;

  Bicycle() {
    System.out.println("Bicycle");
  }

  @Override
  public boolean isMotorized() {
    return false;
  }

  @Override
  public void print() {
    System.out.println("color of Bicycle: " + color + " number of Doors: " + numDoors);
  }

  @Override
  public String EngineCapacity() {
    return "No Engine";
  }
}
