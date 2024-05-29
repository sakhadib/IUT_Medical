package Model;

import java.util.List;
import java.util.ArrayList;

public class Bill implements Model{
    public int ID;
    public Referral referral;
    public int Amount;

    public Bill(int referralID, int Amount) {
        this.referral = new Referral(referralID);
        this.Amount = Amount;
    }

    public Bill(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO BILL(ReferralID, Amount) VALUES (" + this.referral.ID + ", " + this.Amount + ")";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE BILL SET ReferralID = " + this.referral.ID + ", Amount = " + this.Amount + " WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM BILL WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM BILL WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.referral = new Referral(result.getInt("ReferralID"));
                this.Amount = result.getInt("Amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Bill> all() {
        List<Bill> bills = new ArrayList<Bill>();
        String Query = "SELECT * FROM BILL";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Bill bill = new Bill(result.getInt("ID"));
                bills.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }

    public void printSignature() {
        String signature = "ID\tReferralID\tAmount\n";
        System.out.println(signature);
    }

    public String toString() {
        return this.ID + "\t" + this.referral.ID + "\t" + this.Amount;
    }

}
