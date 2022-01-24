package jdbcpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class alter {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement();
            String query="alter table student alter column Name set not null";
            stmt.executeUpdate(query);
            System.out.println("Query executed successfully");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Insertion failed");
            e.printStackTrace();
        }
    }
}
