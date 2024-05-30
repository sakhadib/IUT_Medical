package Model;

import java.util.List;
import java.util.ArrayList;

public class Medicine implements Model {
    public int ID;
    public String name;
    public String generic;
    public String company;
    public int quantity;

    public Medicine(String name, String generic, String company, int quantity) {
        this.name = name;
        this.generic = generic;
        this.company = company;
        this.quantity = quantity;
    }

    public Medicine(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO MEDICINE(ID, Name, Generic, Company, Quantity) VALUES ('" + 1 + "', '" + this.name + "', '" + this.generic + "', '" + this.company + "', " + this.quantity + ")";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE MEDICINE SET NAME = '" + this.name + "', GENERIC = '" + this.generic + "', COMPANY = '" + this.company + "', QUANTITY = " + this.quantity + " WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM MEDICINE WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM MEDICINE WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.name = result.getString("NAME");
                this.generic = result.getString("GENERIC");
                this.company = result.getString("COMPANY");
                this.quantity = result.getInt("QUANTITY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All(){
        List<Model> Medicines = new ArrayList<Model>();
        String Query = "SELECT * FROM MEDICINE";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Medicine medicine = new Medicine(result.getInt("ID"));
                Medicines.add(medicine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return Medicines;
    }

    public static void stock(int medID, int quantity){
        Medicine m = new Medicine(medID);
        m.quantity += quantity;
        m.update();
    }

    public void printSignature(){

    }

    public String toString(){
        String S = "ID : " + this.ID + "\nName : " + this.name + "\nGeneric : " + this.generic + "\nCompany : " + this.company + "\nQuantity : " + this.quantity + "\n\n";
        return S;
    }
}
