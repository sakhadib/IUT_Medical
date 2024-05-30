package Model;

import java.util.List;
import java.util.ArrayList;

public class Test implements Model{
    public int ID;
    public String name;
    public int price;
    public int Availablity;

    public Test(String name, int price, Boolean Availablity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        if(Availablity){
            this.Availablity = 1;
        }
        else{
            this.Availablity = 0;
        }
    }

    public Test(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO TEST(ID, Name, Price, Availability) VALUES (" + 1 + ", '" + this.name + "', " + this.price + ", " + this.Availablity + ")";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE TEST SET NAME = '" + this.name + "', PRICE = " + this.price + ", AVAILABILITY = " + this.Availablity + " WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM TEST WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM TEST WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt(1);
                this.name = result.getString(2);
                this.price = result.getInt(3);
                this.Availablity = result.getInt(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All() {
        List<Model> tests = new ArrayList<Model>();
        String Query = "SELECT * FROM TEST";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Test test = new Test(result.getInt("ID"));
                tests.add(test);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return tests;
    }

    public void printSignature(){

    }

    public String toString(){
        String Av;
        if(this.Availablity == 1){
            Av = "Available";
        }
        else{
            Av = "Not Available";
        }

        String S = "ID : " + this.ID + "\nName : " + this.name + "\nPrice : " + this.price + "\nAvailablity : " + Av + "\n\n";
        return S;
    }
}
