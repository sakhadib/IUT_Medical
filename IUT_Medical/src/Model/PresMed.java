package Model;

import java.util.List;
import java.util.ArrayList;

public class PresMed implements Model{
    public int ID;
    public Visit visit;
    public Medicine medicine;
    public int quantity;

    public PresMed(int visitID, int medicineID, int quantity) {
        this.visit = new Visit(visitID);
        this.medicine = new Medicine(medicineID);
        this.quantity = quantity;
    }

    public PresMed(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO PRESMED VALUES ('" + 1 + "', " + this.visit.ID + ", " + this.medicine.ID + ", " + this.quantity + ")";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        medicine.quantity -= quantity;
        medicine.update();
    }

    public void update() {
        String Query = "UPDATE PRESMED SET VisitID = " + this.visit.ID + ", MedicineID = " + this.medicine.ID + ", Quantity = " + this.quantity + " WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM PRESMED WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM PRESMED WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.visit = new Visit(result.getInt("VisitID"));
                this.medicine = new Medicine(result.getInt("MedicineID"));
                this.quantity = result.getInt("Quantity");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All() {
        List<Model> presMeds = new ArrayList<>();
        String Query = "SELECT * FROM PRESMED";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresMed presMed = new PresMed(result.getInt("ID"));
                presMeds.add(presMed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presMeds;
    }

    public static List<Model> ShowByMedicine(int medicineID){
        List<Model> presMeds = new ArrayList<>();
        String Query = "SELECT * FROM PRESMED WHERE MedicineID = " + medicineID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresMed presMed = new PresMed(result.getInt("ID"));
                presMeds.add(presMed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presMeds;
    }

    public static List<Model> ShowByDoctor(int doctorID){
        List<Model> presMeds = new ArrayList<>();
        String Query = "SELECT * FROM PRESMED WHERE VisitID IN (SELECT ID FROM VISIT WHERE DoctorID = " + doctorID + ")";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresMed presMed = new PresMed(result.getInt("ID"));
                presMeds.add(presMed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presMeds;
    }

    public static List<Model> ShowByStudent(int studentID){
        List<Model> presMeds = new ArrayList<>();
        String Query = "SELECT * FROM PRESMED WHERE VisitID IN (SELECT ID FROM VISIT WHERE StudentID = " + studentID + ")";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresMed presMed = new PresMed(result.getInt("ID"));
                presMeds.add(presMed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presMeds;
    }

    public static List<Model> ShowByVisit(int visitID){
        List<Model> presMeds = new ArrayList<>();
        String Query = "SELECT * FROM PRESMED WHERE VisitID = " + visitID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresMed presMed = new PresMed(result.getInt("ID"));
                presMeds.add(presMed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presMeds;
    }

    public void printSignature() {

    }

    public String toString() {
        String S = "ID : " + this.ID +
                "\nDate : " + this.visit.date +
            "\nStudent : " + this.visit.student.name + "(" + this.visit.student.ID + ")" +
            "\nMedicine : " + this.medicine.name +
            "\nQuantity : " + this.quantity + "\n\n";
        return S;
    }


}
