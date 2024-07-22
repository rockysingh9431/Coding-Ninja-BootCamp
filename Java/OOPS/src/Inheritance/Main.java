package src.Inheritance;
import src.Inheritance2.Truck;

public class Main {
  public static void main(String[] args) {

    Vehicle v=new Car("RED", 10, 20, 1000);
    v.print();
    Vehicle v1= new Car("blue",10,30,300);
    Car c=(Car)v1;
    c.print();
    System.out.println(c.isMotorized());
    Car c1=new Car("Black",4,4,100);
    c1.print();
    Truck t=new Truck();
    t.print();
    System.out.println(t.isMotorized());

    Bicycle b=new Bicycle();
    System.out.println(b.isMotorized());
  }
}