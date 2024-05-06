package Controller;

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
}
