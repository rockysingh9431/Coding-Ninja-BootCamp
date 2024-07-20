package Student;
public class Student {
    private int rollNumber;
    private String name;
    double percentage;
    double cgpa;
    private final static double CONVERSION_FACTOR=0.95;

    Student(int rollNumber, String name, double cgpa){
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
        this.percentage = cgpa * CONVERSION_FACTOR*10;

    }

    public void print() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name);
        System.out.println(percentage);
    }
    public int getRollNumber(){
        return rollNumber;
    }

    public void setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }

    public static double getConversionFactor(){
        return CONVERSION_FACTOR;
    }
}