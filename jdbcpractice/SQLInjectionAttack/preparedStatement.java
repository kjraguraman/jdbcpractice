package jdbcpractice.SQLInjectionAttack;

import java.sql.*;
import java.util.Scanner;

public class preparedStatement {
    public static void main(String[] args) {
        try{
            String url="jdbc:postgresql://localhost:5432/jdbcpractice";
            String username="postgres";
            String password="postgres";
            Connection con= DriverManager.getConnection(url,username,password);
            Scanner scanner=new Scanner(System.in);
            String query="select count(*) from users where UName=? and Password=?";
            PreparedStatement stmt=con.prepareStatement(query);
            System.out.println("Enter your username");
            stmt.setString(1,scanner.next());
            System.out.println("Enter your password");
            stmt.setString(2,scanner.next());
            ResultSet result=stmt.executeQuery();
            int c=0;
            while(result.next())
                c=result.getInt(1);
            if(c==0)
                System.out.println("Login failed");
            else
                System.out.println("Login successfull");
        }catch(Exception e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
