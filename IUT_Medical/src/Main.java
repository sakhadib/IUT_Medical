
import Controller.*;

import javax.print.Doc;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n");

        System.out.println("Welcome to the IUT Medical Center");
        Controller controller = null;

        System.out.println("\n");

        label:
        do {
            help.help();
            System.out.println("Enter a command:");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String command = sc.nextLine();

            //Create Statements
            switch (command) {
                case "create": {
                    help.help_create();
                    System.out.println("Enter a command:");
                    java.util.Scanner scc = new java.util.Scanner(System.in);
                    String commands = sc.nextLine();
                    //Create a new student
                    if (commands.equals("student")) {
                        controller = new StudentController();
                        controller.create();
                    }

                    //Create a new doctor
                    else if (commands.equals("doctor")) {
                        controller = new DoctorController();
                        controller.create();
                    }

                    //Create a new medicine
                    else if (commands.equals("medicine")) {
                        controller = new MedicineController();
                        controller.create();
                    }

                    //Create a new test
                    else if (commands.equals("test")) {
                        controller = new TestController();
                        controller.create();
                    }

                    //Create a new visit
                    else if (commands.equals("visit")) {
                        controller = new VisitController();
                        controller.create();
                    }

                    //Create a new prescription
                    else if (commands.equals("presmed")) {
                        controller = new PresMedController();
                        controller.create();
                    }

                    //Create a new prescription test
                    else if (commands.equals("prestest")) {
                        controller = new PresTestController();
                        controller.create();
                    }

                    else if (commands.equals("back")) {
                        break;
                    }
                    else{
                        System.out.println("Invalid command! Please see the help menu and provide a valid command.");
                    }

                    break;
                }

                //Update Statements
                case "update": {

                    help.help_update();

                    System.out.println("Enter a command:");
                    java.util.Scanner scc = new java.util.Scanner(System.in);
                    String commands = sc.nextLine();

                    //Update a student
                    if (commands.equals("student")) {
                        controller = new StudentController();
                        controller.update();
                    }

                    //Update a doctor
                    else if (commands.equals("doctor")) {
                        controller = new DoctorController();
                        controller.update();
                    }

                    //Update a medicine
                    else if (commands.equals("medicine")) {
                        controller = new MedicineController();
                        controller.update();
                    }

                    //Update a test
                    else if (commands.equals("test")) {
                        controller = new TestController();
                        controller.update();
                    }

                    //Update a visit
                    else if (commands.equals("visit")) {
                        controller = new VisitController();
                        controller.update();
                    }

                    //Update a prescription
                    else if (commands.equals("prescription")) {
                        controller = new PresMedController();
                        controller.update();
                    }

                    //Update a prescription test
                    else if (commands.equals("prescription_test")) {
                        controller = new PresTestController();
                        controller.update();
                    }

                    //Update a referral
                    else if (commands.equals("referral")) {
                        controller = new ReferralController();
                        controller.update();
                    }

                    //Update a bill
                    else if (commands.equals("bill")) {
                        controller = new BillController();
                        controller.update();
                    } else if (commands.equals("back")) {
                        break;
                    }
                    else{
                        System.out.println("Invalid command! Please see the help menu and provide a valid command.");
                    }
                    break;
                }

                //Delete Statements
                case "delete": {

                    help.help_delete();

                    System.out.println("Enter a command:");
                    java.util.Scanner scc = new java.util.Scanner(System.in);
                    String commands = sc.nextLine();

                    //Delete a student
                    if (commands.equals("student")) {
                        controller = new StudentController();
                        controller.delete();
                    }

                    //Delete a doctor
                    else if (commands.equals("doctor")) {
                        controller = new DoctorController();
                        controller.delete();
                    }

                    //Delete a medicine
                    else if (commands.equals("medicine")) {
                        controller = new MedicineController();
                        controller.delete();
                    }

                    //Delete a test
                    else if (commands.equals("test")) {
                        controller = new TestController();
                        controller.delete();
                    }

                    //Delete a visit
                    else if (commands.equals("visit")) {
                        controller = new VisitController();
                        controller.delete();
                    }

                    //Delete a prescription
                    else if (commands.equals("prescription")) {
                        controller = new PresMedController();
                        controller.delete();
                    }

                    //Delete a prescription test
                    else if (commands.equals("prescription_test")) {
                        controller = new PresTestController();
                        controller.delete();
                    }

                    //Delete a referral
                    else if (commands.equals("referral")) {
                        controller = new ReferralController();
                        controller.delete();
                    }

                    //Delete a bill
                    else if (commands.equals("bill")) {
                        controller = new BillController();
                        controller.delete();
                    } else if (commands.equals("back")) {
                        break;
                    }
                    else{
                        System.out.println("Invalid command! Please see the help menu and provide a valid command.");
                    }
                    break;
                }

                //Show Statements
                case "show": {

                    help.help_show();

                    System.out.println("Enter a command:");
                    java.util.Scanner scc = new java.util.Scanner(System.in);
                    String commands = sc.nextLine();

                    //Show all students
                    if (commands.equals("students")) {
                        controller = new StudentController();
                        controller.show(Model.Student.All());
                    }

                    //Show all doctors
                    else if (commands.equals("doctors")) {
                        controller = new DoctorController();
                        controller.show(Model.Doctor.All());
                    }

                    //Show all medicines
                    else if (commands.equals("medicines")) {
                        controller = new MedicineController();
                        controller.show(Model.Medicine.All());
                    }

                    //Show all tests
                    else if (commands.equals("tests")) {
                        controller = new TestController();
                        controller.show(Model.Test.All());
                    }

                    //Show all visits
                    else if (commands.equals("visits")) {
                        controller = new VisitController();
                        controller.show(Model.Visit.All());
                    }

                    //Show detailed visit
                    else if (commands.equals("detailed_visit")) {
                        controller = new VisitController();
                        controller.details();
                    }

                    //Show all prescriptions
                    else if (commands.equals("prescriptions")) {
                        controller = new PresMedController();
                        controller.show(Model.PresMed.All());
                    }

                    //Show all tests
                    else if (commands.equals("prescribed_tests")) {
                        controller = new PresTestController();
                        controller.show(Model.PresTest.All());
                    }

                    //Show all referrals
                    else if (commands.equals("referrals")) {
                        controller = new ReferralController();
                        controller.show(Model.Referral.All());
                    }

                    //Show detailed prescription
                    else if (commands.equals("detailed_prescription")) {
                        controller = new PresMedController();
                        controller.details();
                    }

                    //Show detailed Test
                    else if (commands.equals("detailed_prescribed_test")) {
                        controller = new PresTestController();
                        controller.details();
                    }

                    //Show detailed Referral
                    else if (commands.equals("detailed_Referral")) {
                        controller = new ReferralController();
                        controller.details();
                    } else if (commands.equals("back")) {
                        break;
                    }
                    else{
                        System.out.println("Invalid command! Please see the help menu and provide a valid command.");
                    }
                    break;
                }

                //Populate Statements
                case "populate":{
                    help.help_populate();

                    System.out.println("Enter a command:");
                    java.util.Scanner scc = new java.util.Scanner(System.in);
                    String commands = sc.nextLine();

                    //Populate students
                    if (commands.equals("students")) {
                        StudentController sc1 = new StudentController();
                        sc1.populate();
                    }
                    else if (commands.equals("doctors")) {
                        DoctorController dc1 = new DoctorController();
                        dc1.populate();
                    }
                    else if (commands.equals("medicines")) {
                        MedicineController mc1 = new MedicineController();
                        mc1.populate();
                    }
                    else if (commands.equals("tests")) {
                        TestController tc1 = new TestController();
                        tc1.populate();
                    }
                    else if (commands.equals("visits")) {
                        VisitController vc1 = new VisitController();
                        vc1.populate();
                    }
                    else if (commands.equals("presmeds")) {
                        PresMedController pmc1 = new PresMedController();
                        pmc1.populate();
                    }
                    else if (commands.equals("prestests")) {
                        PresTestController ptc1 = new PresTestController();
                        ptc1.populate();
                    }
                    else if (commands.equals("referrals")) {
                        ReferralController rc1 = new ReferralController();
                        rc1.populate();
                    }
                    else if (commands.equals("bills")) {
                        BillController bc1 = new BillController();
                        bc1.populate();
                    }
                    else if (commands.equals("back")) {
                        break;
                    }

                    else{
                        System.out.println("Invalid command! Please see the help menu and provide a valid command.");
                    }

                    break;
                }

                //Exit
                case "exit":
                    break label;


                //Invalid command
                default:
                    System.out.println("Invalid command! Please see the help menu and provide a valid command.");
                    break;
            }
        } while (true);
    }
}