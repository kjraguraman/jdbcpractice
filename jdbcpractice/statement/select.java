package jdbcpractice.statement;

import java.sql.*;

public class select {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbcpractice";
            String username = "postgres";
            String password = "postgres";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query="select * from student";
            ResultSet result =stmt.executeQuery(query);
            ResultSetMetaData rsmd=result.getMetaData();
            System.out.println("Total column : "+rsmd.getColumnCount());
            System.out.println("1st column name : "+rsmd.getColumnName(1));
            System.out.println("1st column type : "+rsmd.getColumnTypeName(1));
            //System.out.println("1st column type name : "+rsmd.getColumnTypeName(2));
//            result.first();
//            result.last();
//            result.beforeFirst();
//            result.absolute(3);
//            System.out.println(result.getRow());
            result.afterLast();
            while (result.previous()){
                System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getDate(3));
            }
            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Retrival failed");
            e.printStackTrace();
        }
    }
}
