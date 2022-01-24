package jdbcpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createTable {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement();
            String query="create table student(Id serial primary key,Name text,DOB date)";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Table creation error");
        }
    }
}
