package Controller;

import java.util.Scanner;

public class VisitController extends Controller{
    @Override
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a Visit");
        System.out.println("Doctor ID:");
        String doctorID = sc.nextLine();
        System.out.println("Student ID:");
        String studentID = sc.nextLine();

        Model.Visit visit = new Model.Visit(studentID, doctorID);
        visit.save();

        System.out.println("--- Visit created successfully ---");
    }

    @Override
    public void details(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which visit do you want to see?(doctor/student)");
        String visitType = sc.nextLine();
        if(visitType.equals("doctor")) {
            System.out.println("Enter the doctor ID:");
            String doctorID = sc.nextLine();
            show(Model.Visit.ShowByDoctor(doctorID));
        } else if(visitType.equals("student")) {
            System.out.println("Enter the student ID:");
            String studentID = sc.nextLine();
            show(Model.Visit.ShowByStudent(studentID));
        } else {
            System.out.println("Invalid visit type");
        }
    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Visit ID:");
        int visitID = sc.nextInt();

        Model.Visit visit = new Model.Visit(visitID);

        System.out.println("Enter the new Doctor ID:");
        String doctorID = sc.nextLine();
        System.out.println("Enter the new Student ID:");
        String studentID = sc.nextLine();

        Model.Doctor doctor = new Model.Doctor(doctorID);
        Model.Student student = new Model.Student(studentID);

        visit.doctor = doctor;
        visit.student = student;
        visit.update();

        System.out.println("--- Visit updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Visit ID:");
        int visitID = sc.nextInt();

        Model.Visit visit = new Model.Visit(visitID);
        visit.delete();

        System.out.println("--- Visit deleted successfully ---");
    }
}
