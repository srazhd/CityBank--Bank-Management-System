package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginModel {
       private Statement stmnt = null;
    
    public  boolean getLoginInfo(String username, String password) throws Exception{
        DatabaseAccess.connectToMySql();
        String s = "select * from login where username = '"+username+"' and password='" +password+"'";
        stmnt = DatabaseAccess.connection.createStatement();
        ResultSet result = stmnt.executeQuery(s);
        while(result.next()){
            return true;
        }
        return false;
    } 
}
