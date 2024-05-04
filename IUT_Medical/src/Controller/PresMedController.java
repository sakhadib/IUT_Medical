package Controller;

import java.util.Scanner;

public class PresMedController extends Controller{
    @Override
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a new PrescriptionMedicine");
        System.out.println("Enter Visit ID: ");
        int visitID = sc.nextInt();
        System.out.println("Enter Medicine ID: ");
        int medicineID = sc.nextInt();
        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();

        Model.PresMed pm = new Model.PresMed(visitID, medicineID, quantity);
        pm.save();

        System.out.println("Medicine Added To Prescription Successfully!");
    }

    @Override
    public void details(){
        System.out.println("Which Details do you want to see?(medicine/doctor/student/visit)");
        Scanner sc = new Scanner(System.in);
        String detailsType = sc.nextLine();
        if(detailsType.equals("medicine")){
            System.out.println("Enter the Medicine ID:");
            int medicineID = sc.nextInt();
            show(Model.PresMed.ShowByMedicine(medicineID));
        } else if(detailsType.equals("doctor")){
            System.out.println("Enter the Doctor ID:");
            int doctorID = sc.nextInt();
            show(Model.PresMed.ShowByDoctor(doctorID));
        } else if(detailsType.equals("student")){
            System.out.println("Enter the Student ID:");
            int studentID = sc.nextInt();
            show(Model.PresMed.ShowByStudent(studentID));
        } else if(detailsType.equals("visit")){
            System.out.println("Enter the Visit ID:");
            int visitID = sc.nextInt();
            show(Model.PresMed.ShowByVisit(visitID));
        } else {
            System.out.println("Invalid details type");
        }
    }

}
