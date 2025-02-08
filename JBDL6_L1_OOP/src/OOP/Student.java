package OOP;

public class Student{
    int rollNo;
    String name;
    String email;
   static String collegeName;


    public Student(int rollNo, String name, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        System.out.println("Inside the toString");
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
