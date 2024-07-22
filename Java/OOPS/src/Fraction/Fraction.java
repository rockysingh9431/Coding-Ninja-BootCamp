package src.Fraction;

public class Fraction {
  private int numerator;
  private int denominator;

  Fraction(int numerator, int denominator){
    if(denominator==0){
      throw new IllegalArgumentException("Denominator cannot be zero");
    }else{
      this.denominator=denominator;
      this.numerator=numerator;
    }

    simplify();
  }

  private void simplify(){
    int a=this.numerator;
    int b=this.denominator;
    while(b!=0){
      int temp=b;
      b=a%b;
      a=temp;
    }
    numerator/=a;
    denominator/=a;
  }

  public void printFraction(){
    System.out.println(numerator+"/"+denominator);
  }
  public int getNumerator(){
    return this.numerator;
  }
  public void setNumerator(int numerator){
    this.numerator=numerator;
    simplify();
  }

  public int getDenominator(){
    return this.denominator;
  }
  public void setDenominator(int denominator){
    if(denominator==0){
      throw new IllegalArgumentException("Denominator cannot be zero");
    }else{
      this.denominator=denominator;
      simplify();
    }
  }


  // Add Subtarct Multiply and DIVIDE fnctions


  public static Fraction add(Fraction f1,Fraction f2){
    int newNum=f1.numerator*f2.denominator+f1.denominator*f2.numerator;
    int newDen=f1.denominator*f2.denominator;

    Fraction f3=new Fraction(newNum,newDen);
    return f3;
  }

   public static Fraction subtract(Fraction f1,Fraction f2){
    int newNum=Math.abs(f1.numerator*f2.denominator-f1.denominator*f2.numerator);
    int newDen=f1.denominator*f2.denominator;

    Fraction f3=new Fraction(newNum,newDen);
    return f3;
  }
   public static Fraction multiply(Fraction f1,Fraction f2){
    int newNum=Math.abs(f1.numerator*f2.numerator);
    int newDen=f1.denominator*f2.denominator;

    Fraction f3=new Fraction(newNum,newDen);
    return f3;
  }

  public static Fraction divide(Fraction f1,Fraction f2){
    int newNum=f1.numerator*f2.denominator;
    int newDen=f1.denominator*f2.numerator;

    Fraction f3=new Fraction(newNum,newDen);
    return f3; 
  }
}
//getNumerator
//setNumerator
//add
//subtract
//multiply
//Fraction add and Return 
//Simplify
//Constructor for(numerator, denominator)

