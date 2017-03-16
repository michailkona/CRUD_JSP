/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDao;

import bean.crud_users;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author konstantina
 */
public class UserDao {

    private static final String URL = "jdbc:mysql://localhost:3306/crud_db?zeroDateTimeBehavior=convertToNull&useSSL=false";
    static final String Username = "root";
    static final String Password = "ntina";

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, Username, Password);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    public static int save(crud_users u) {

        int status = 0;
        PreparedStatement stm = null;
        String sqlinsert;

        try {
            Connection con = getConnection();
            sqlinsert = "INSERT INTO crud_db.crud_users (crud_users_username, crud_users_firstname, crud_users_lastname, crud_users_email) \n"
                    + "	VALUES (?, ?, ?, ?)";

            stm = (PreparedStatement) con.prepareStatement(sqlinsert);

            stm.setString(1, u.getCrud_users_username());
            stm.setString(2, u.getCrud_users_firstname());
            stm.setString(3, u.getCrud_users_lastname());
            stm.setString(4, u.getCrud_users_email());
            status = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static int update(crud_users u) {

        int status = 0;
        PreparedStatement stm = null;
        String sqlupdate;

        try {
            Connection con = getConnection();
            sqlupdate = "UPDATE crud_db.crud_users SET "
                    + "crud_users_username=?,"
                    + "crud_users_firstname=?,"
                    + "crud_users_lastname=?,"
                    + "crud_users_email=?"
                    + " WHERE crud_users_id=?";

            stm = (PreparedStatement) con.prepareStatement(sqlupdate);

            stm.setString(1, u.getCrud_users_username());
            stm.setString(2, u.getCrud_users_firstname());
            stm.setString(3, u.getCrud_users_lastname());
            stm.setString(4, u.getCrud_users_email());
            stm.setInt(5, u.getCrud_users_id());
            status = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static int delete(crud_users u) {

        int status = 0;
        PreparedStatement stm = null;
        String sqldelete;

        try {
            Connection con = getConnection();
            sqldelete = "Delete from crud_db.crud_users "
                    + "WHERE crud_users_id=? ";

            stm = (PreparedStatement) con.prepareStatement(sqldelete);
            stm.setInt(1, u.getCrud_users_id());
            status = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static List<crud_users> getAllRecords() {

        List<crud_users> crud_users_list = new ArrayList<crud_users>();

        PreparedStatement stm = null;
        String sqlselect;
        ResultSet rs = null;

        try {
            Connection con = getConnection();
            sqlselect = "Select * from crud_db.crud_users";

            stm = (PreparedStatement) con.prepareStatement(sqlselect);
            rs=stm.executeQuery();

            while (rs.next()) {
                crud_users crud_users_result = new crud_users();
                crud_users_result.setCrud_users_id(rs.getInt("crud_users_id"));
                crud_users_result.setCrud_users_username(rs.getString("crud_users_username"));
                crud_users_result.setCrud_users_firstname(rs.getString("crud_users_firstname"));
                crud_users_result.setCrud_users_lastname(rs.getString("crud_users_lastname"));
                crud_users_result.setCrud_users_email(rs.getString("crud_users_email"));
                
                crud_users_list.add(crud_users_result);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return crud_users_list;

    }
    
    public static crud_users getUserById(int crud_users_id) {
        
        crud_users crud_users_result = null;
        PreparedStatement stm = null;
        String sqlselect;
        ResultSet rs = null;

        try {
            Connection con = getConnection();
            sqlselect = "Select * from crud_db.crud_users"
                    + " WHERE crud_users_id=?";

            stm = (PreparedStatement) con.prepareStatement(sqlselect);
            stm.setInt(1,crud_users_id );
            rs=stm.executeQuery();

            while (rs.next()) {
                crud_users_result=new crud_users();
                crud_users_result.setCrud_users_id(rs.getInt("crud_users_id"));
                crud_users_result.setCrud_users_username(rs.getString("crud_users_username"));
                crud_users_result.setCrud_users_firstname(rs.getString("crud_users_firstname"));
                crud_users_result.setCrud_users_lastname(rs.getString("crud_users_lastname"));
                crud_users_result.setCrud_users_email(rs.getString("crud_users_email"));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return crud_users_result;

    }
    
    
}
