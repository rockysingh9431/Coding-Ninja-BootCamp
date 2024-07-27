package src.ExceptionHandling;

public class Main {
  public static double divide(int a, int b) throws DivideByZeroException {
    if (b == 0) {
      throw new DivideByZeroException();
    }
    return a / b;
  }

  public static void main(String[] args) {
    try {
      System.out.println(divide(2, 0));
    } catch (DivideByZeroException exception) {
      System.out.println("Divide by zero not allowed ");
    } finally {
      System.out.println("done exception handling");
    }
  }
}
