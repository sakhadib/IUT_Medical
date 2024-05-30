package Controller;
import Model.PresTest;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
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

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PrescriptionTest ID:");
        int ptID = sc.nextInt();

        Model.PresTest pt = new Model.PresTest(ptID);

        System.out.println("Enter the new Visit ID:");
        int visitID = sc.nextInt();
        System.out.println("Enter the new Test ID:");
        int testID = sc.nextInt();

        Model.Visit visit = new Model.Visit(visitID);
        Model.Test test = new Model.Test(testID);

        pt.visit = visit;
        pt.test = test;

        pt.update();

        System.out.println("--- PrescriptionTest updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PrescriptionTest ID:");
        int ptID = sc.nextInt();

        Model.PresTest pt = new Model.PresTest(ptID);
        pt.delete();

        System.out.println("--- PrescriptionTest deleted successfully ---");
    }

    public void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of PrescriptionTests to populate:");
        int n = sc.nextInt();

        List<Model.Model> visits = Model.Visit.All();
        List<Model.Model> tests = Model.Test.All();
        Random rand = new Random();

        for(int i = 0; i < n; i++){
            Model.Visit visit = (Model.Visit)visits.get(rand.nextInt(visits.size()));
            Model.Test test = (Model.Test)tests.get(rand.nextInt(tests.size()));
            Model.PresTest pt = new Model.PresTest(visit.ID, test.ID);
            pt.save();
        }

        System.out.println("\n--- PrescriptionTests populated successfully ---\n");
    }


}
