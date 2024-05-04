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
}
