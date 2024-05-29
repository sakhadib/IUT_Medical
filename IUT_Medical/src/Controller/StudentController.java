package Controller;

import Utility.StudentHelper;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class StudentController extends Controller{
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a student");
        System.out.println("Student Name:");
        String name = sc.nextLine();
        System.out.println("Student Email:");
        String email = sc.nextLine();
        System.out.println("Student Department:");
        String Dept = sc.nextLine();

        if(!Dept.equals("CSE") && !Dept.equals("EEE") && !Dept.equals("CEE") && !Dept.equals("MPE") && !Dept.equals("BTM")){
            System.out.println("Invalid Department");
            return;
        }

        Model.Student student = new Model.Student(name, email, Dept);
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


    public void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students to populate:");
        int count = sc.nextInt();

        List<String> names = Utility.StudentHelper.getUniqueNames(count);
        List<String> emails = Utility.StudentHelper.getEmails(names);
        String[] depts = StudentHelper.depts;
        Random random = new Random(); // Initialize Random instance

        for(int i = 0; i < count; i++){
            String name = names.get(i);
            String email = emails.get(i);
            String dept = depts[random.nextInt(depts.length)]; // Use random.nextInt()
            Model.Student student = new Model.Student(name, email, dept);
            student.save();
        }
    }

}
