package DB;

import java.sql.*;

public class Conn {
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // URL of the database
    public static String username = "dbms_lab_proj";
    public static String password = "dbms_lab_proj";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet Exedute(String query) throws SQLException {
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(query);
//        stmt.close();
//        conn.close();
        return result;
    }

    public static int Execute(String query) throws SQLException {
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(query);
        stmt.close();
        conn.close();
        return rowsAffected;
    }

}
