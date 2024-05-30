package Model;

//import oracle.sql.TIMESTAMP;

import java.util.List;
import java.util.ArrayList;

public class Visit implements Model{
    public int ID;
    public Student student;
    public Doctor doctor;
    public String date;


    public Visit(String studentID, String doctorID) {
        this.student = new Student(studentID);
        this.doctor = new Doctor(doctorID);
    }

    public Visit(int ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO VISIT (ID, StudentID, DoctorID, VisitTime) VALUES ("
                + 1 + ", '"
                + this.student.ID + "', '"
                + this.doctor.ID + "', SYSDATE)";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE VISIT SET StudentID = '" + this.student.ID + "', DoctorID = '" + this.doctor.ID + "' WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM VISIT WHERE ID = " + this.ID;
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        int ID = this.ID;
        String Query = "SELECT * FROM VISIT WHERE ID = " + ID;
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.student = new Student(result.getString("StudentID"));
                this.doctor = new Doctor(result.getString("DoctorID"));
                this.date = result.getString("VisitTime");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All() {
        List<Model> visits = new ArrayList<>();
        String Query = "SELECT * FROM VISIT";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Visit visit = new Visit(result.getInt("ID"));
                visits.add(visit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return visits;
    }

    public static List<Model> ShowByDoctor(String doctorID) {
        List<Model> visits = new ArrayList<>();
        String Query = "SELECT * FROM VISIT WHERE DoctorID = '" + doctorID + "'";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Visit visit = new Visit(result.getInt("ID"));
                visits.add(visit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return visits;
    }

    public static List<Model> ShowByStudent(String studentID) {
        List<Model> visits = new ArrayList<>();
        String Query = "SELECT * FROM VISIT WHERE StudentID = '" + studentID + "'";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Visit visit = new Visit(result.getInt("ID"));
                visits.add(visit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return visits;
    }

    public void printSignature(){

    }

    public String toString(){
        return "Visit ID: " + this.ID + "\n"
                + "Student ID: " + this.student.name + "(" + this.student.ID + ")\n"
                + "Doctor ID: " + this.doctor.name + "(" + this.doctor.ID + ")\n"
                + "Date: " + this.date + "\n";
    }
}
