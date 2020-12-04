/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 04-Dec-20
 *  Time: 11:37 AM
 */

import java.sql.*;

public class SelectQueryDemo {
    public static void main(String[] args) {
        try {
            Connection con = getDbConnection();
            if(con != null){
                //statement
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM users WHERE name = 'Amit Mishra';";
                //execute sql
                ResultSet rs = stmt.executeQuery(sql);
                //if rs having some data, by using boolean next() of ResultSet
                while (rs.next()){
                    int rollno = rs.getInt("rollno");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println(rollno + "\t" + name + "\t" + email);
                }
                rs.close();
                stmt.close();
                con.close();
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }


    }
    public static Connection getDbConnection() throws SQLException {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "";
        con = DriverManager.getConnection(url, user, pass);
        return con;
    }
}
