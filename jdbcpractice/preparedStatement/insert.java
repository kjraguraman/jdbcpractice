package jdbcpractice.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            String query="insert into student(Name,DOB) values(?,?)";
            PreparedStatement stmt=con.prepareStatement(query);
            System.out.println("Enter the Name and DOB(yyyy-MM-dd) to insert record");
            Scanner scanner=new Scanner(System.in);
            String name=scanner.next();
            String sdate= scanner.next();
            java.sql.Date sqlDate =java.sql.Date.valueOf(sdate);
            stmt.setString(1,name);
            stmt.setDate(2,sqlDate);
            int row=stmt.executeUpdate();
            System.out.println(row+" rows inserted");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Retrival failed");
            e.printStackTrace();
        }
    }
}
