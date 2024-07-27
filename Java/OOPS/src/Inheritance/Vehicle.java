package src.Inheritance;

import src.Interface.PrintInterface;

public class Vehicle implements PrintInterface {
  protected int numWheels;
  protected int maxSpeed;

  protected Vehicle() {
    System.out.println("Vehicle");
  }

  Vehicle(int numWheels, int maxSpeed) {
    this.numWheels = numWheels;
    this.maxSpeed = maxSpeed;
    System.out.println("Vehicle");
  }

  @Override
  public void print() {
    System.out.println("This vehicle has " + numWheels + " wheels " + " and maxSpeed " + maxSpeed + " kmph.");
  }

}
