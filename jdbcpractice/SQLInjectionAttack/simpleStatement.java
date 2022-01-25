package jdbcpractice.SQLInjectionAttack;

import java.sql.*;
import java.util.Scanner;

public class simpleStatement {
    public static void main(String[] args) {
        try{
            String url="jdbc:postgresql://localhost:5432/jdbcpractice";
            String username="postgres";
            String password="postgres";
            Connection con= DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter username");
            String uName=scanner.next();
            System.out.println("Enter your password");
            String pass=scanner.next();
            String query="Select count(*) from users where UName='"+uName+"'and Password='"+pass+"'";
            ResultSet result=stmt.executeQuery(query);
            int c=0;
            while(result.next())
                c=result.getInt(1);
            if(c==0)
                System.out.println("Permission denied.Pls check your username and password");
            else
                System.out.println("Login successful");
        }catch(Exception e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
