package Controller;




import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ReferralController extends Controller{
    public void create(){
        System.out.println("Creating a Referral");
        Scanner sc = new Scanner(System.in);
        System.out.println("Visit ID:");
        int visitID = sc.nextInt();
        System.out.println("Details:");
        String details = sc.nextLine();

        Model.Referral referral = new Model.Referral(visitID, details);
        referral.save();
    }

    public void details(){
        System.out.println("Referral Details by Visit ID");
        Scanner sc = new Scanner(System.in);
        System.out.println("Visit ID:");
        int visitID = sc.nextInt();

        show(Model.Referral.ShowByVisit(visitID));
    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Referral ID:");
        int referralID = sc.nextInt();

        Model.Referral referral = new Model.Referral(referralID);

        System.out.println("Enter the new Visit ID:");
        int visitID = sc.nextInt();
        System.out.println("Enter the new Details:");
        String details = sc.nextLine();

        Model.Visit visit = new Model.Visit(visitID);

        referral.visit = visit;
        referral.Details = details;

        referral.update();

        System.out.println("--- Referral updated successfully ---");
    }

    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Referral ID:");
        int referralID = sc.nextInt();

        Model.Referral referral = new Model.Referral(referralID);
        referral.delete();

        System.out.println("--- Referral deleted successfully ---");
    }


    public void populate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Referrals to populate:");
        int count = sc.nextInt();
        List<Model.Model> Visits = Model.Visit.All();
        List<Model.Model> Details = Model.Referral.All();

        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            Model.Referral referral = new Model.Referral(rand.nextInt(Visits.size()), "Random Details");
            referral.save();
        }
        System.out.println("\n--- Referrals populated successfully ---\n");


    }
}
