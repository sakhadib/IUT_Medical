package Model;

import java.util.List;
import java.util.ArrayList;

public class Referral implements Model{
    public int ID;
    public Visit visit;
    public String Details;

    public Referral(int visitID, String Details) {
        this.visit = new Visit(visitID);
        this.Details = Details;
    }

    public Referral(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO REFERRAL VALUES (" + 1 + ", " + this.visit.ID + ", '" + this.Details + "')";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE REFERRAL SET VisitID = " + this.visit.ID + ", Details = '" + this.Details + "' WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM REFERRAL WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM REFERRAL WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.visit = new Visit(result.getInt("VisitID"));
                this.Details = result.getString("Details");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All() {
        List<Model> referrals = new ArrayList<>();
        String Query = "SELECT * FROM REFERRAL";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                referrals.add(new Referral(result.getInt("ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return referrals;
    }

    public static List<Model> ShowByVisit(int visitID){
        List<Model> referrals = new ArrayList<>();
        String Query = "SELECT * FROM REFERRAL WHERE VisitID = " + visitID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                referrals.add(new Referral(result.getInt("ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return referrals;
    }

    public void printSignature(){

    }

    public String toString(){
        String S = "ID : " + this.ID +
            "\nStudent : " + this.visit.student.name + "(" + this.visit.student.ID + ")" +
                "\nDoctor : " + this.visit.doctor.name + "(" + this.visit.doctor.ID + ")" +
                "\nDate : " + this.visit.date +
            "\nDetails : " + this.Details + "\n\n";
        return S;
    }

}
