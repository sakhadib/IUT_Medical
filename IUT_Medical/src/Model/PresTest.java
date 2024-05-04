package Model;

import java.util.List;
import java.util.ArrayList;
public class PresTest implements Model {
    int ID;
    Visit visit;
    Test test;

    public PresTest(int visitID, int testID) {
        this.visit = new Visit(visitID);
        this.test = new Test(testID);
    }

    public PresTest(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO PRESTEST(VisitID, TestID) VALUES (" + this.visit.ID + ", " + this.test.ID + ")";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE PRESTEST SET VisitID = " + this.visit.ID + ", TestID = " + this.test.ID + " WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM PRESTEST WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM PRESTEST WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.visit = new Visit(result.getInt("VisitID"));
                this.test = new Test(result.getInt("TestID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Model> All() {
        List<Model> prestests = new ArrayList<>();
        String Query = "SELECT * FROM PRESTEST";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresTest prestest = new PresTest(result.getInt("ID"));
                prestests.add(prestest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prestests;
    }

    public void printSignature(){
        String s = "ID\tVisitID\tTestID\n";
        System.out.println(s);
    }

    public String toString() {
        return this.ID + "\t" + this.visit.ID + "\t" + this.test.ID;
    }


}