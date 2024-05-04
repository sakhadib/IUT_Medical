package Controller;

import java.util.Scanner;

public class DoctorController extends Controller{
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a Doctor");
        System.out.println("Doctor ID:");
        String ID = sc.nextLine();
        System.out.println("Doctor Name:");
        String name = sc.nextLine();
        System.out.println("Doctor Email:");
        String email = sc.nextLine();
        System.out.println("Doctor Specialty:");
        String Dept = sc.nextLine();

        Model.Doctor doctor = new Model.Doctor(ID, name, email, Dept);
        doctor.save();
        System.out.println("--- Doctor created successfully ---");
    }
}
