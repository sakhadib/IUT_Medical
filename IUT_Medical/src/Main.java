
import Controller.*;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {
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

            //Update Statements
            //Update a student
            else if(command.equals("update_student")){
                controller = new StudentController();
                controller.update();
            }

            //Update a doctor
            else if(command.equals("update_doctor")){
                controller = new DoctorController();
                controller.update();
            }

            //Update a medicine
            else if(command.equals("update_medicine")){
                controller = new MedicineController();
                controller.update();
            }

            //Update a test
            else if(command.equals("update_test")){
                controller = new TestController();
                controller.update();
            }

            //Update a visit
            else if(command.equals("update_visit")){
                controller = new VisitController();
                controller.update();
            }

            //Update a prescription
            else if(command.equals("update_prescription")){
                controller = new PresMedController();
                controller.update();
            }

            //Update a prescription test
            else if(command.equals("update_prescription_test")){
                controller = new PresTestController();
                controller.update();
            }

            //Update a referral
            else if(command.equals("update_referral")){
                controller = new ReferralController();
                controller.update();
            }

            //Update a bill
            else if(command.equals("update_bill")){
                controller = new BillController();
                controller.update();
            }

            //Delete Statements
            //Delete a student
            else if(command.equals("delete_student")){
                controller = new StudentController();
                controller.delete();
            }

            //Delete a doctor
            else if(command.equals("delete_doctor")){
                controller = new DoctorController();
                controller.delete();
            }

            //Delete a medicine
            else if(command.equals("delete_medicine")){
                controller = new MedicineController();
                controller.delete();
            }

            //Delete a test
            else if(command.equals("delete_test")){
                controller = new TestController();
                controller.delete();
            }

            //Delete a visit
            else if(command.equals("delete_visit")){
                controller = new VisitController();
                controller.delete();
            }

            //Delete a prescription
            else if(command.equals("delete_prescription")){
                controller = new PresMedController();
                controller.delete();
            }

            //Delete a prescription test
            else if(command.equals("delete_prescription_test")){
                controller = new PresTestController();
                controller.delete();
            }

            //Delete a referral
            else if(command.equals("delete_referral")){
                controller = new ReferralController();
                controller.delete();
            }

            //Delete a bill
            else if(command.equals("delete_bill")){
                controller = new BillController();
                controller.delete();
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

        System.out.println("[update_student] - Update a student");
        System.out.println("[update_doctor] - Update a doctor");
        System.out.println("[update_medicine] - Update a medicine");
        System.out.println("[update_test] - Update a test");
        System.out.println("[update_visit] - Update a visit");
        System.out.println("[update_prescription] - Update a prescription");
        System.out.println("[update_prescription_test] - Update a prescription test");
        System.out.println("[update_referral] - Update a referral");
        System.out.println("[update_bill] - Update a bill");

        System.out.println("[delete_student] - Delete a student");
        System.out.println("[delete_doctor] - Delete a doctor");
        System.out.println("[delete_medicine] - Delete a medicine");
        System.out.println("[delete_test] - Delete a test");
        System.out.println("[delete_visit] - Delete a visit");
        System.out.println("[delete_prescription] - Delete a prescription");
        System.out.println("[delete_prescription_test] - Delete a prescription test");
        System.out.println("[delete_referral] - Delete a referral");
        System.out.println("[delete_bill] - Delete a bill");

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