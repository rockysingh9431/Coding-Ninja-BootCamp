package src.Inheritance;

import src.Interface.PrintInterface;

public class Main {

  // Bounded generics
  public static <T extends PrintInterface> void printArray(T arr[]) {
    for (T arr1 : arr) {
      arr1.print();
    }
  }

  public static void main(String[] args) {

    Vehicle v[] = new Vehicle[5];
    for (int i = 0; i < 5; i++) {
      v[i] = new Car("Black", i * 20, i * 30, i * 100);
    }
    printArray(v);

    // Vehicle v = new Car("RED", 10, 20, 1000);
    // v.print();
    Vehicle v1 = new Car("blue", 10, 30, 300);
    Car c = (Car) v1;
    c.print();
    System.out.println(c.isMotorized());
    System.out.println(c.EngineCapacity());
    Car c1 = new Car("Black", 4, 4, 100);
    c1.print();
    // Truck t = new Truck();
    // t.print();
    // System.out.println(t.isMotorized());

    Bicycle b = new Bicycle();
    System.out.println(b.isMotorized());
    System.out.println(b.EngineCapacity());
  }
}