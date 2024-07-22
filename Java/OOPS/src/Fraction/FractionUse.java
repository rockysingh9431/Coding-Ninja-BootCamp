package src.Fraction;

public class FractionUse {
  public static void main(String[] args) {
    Fraction f1=new Fraction(4,6);
    f1.printFraction();
    Fraction f2=new Fraction (3,5);

    Fraction f3=Fraction.add(f1,f2);
    f3.printFraction();
    
    Fraction f4=Fraction.subtract(f1,f2);
    f4.printFraction();

    Fraction f5=Fraction.divide(f1, f2);
    f5.printFraction();
  }
}
