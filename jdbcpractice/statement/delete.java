package jdbcpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement();
            String query="delete from student where id=3";
            int rows=stmt.executeUpdate(query);
            System.out.println(rows+" rows deleted");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Deletion failed");
        }
    }
}
