package Controller;

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
}
