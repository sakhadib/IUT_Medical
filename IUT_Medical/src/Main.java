
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
        System.out.println("create_student");
        System.out.println("create_doctor");
        System.out.println("create_medicine");
        System.out.println("Create_test");
        System.out.println("visit");

        System.out.println("show_students");
        System.out.println("show_doctors");
        System.out.println("show_medicines");
        System.out.println("show_tests");
        System.out.println("show_visits");

        System.out.println("help");
        System.out.println("exit");
    }
}