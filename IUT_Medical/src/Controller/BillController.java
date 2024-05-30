package Controller;



import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class BillController extends Controller {
    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the referral ID:");
        int referralID = sc.nextInt();
        System.out.println("Enter the amount:");
        int amount = sc.nextInt();
        Model.Bill bill = new Model.Bill(referralID, amount);
        bill.save();
    }

    public void details() {
        System.out.println("Which Details do you want to see?(student/doctor)");
        Scanner sc = new Scanner(System.in);
        String detailsType = sc.nextLine();
        if(detailsType.equals("student")){
            System.out.println("Enter the Student ID:");
            String StudentID = sc.nextLine();
            show(Model.Bill.showByStudent(StudentID));
        }
        else if(detailsType.equals("doctor")){
            System.out.println("Enter the Doctor ID:");
            String doctorID = sc.nextLine();
            show(Model.Bill.showByDoctor(doctorID));
        }
        else {
            System.out.println("Invalid details type");
        }

    }

    public void update() {
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

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Bill ID:");
        int billID = sc.nextInt();

        Model.Bill bill = new Model.Bill(billID);
        bill.delete();

        System.out.println("--- Bill deleted successfully ---");
    }


    public void populate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bills to populate:");
        int count = sc.nextInt();
        List<Model.Model> Referrals = Model.Referral.All();

        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            Model.Referral referral = (Model.Referral) Referrals.get(rand.nextInt(Referrals.size()));
            int amount = rand.nextInt(1000);
            Model.Bill bill = new Model.Bill(referral.ID, amount);
            bill.save();

        }
        System.out.println("--- Bills populated successfully ---");
    }
}

