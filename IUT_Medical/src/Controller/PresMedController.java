package Controller;

import java.util.List;
import java.util.Random;
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

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PrescriptionMedicine ID:");
        int pmID = sc.nextInt();

        Model.PresMed pm = new Model.PresMed(pmID);

        System.out.println("Enter the new Visit ID:");
        int visitID = sc.nextInt();
        System.out.println("Enter the new Medicine ID:");
        int medicineID = sc.nextInt();
        System.out.println("Enter the new Quantity:");
        int quantity = sc.nextInt();

        Model.Visit visit = new Model.Visit(visitID);
        Model.Medicine medicine = new Model.Medicine(medicineID);

        pm.visit = visit;
        pm.medicine = medicine;
        pm.quantity = quantity;

        pm.update();

        System.out.println("--- PrescriptionMedicine updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PrescriptionMedicine ID:");
        int pmID = sc.nextInt();

        Model.PresMed pm = new Model.PresMed(pmID);
        pm.delete();

        System.out.println("--- PrescriptionMedicine deleted successfully ---");
    }

    public void populate(int count){
        List<Model.Model> visits = Model.Visit.All();
        List<Model.Model> medicines = Model.Medicine.All();
        Random random = new Random();

        for(int i=0; i<count; i++){
            Model.Visit visit = (Model.Visit) visits.get(random.nextInt(visits.size()));
            Model.Medicine medicine = (Model.Medicine) medicines.get(random.nextInt(medicines.size()));
            int quantity = random.nextInt(10) + 1;

            Model.PresMed pm = new Model.PresMed(visit.ID, medicine.ID, quantity);
            pm.save();
        }

        System.out.println("--- PrescriptionMedicines populated successfully ---");
    }
}
