package jdbcpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement();
            String query="insert into student(Name,DOB) values('Ragu','2001-02-20'),('Ram','2000-10-10'),('Venkat','2000-12-20')";
            int rows=stmt.executeUpdate(query);
            System.out.println(rows+" rows successfully inserted");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Insertion failed");
        }
    }
}
