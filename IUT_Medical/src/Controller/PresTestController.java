package Controller;

import Model.Test;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PresTestController extends Controller{
    public void create(){
        System.out.println("Adding A test to prescription");
        Scanner sc = new Scanner(System.in);
        System.out.println("visit ID:");
        int visitID = sc.nextInt();
        System.out.println("Test ID:");
        int testID = sc.nextInt();

        Model.PresTest presTest = new Model.PresTest(visitID, testID);
        presTest.save();

        System.out.println("--- Test added to prescription successfully ---");

    }

    public void details(){
        System.out.println("Which Details do you want to see?(test/doctor/student/visit)");
        Scanner sc = new Scanner(System.in);
        String detailsType = sc.nextLine();
        if(detailsType.equals("test")){
            System.out.println("Enter the Test ID:");
            int TestID = sc.nextInt();
            show(Model.PresTest.ShowByTest(TestID));
        }
        else if(detailsType.equals("doctor")){
            System.out.println("Enter the Doctor ID:");
            int doctorID = sc.nextInt();
            show(Model.PresTest.ShowByDoctor(doctorID));
        }
        else if(detailsType.equals("student")){
            System.out.println("Enter the Student ID:");
            int studentID = sc.nextInt();
            show(Model.PresTest.ShowByStudent(studentID));
        }
        else if(detailsType.equals("visit")){
            System.out.println("Enter the Visit ID:");
            int visitID = sc.nextInt();
            show(Model.PresTest.ShowByVisit(visitID));
        }
        else {
            System.out.println("Invalid details type");
        }
    }


}
