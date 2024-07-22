package src.Student;
public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student(22,"Rocky",7.6);
        s1.setRollNumber(400);
        System.out.println(Student.getConversionFactor());

        s1.print();
    }
}
