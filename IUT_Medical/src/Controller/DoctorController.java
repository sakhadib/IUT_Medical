package Controller;

import java.util.List;
import java.util.Scanner;

public class DoctorController extends Controller{
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a Doctor");
        System.out.println("Doctor Name:");
        String name = sc.nextLine();
        System.out.println("Doctor Email:");
        String email = sc.nextLine();
        System.out.println("Doctor Specialty:");
        String Dept = sc.nextLine();

        Model.Doctor doctor = new Model.Doctor(name, email, Dept);
        doctor.save();
        System.out.println("--- Doctor created successfully ---");
    }

    public void details(){

    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Doctor ID:");
        String doctorID = sc.nextLine();

        Model.Doctor doctor = new Model.Doctor(doctorID);
        System.out.println("Enter the new Doctor Name:");
        String doctorName = sc.nextLine();
        System.out.println("Enter the new Doctor Email:");
        String doctorEmail = sc.nextLine();
        System.out.println("Enter the new Doctor Specialty:");
        String doctorSpecialty = sc.nextLine();

        doctor.name = doctorName;
        doctor.email = doctorEmail;
        doctor.Specialization = doctorSpecialty;

        doctor.update();

        System.out.println("--- Doctor updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Doctor ID:");
        String doctorID = sc.nextLine();

        Model.Doctor doctor = new Model.Doctor(doctorID);
        doctor.delete();

        System.out.println("--- Doctor deleted successfully ---");
    }

    public void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Doctors to populate:");
        int count = sc.nextInt();

        List<String> names = Utility.DoctorHelper.getUniqueNames(count);
        List<String> specializations = Utility.DoctorHelper.getSpecializations(count);
        List<String> emails = Utility.DoctorHelper.getEmails(names);

        for (int i = 0; i < count; i++) {
            Model.Doctor doctor = new Model.Doctor(names.get(i), emails.get(i), specializations.get(i));
            doctor.save();
        }

        System.out.println("\n--- Doctors populated successfully ---\n");
    }
}
