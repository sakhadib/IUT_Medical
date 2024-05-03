package Model;

public class Student implements Model{
    public String ID;
    public String name;
    public String email;
    public String Dept;

    public Student(String ID, String name, String email, String Dept) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.Dept = Dept;
    }

    public Student(String ID) {
        this.ID = ID;
        select();
    }

    public void save() {
        String Query = "INSERT INTO STUDENT VALUES ('" + this.ID + "', '" + this.name + "', '" + this.Dept + "', '" + this.email + "')";
        try {
            DB.Conn.Execute(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String Query = "UPDATE STUDENT SET NAME = '" + this.name + "', DEPT = '" + this.Dept + "', EMAIL = '" + this.email + "' WHERE ID = '" + this.ID + "'";
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
                this.Dept = result.getString("DEPT");
                this.email = result.getString("EMAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
