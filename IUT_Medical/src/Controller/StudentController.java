package Controller;

import java.util.Scanner;

public class StudentController extends Controller{
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a student");
        System.out.println("Student ID:");
        String ID = sc.nextLine();
        System.out.println("Student Name:");
        String name = sc.nextLine();
        System.out.println("Student Email:");
        String email = sc.nextLine();
        System.out.println("Student Department:");
        String Dept = sc.nextLine();

        Model.Student student = new Model.Student(ID, name, email, Dept);
        student.save();
        System.out.println("--- Student created successfully ---");
    }

    public void details(){

    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student ID:");
        String studentID = sc.nextLine();

        Model.Student student = new Model.Student(studentID);

        System.out.println("Enter the new Student Name:");
        String studentName = sc.nextLine();
        System.out.println("Enter the new Student Email:");
        String studentEmail = sc.nextLine();
        System.out.println("Enter the new Student Department:");
        String studentDept = sc.nextLine();

        student.name = studentName;
        student.email = studentEmail;
        student.Dept = studentDept;

        student.update();

        System.out.println("--- Student updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student ID:");
        String studentID = sc.nextLine();

        Model.Student student = new Model.Student(studentID);
        student.delete();

        System.out.println("--- Student deleted successfully ---");
    }
}
