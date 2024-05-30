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
}
