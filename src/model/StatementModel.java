
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import view.TransectionBeen;


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
            
//            for(int i=0; i< tb.size();i++){
//                System.out.print(tb.get(i).getDate().toString()+" "+tb.get(i).getDeposit()+" "+tb.get(i).getWithdraw());
//                System.out.println("");
//            }

                
             return tb;
        }
        
//        public static void main(String[] args) throws Exception {
//         new StatementModel().getAllTransection("a0001");
//        }
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
