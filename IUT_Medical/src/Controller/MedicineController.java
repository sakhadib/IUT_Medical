package Controller;

import Utility.MedsHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class MedicineController extends Controller{
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a Medicine");
        System.out.println("Medicine Name:");
        String name = sc.nextLine();
        System.out.println("Medicine Generic:");
        String generic = sc.nextLine();
        System.out.println("Medicine Company:");
        String company = sc.nextLine();
        System.out.println("Medicine Quantity:");
        int quantity = sc.nextInt();

        Model.Medicine medicine = new Model.Medicine(name, generic, company, quantity);
        medicine.save();
        System.out.println("--- Medicine created successfully ---");
    }

    public void details(){

    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Medicine ID:");
        int medicineID = sc.nextInt();

        Model.Medicine medicine = new Model.Medicine(medicineID);

        System.out.println("Enter the new Medicine Name:");
        String medicineName = sc.nextLine();
        System.out.println("Enter the new Medicine Generic:");
        String medicineGeneric = sc.nextLine();
        System.out.println("Enter the new Medicine Company:");
        String medicineCompany = sc.nextLine();
        System.out.println("Enter the new Medicine Quantity:");
        int medicineQuantity = sc.nextInt();

        medicine.name = medicineName;
        medicine.generic = medicineGeneric;
        medicine.company = medicineCompany;
        medicine.quantity = medicineQuantity;

        medicine.update();

        System.out.println("--- Medicine updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Medicine ID:");
        int medicineID = sc.nextInt();

        Model.Medicine medicine = new Model.Medicine(medicineID);
        medicine.delete();

        System.out.println("--- Medicine deleted successfully ---");
    }

    public void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of medicines to populate:");
        int count = sc.nextInt();

        Random rand = new Random();

        List<String> medsName = MedsHelper.getRandomMeds(count);
        List<String> medsGeneric = MedsHelper.getRandomGeneric(count);
        List<String> medsCompany = MedsHelper.getRandomCompany(count);

        for(int i=0; i<count; i++){
            String name = medsName.get(i);
            String generic = medsGeneric.get(i);
            String company = medsCompany.get(i);
            int quantity = rand.nextInt(50)*100;

            Model.Medicine medicine = new Model.Medicine(name, generic, company, quantity);
            medicine.save();
        }

        System.out.println("\n--- Medicines populated successfully ---\n");
    }
}
