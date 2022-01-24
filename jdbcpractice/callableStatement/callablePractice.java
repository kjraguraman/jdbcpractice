package jdbcpractice.callableStatement;

import java.sql.*;
import java.util.Scanner;

public class callablePractice {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            String query="call getName(?,?)";
            CallableStatement stmt=con.prepareCall(query);
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter your Id");
            stmt.setInt(1,scanner.nextInt());
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            System.out.println("Student Name : "+stmt.getString(2));
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Insertion failed");
            e.printStackTrace();
        }
    }
}
