package Controller;

import java.util.Scanner;

public class VisitController extends Controller{
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
}
