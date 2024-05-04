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
}
