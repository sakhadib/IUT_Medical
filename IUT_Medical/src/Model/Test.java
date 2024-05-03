package Model;

import java.util.List;
import java.util.ArrayList;

public class Test implements Model{
    public int ID;
    public String name;
    public int price;
    public Boolean Availablity;

    public Test(String name, int price, Boolean Availablity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.Availablity = Availablity;
    }

    public Test(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO TEST(Name, Price, Availability) VALUES ('" + this.name + "', " + this.price + ", " + this.Availablity + ")";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE TEST SET NAME = '" + this.name + "', PRICE = " + this.price + ", AVAILABLITY = " + this.Availablity + " WHERE ID = " + this.ID;
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
                this.ID = result.getInt("ID");
                this.name = result.getString("NAME");
                this.price = result.getInt("PRICE");
                this.Availablity = result.getBoolean("AVAILABLITY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return tests;
    }
}
