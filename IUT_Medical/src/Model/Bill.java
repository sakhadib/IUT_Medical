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
        String Query = "INSERT INTO BILL VALUES (" + 1 + ", " + this.referral.ID + ", " + this.Amount + ")";
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
                this.referral = new Referral(result.getInt("RefID"));
                this.Amount = result.getInt("Amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All() {
        List<Model> bills = new ArrayList<>();
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
        DB.Conn.close();
        return bills;
    }

    public static List<Model> showByStudent(String StudentID){
        List<Model> bills = new ArrayList<Model>();
        String Query = "SELECT * FROM BILL WHERE ID IN (SELECT ID FROM REFERRAL WHERE VisitID IN (SELECT ID FROM VISIT WHERE StudentID = '" + StudentID + "'))";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Bill bill = new Bill(result.getInt("ID"));
                bills.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return bills;
    }

    public static List<Model> showByDoctor(String DoctorID) {
        List<Model> bills = new ArrayList<Model>();
        String Query = "SELECT * FROM BILL WHERE ID IN (SELECT ID FROM REFERRAL WHERE VisitID IN (SELECT ID FROM VISIT WHERE DoctorID = '" + DoctorID + "'))";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Bill bill = new Bill(result.getInt("ID"));
                bills.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return bills;
    }

    public void printSignature() {

    }

    public String toString() {
        String S = "ID : " + this.ID +
                "\nStudent : " + this.referral.visit.student.name + "(" + this.referral.visit.student.ID + ")" +
                "\nDoctor : " + this.referral.visit.doctor.name + "(" + this.referral.visit.doctor.ID + ")" +
                "\nAmount : BDT " + this.Amount + "\n\n";
        return S;
    }

}
