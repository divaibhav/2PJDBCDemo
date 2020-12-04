/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 04-Dec-20
 *  Time: 11:18 AM
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            //step 1
            //loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2
            //create connection
            //url, user, pass
            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user,pass);
            //step 3
            //prepare statement, build sql query
            Statement stmt = con.createStatement();
            //sql query to insert some values in database
            String sql = "INSERT INTO `users` (`rollno`, `name`, `email`) VALUES ('2', 'Akash Mishra', 'akash.mishra@gmail.com');";
            //step 4
            //execute the sql using statement
            int rows = stmt.executeUpdate(sql);
            //step 5
            //processing the result
            System.out.println("no of rows affected = " + rows);
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
