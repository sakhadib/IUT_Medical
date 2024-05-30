package Controller;
import java.util.Scanner;
import java.util.List;

public class BillController extends Controller{
    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the referral ID:");
        int referralID = sc.nextInt();
        System.out.println("Enter the amount:");
        int amount = sc.nextInt();
        Model.Bill bill = new Model.Bill(referralID, amount);
        bill.save();
    }

    public void details(){
//        System.out.println("Which Details do you want to see?(student/doctor)");
//        Scanner sc = new Scanner(System.in);
//        String detailsType = sc.nextLine();
//        if(detailsType.equals("student")){
//            System.out.println("Enter the Student ID:");
//            int referralID = sc.nextInt();
//            show(Model.Bill.ShowByStudent(referralID));
//        }
//        else if(detailsType.equals("doctor")){
//            System.out.println("Enter the Doctor ID:");
//            int doctorID = sc.nextInt();
//            show(Model.Bill.ShowByDoctor(doctorID));
//        }
//        else {
//            System.out.println("Invalid details type");
//        }
//
    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Bill ID:");
        int billID = sc.nextInt();

        Model.Bill bill = new Model.Bill(billID);

        System.out.println("Enter the new referral ID:");
        int referralID = sc.nextInt();

        Model.Referral referral = new Model.Referral(referralID);

        System.out.println("Enter the new amount:");
        int amount = sc.nextInt();

        bill.referral = referral;
        bill.Amount = amount;
        bill.update();

        System.out.println("--- Bill updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Bill ID:");
        int billID = sc.nextInt();

        Model.Bill bill = new Model.Bill(billID);
        bill.delete();

        System.out.println("--- Bill deleted successfully ---");
    }

}
