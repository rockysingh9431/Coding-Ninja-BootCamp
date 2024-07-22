package src.Inheritance;

public class Bicycle extends Vehicle {
  String color;
  int numDoors;

  Bicycle(){
    System.out.println("Bicycle");
  }

  public boolean isMotorized(){
    return false;
  }
  
}
