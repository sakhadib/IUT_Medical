package Model;
import java.util.List;
import java.util.ArrayList;

public class Student implements Model{
    public String ID;
    public String name;
    public String email;
    public String Dept;

    public Student(String name, String email, String Dept) {
        this.name = name;
        this.email = email;
        this.Dept = Dept;
    }

    public Student(String ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO STUDENT VALUES ('" + 1 + "', '" + this.name + "', '" + this.Dept + "', '" + this.email + "')";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE STUDENT SET NAME = '" + this.name + "', Department = '" + this.Dept + "', EMAIL = '" + this.email + "' WHERE ID = '" + this.ID + "'";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String Query = "DELETE FROM STUDENT WHERE ID = '" + this.ID + "'";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        String ID = this.ID;
        String Query = "SELECT * FROM STUDENT WHERE ID = '" + ID + "'";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            if (result.next()) {
                this.ID = result.getString("ID");
                this.name = result.getString("NAME");
                this.Dept = result.getString("Department");
                this.email = result.getString("EMAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
    }

    public static List<Model> All() {
        List<Model> students = new ArrayList<Model>();
        String Query = "SELECT * FROM STUDENT";
        try {
            java.sql.ResultSet result = DB.Conn.Exedute(Query);
            while (result.next()) {
                Student student = new Student(result.getString("ID"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DB.Conn.close();
        return students;
    }

    public void printSignature(){
        String S = "ID\t\t\tName\t\t\t\t\tDept\tEmail\n";
        System.out.println(S);
    }

    public void export(){
        String Query = "SELECT generate_student_report ('" + this.ID + "') FROM DUAL";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return this.ID + "\t" + this.name + "\t\t\t" + this.Dept + "\t\t" + this.email;
    }
}
