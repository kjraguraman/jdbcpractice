package jdbcpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
    public static void main(String[] args) {
        try{
            String url="jdbc:postgresql://localhost:5432/jdbcpractice";
            String username="postgres";
            String password="postgres";
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Successfully connected");
            con.close();
        }catch(Exception e){
            System.out.println("Connection failed");
        }
    }
}