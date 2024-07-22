package src.Inheritance2;

import src.Inheritance.Vehicle;

public class Truck extends Vehicle {
    String color;
    int numDoors;

    public Truck(){
        System.out.println("Truck");
    }
    public Truck(String color, int numDoors){

    }
    public void print(){
        super.print();
        System.out.println("speed "+maxSpeed+" km/h "+" numWheels "+numWheels+" numDoors "+numDoors+" color "+color);
    }
    public boolean isMotorized(){
        return true;
    }
}
