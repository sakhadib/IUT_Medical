package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Stat {
    public static void generateStudentReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        String studentID = scanner.nextLine();

        Model.Student student = new Model.Student(studentID);

        StringBuilder report = new StringBuilder();
        report.append("Student ID: ").append(student.ID).append("\n");
        report.append("Student Name: ").append(student.name).append("\n");
        report.append("Student Email: ").append(student.email).append("\n");
        report.append("Department: ").append(student.Dept).append("\n\n\n");

        report.append("Detailed Report:\n");

        List<Model.Model> visits = Model.Visit.ShowByStudent(studentID);
        for (Model.Model visit : visits) {
            Model.Visit v = (Model.Visit) visit;
            report.append("Visit ID: ").append(v.ID).append("\n");
            report.append("Doctor ID: ").append(v.doctor.ID).append("\n");
            report.append("Doctor Name: ").append(v.doctor.name).append("\n");
            report.append("Visit Date: ").append(v.date).append("\n\n");
            report.append("Prescribed Medicines: \n");
            List<Model.Model> presmeds = Model.PresMed.ShowByVisit(v.ID);
            for (Model.Model presmed : presmeds) {
                Model.PresMed pm = (Model.PresMed) presmed;
                report.append(pm.medicine.name).append("\n");
            }
            report.append("\n\n");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String currentDateUpToSeconds = formatter.format(date);

        String fileName = "StudentReport_" + studentID + "_" + currentDateUpToSeconds + ".txt";
        String directory = "D:\\Repos\\Medcenter\\Reports\\";
        String filePath = directory + fileName;

        try {
            // Write the report to the file using Stream API
            Files.write(Paths.get(filePath), report.toString().getBytes(), StandardOpenOption.CREATE);
            System.out.println("Report generated successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report: " + e.getMessage());
        }
    }

    public static void generateDoctorReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor ID: ");
        String doctorID = scanner.nextLine();

        Model.Doctor doctor = new Model.Doctor(doctorID);

        StringBuilder report = new StringBuilder();
        report.append("Doctor ID: ").append(doctor.ID).append("\n");
        report.append("Doctor Name: ").append(doctor.name).append("\n");
        report.append("Doctor Email: ").append(doctor.email).append("\n");
        report.append("Department: ").append(doctor.Specialization).append("\n\n\n");

        report.append("Detailed Report:\n");

        List<Model.Model> visits = Model.Visit.ShowByDoctor(doctorID);
        for (Model.Model visit : visits) {
            Model.Visit v = (Model.Visit) visit;
            report.append("Visit ID: ").append(v.ID).append("\n");
            report.append("Student ID: ").append(v.student.ID).append("\n");
            report.append("Student Name: ").append(v.student.name).append("\n");
            report.append("Visit Date: ").append(v.date).append("\n\n");
            report.append("Prescribed Medicines: \n");
            List<Model.Model> presmeds = Model.PresMed.ShowByVisit(v.ID);
            for (Model.Model presmed : presmeds) {
                Model.PresMed pm = (Model.PresMed) presmed;
                report.append(pm.medicine.name + "[ " + pm.medicine.quantity + " ]").append("\n");
            }
            report.append("\n\n");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String currentDateUpToSeconds = formatter.format(date);

        String fileName = "DoctorReport_" + doctorID + "_" + currentDateUpToSeconds + ".txt";
        String directory = "D:\\Repos\\Medcenter\\Reports\\";
        String filePath = directory + fileName;

        try {
            // Write the report to the file using Stream API
            Files.write(Paths.get(filePath), report.toString().getBytes(), StandardOpenOption.CREATE);
            System.out.println("Report generated successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report: " + e.getMessage());
        }
    }

    public static void generateMedicineReport(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Medicine ID: ");
        int medicineID = scanner.nextInt();

        Model.Medicine medicine = new Model.Medicine(medicineID);

        StringBuilder report = new StringBuilder();
        report.append("Medicine ID: ").append(medicine.ID).append("\n");
        report.append("Medicine Name: ").append(medicine.name).append("\n");
        report.append("Medicine Quantity: ").append(medicine.quantity).append("\n\n");


        report.append("Detailed Report:\n");

        List<Model.Model> presMeds = Model.PresMed.ShowByMedicine(medicineID);
        for (Model.Model presMed : presMeds) {
            Model.PresMed pm = (Model.PresMed) presMed;
            report.append("Prescription ID: ").append(pm.ID).append("\n");
            report.append("Visit ID: ").append(pm.visit.ID).append("\n");
            report.append("Student ID: ").append(pm.visit.student.ID).append("\n");
            report.append("Doctor ID: ").append(pm.visit.doctor.ID).append("\n");
            report.append("Quantity: ").append(pm.quantity).append("\n\n");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String currentDateUpToSeconds = formatter.format(date);

        String fileName = "MedicineReport_" + medicineID + "_" + currentDateUpToSeconds + ".txt";
        String directory = "D:\\Repos\\Medcenter\\Reports\\";
        String filePath = directory + fileName;

        try {
            // Write the report to the file using Stream API
            Files.write(Paths.get(filePath), report.toString().getBytes(), StandardOpenOption.CREATE);
            System.out.println("Report generated successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report: " + e.getMessage());
        }
    }


}
