package DB;

import java.sql.*;

public class Conn {
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // URL of the database
    public static String username = "dbms_lab_proj";
    public static String password = "dbms_lab_proj";
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet result;


    public static void connect() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public static void getSTMT() throws SQLException {
        stmt = conn.createStatement();
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet Exedute(String query) throws SQLException {
        connect();
        getSTMT();
        result = stmt.executeQuery(query);
        return result;
    }

    public static int Execute(String query) throws SQLException {
        connect();
        Statement stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(query);
        stmt.close();
        conn.close();
        return rowsAffected;
    }

    public static void close(){
        try {
            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
