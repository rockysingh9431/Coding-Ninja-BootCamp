package src.Inheritance;

public class Car extends Vehicle {
  String color;
  int numDoors;

  Car(String color,int numDoors,int numWheels,int maxSpeed){
    super(numWheels, maxSpeed);
    this.color = color;
    this.numDoors = numDoors; 
    System.out.println("Car");
  }
  public void print(){
    super.print();
    System.out.println("color "+color+" numDoors "+numDoors);
  }
  public boolean isMotorized(){
    return true;
  }
}
