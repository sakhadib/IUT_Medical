
import Controller.*;

import javax.print.Doc;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the IUT Medical Center");
        System.out.println("Type 'help' to see the available commands");
        Controller controller = null;

        do{
            System.out.println("Enter a command:");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String command = sc.nextLine();

            //Create Statements
            //Create a new student
            if(command.equals("create_student")){
                controller = new StudentController();
                controller.create();
            }

            //Create a new doctor
            else if(command.equals("create_doctor")){
                controller = new DoctorController();
                controller.create();
            }

            //Create a new medicine
            else if(command.equals("create_medicine")){
                controller = new MedicineController();
                controller.create();
            }

            //Create a new test
            else if(command.equals("create_test")){
                controller = new TestController();
                controller.create();
            }

            //Create a new visit
            else if(command.equals("visit")){
                controller = new VisitController();
                controller.create();
            }

            //Help
            else if(command.equals("help")){
                help();
            }


            //Show Statements
            //Show all students
            else if(command.equals("show_students")){
                controller = new StudentController();
                controller.show(Model.Student.All());
            }

            //Show all doctors
            else if(command.equals("show_doctors")){
                controller = new DoctorController();
                controller.show(Model.Doctor.All());
            }

            //Show all medicines
            else if(command.equals("show_medicines")){
                controller = new MedicineController();
                controller.show(Model.Medicine.All());
            }

            //Show all tests
            else if(command.equals("show_tests")){
                controller = new TestController();
                controller.show(Model.Test.All());
            }

            //Show all visits
            else if(command.equals("show_visits")){
                controller = new VisitController();
                controller.show(Model.Visit.All());
            }

            //Show detailed visit
            else if(command.equals("detailed_visit")){
                controller = new VisitController();
                controller.details();
            }

            //Show all prescriptions
            else if(command.equals("show_prescriptions")){
                controller = new PresMedController();
                controller.show(Model.PresMed.All());
            }

            //Show all tests
            else if(command.equals("show_prestests")){
                controller = new PresTestController();
                controller.show(Model.PresTest.All());
            }

            //Show all referrals
            else if(command.equals("show_referrals")){
                controller = new ReferralController();
                controller.show(Model.Referral.All());
            }

            //Show detailed prescription
            else if(command.equals("detailed_prescription")){
                controller = new PresMedController();
                controller.details();
            }

            //Show detailed Test
            else if(command.equals("detailed_Test")){
                controller = new PresTestController();
                controller.details();
            }

            //Show detailed Referral
            else if(command.equals("detailed_Referral")){
                controller = new ReferralController();
                controller.details();
            }

            //Exit
            else if (command.equals("exit")) {
                break;
            }

            //Invalid command
            else {
                System.out.println("Invalid command");
            }
        }while(true);
    }

    public static void help(){
        System.out.println("Here are the available commands:");
        System.out.println("[create_student] - Create a new student");
        System.out.println("[create_doctor] - Create a new doctor");
        System.out.println("[create_medicine] - Create a new medicine");
        System.out.println("[Create_test] - Create a new test");
        System.out.println("[visit] - Create a new visit");

        System.out.println("[show_students] - Show all students");
        System.out.println("[show_doctors] - Show all doctors");
        System.out.println("[show_medicines] - Show all medicines");
        System.out.println("[show_tests] - Show all tests");
        System.out.println("[show_visits] - Show all visits");
        System.out.println("[show_prescriptions] - Show all prescriptions");
        System.out.println("[show_prestests] - Show all prescribed Tests");
        System.out.println("[show_referrals] - Show all referrals");
        System.out.println("[detailed_visit] - Show detailed visit by doctor or student");
        System.out.println("[detailed_prescription] - Show detailed prescription by medicine or doctor or student or visit");
        System.out.println("[detailed_Test] - Show detailed Test by doctor or student or visit");
        System.out.println("[detailed_Referral] - Show detailed Referral by visit");


        System.out.println("help");
        System.out.println("exit");
    }

}