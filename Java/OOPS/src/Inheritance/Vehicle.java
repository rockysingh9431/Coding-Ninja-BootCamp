package src.Inheritance;

public abstract class Vehicle {
  protected int numWheels;
  protected int maxSpeed;

  protected Vehicle(){
    System.out.println("Vehicle");
  }
   Vehicle(int numWheels, int maxSpeed) {
    this.numWheels = numWheels;
    this.maxSpeed=maxSpeed;
    System.out.println("Vehicle");
  }
  protected void print(){
    System.out.println("This vehicle has " + numWheels + " wheels "+ " and maxSpeed "+maxSpeed+" kmph.");
  }
  public abstract boolean isMotorized();
}
