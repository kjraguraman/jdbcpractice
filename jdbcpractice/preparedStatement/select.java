package jdbcpractice.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class select {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            String query="Select * from student where id=?";
            PreparedStatement stmt=con.prepareStatement(query);
            System.out.println("Enter ID to get the student details");
            Scanner scanner=new Scanner(System.in);
            //int id=scanner.nextInt();
            //stmt.setInt(1,id);
            stmt.setInt(1,scanner.nextInt());
            ResultSet result=stmt.executeQuery();
            while (result.next()) System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getDate(3));
            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Retrival failed");
        }
    }
}
