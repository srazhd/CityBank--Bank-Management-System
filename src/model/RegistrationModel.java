package model;

import controller.*;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author sunam
 */
public class RegistrationModel {
    private Statement stmnt = null;
    public boolean insertintoRegistration(RegistrationAction reg) throws Exception{
        DatabaseAccess.connectToMySql();
        String sql = "insert into registration values(?,?,?,?)";
        PreparedStatement s = DatabaseAccess.connection.prepareStatement(sql);
        s.setString(1, reg.getName());
        s.setString(2, reg.getEmail());
        s.setString(3, reg.getUsername());
        s.setString(4, reg.getPassword());
        int i = s.executeUpdate();
        
        //stmnt = DatabaseAccess.connection.createStatement();
        /*String sql2 = "insert into login values('"
                + reg.getEmail()+ "','"
                +reg.getPassword()+"')";*/
        
        String sql2= "insert into login values(?,?)";
        s = DatabaseAccess.connection.prepareStatement(sql2);
        s.setString(1, reg.getUsername());
        s.setString(2, reg.getPassword());
        
        i += s.executeUpdate();
        if (i == 2){
            return true;
        }
        else{
            return false;
        }
    }
    
}
