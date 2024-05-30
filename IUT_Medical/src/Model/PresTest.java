package Model;

import java.util.List;
import java.util.ArrayList;
public class PresTest implements Model {
    public int ID;
    public Visit visit;
    public Test test;

    public PresTest(int visitID, int testID) {
        this.visit = new Visit(visitID);
        this.test = new Test(testID);
    }

    public PresTest(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO PRESTEST VALUES (" + 1 + ", " + this.visit.ID + ", " + this.test.ID + ")";
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
        DB.Conn.close();
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
        DB.Conn.close();
        return prestests;
    }

    public static List<Model> ShowByTest(int TestID){
        List<Model> presTests = new ArrayList<>();
        String Query = "SELECT * FROM PRESTEST WHERE TestID = " + TestID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresTest presTest = new PresTest(result.getInt("ID"));
                presTests.add(presTest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presTests;
    }

    public static List<Model> ShowByVisit(int VisitID){
        List<Model> presTests = new ArrayList<>();
        String Query = "SELECT * FROM PRESTEST WHERE VisitID = " + VisitID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresTest presTest = new PresTest(result.getInt("ID"));
                presTests.add(presTest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presTests;
    }

    public static List<Model> ShowByDoctor(int DoctorID){
        List<Model> presTests = new ArrayList<>();
        String Query = "SELECT * FROM PRESTEST WHERE VisitID IN (SELECT ID FROM VISIT WHERE DoctorID = " + DoctorID + ")";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresTest presTest = new PresTest(result.getInt("ID"));
                presTests.add(presTest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presTests;
    }

    public static List<Model> ShowByStudent(int StudentID){
        List<Model> presTests = new ArrayList<>();
        String Query = "SELECT * FROM PRESTEST WHERE VisitID IN (SELECT ID FROM VISIT WHERE StudentID = " + StudentID + ")";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                PresTest presTest = new PresTest(result.getInt("ID"));
                presTests.add(presTest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return presTests;
    }

    public void printSignature(){
        String s = "ID\tVisitID\tStudent ID\tTestID\n";
        System.out.println(s);
    }

    public String toString() {
        return this.ID + "\t" + this.visit.ID + this.visit.student.ID+ "\t" + this.test.ID;
    }


}