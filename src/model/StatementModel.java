
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import view.TransectionBeen;

//Genarate Account Statement
public class StatementModel {
        private Statement stmnt = null;
    
        public ArrayList<TransectionBeen> getAllTransection(String acno) throws Exception{
            ArrayList<TransectionBeen> tb = new ArrayList<>();
            
            ResultSet rs = new StatementModel().getDepositInfoByAcNo(acno);
            while (rs.next()) {                
                tb.add(new TransectionBeen(rs.getDate("date"), rs.getInt("deposit"), 0));
            }
            
            ResultSet rs2 = new StatementModel().getWithdrawInfoByAcNo(acno);
            while (rs2.next()) {                
                tb.add(new TransectionBeen(rs2.getDate("date"), 0, rs2.getInt("withdraw")));
            }
            
            Collections.sort(tb, new TransectionBeen());
            
             return tb;
        }
        
 
        public ResultSet getDepositInfoByAcNo(String acno) throws Exception{
            DatabaseAccess.connectToMySql();
            stmnt = DatabaseAccess.connection.createStatement();
            String sql = "select * from deposit where acc_id ='"+acno+"'";
            return stmnt.executeQuery(sql);
       }
        
        public ResultSet getWithdrawInfoByAcNo(String acno) throws Exception{
            DatabaseAccess.connectToMySql();
            stmnt = DatabaseAccess.connection.createStatement();
            String sql = "select * from withdraw where acc_id ='"+acno+"'";
            return stmnt.executeQuery(sql);
       }
}
