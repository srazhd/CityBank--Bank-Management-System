package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class HomeModel {
    private Statement stmnt = null;
    
    public String todayDeposit() throws Exception{
        ResultSet rs= new HomeModel().getDepositInfoInDate();
        Integer total =0;
        while(rs.next()){
            total += rs.getInt("deposit");
        }
        
        return total.toString();
    }
    public String todayWithdraw() throws Exception{
        ResultSet rs= new HomeModel().getWithdrawInfoInDate();
        Integer total =0;
        while(rs.next()){
            total += rs.getInt("withdraw");
        }
        
        return total.toString();
    }
    
    
    public ResultSet getDepositInfoInDate() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from deposit where date = CURDATE()";
        return stmnt.executeQuery(sql);
    }
    public ResultSet getWithdrawInfoInDate() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from withdraw where date = CURDATE()";
        return stmnt.executeQuery(sql);
    }
    public ResultSet getDepositInfo() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from deposit";
        return stmnt.executeQuery(sql);
    }
    public ResultSet getWithdrawInfo() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from withdraw";
        return stmnt.executeQuery(sql);
    }
    
    public String getCustomerName(String s) throws Exception{
        String s2 = "";
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select ac_name from account where acc_id ='"+ s+"'";
        ResultSet rs= stmnt.executeQuery(sql);
        while(rs.next()){
            s2 = rs.getString(1);
        }
        return s2;
    }
}
