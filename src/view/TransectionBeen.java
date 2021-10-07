/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.util.Comparator;

/**
 *
 * @author sunam
 */

public class TransectionBeen implements Comparator<TransectionBeen>{
    private Date date;
    private int deposit;
    private int withdraw; 

    public TransectionBeen() {
    }

    public TransectionBeen(Date date, int deposit, int withdraw) {
        this.date = date;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    @Override
    public int compare(TransectionBeen o1, TransectionBeen o2) {
        return o1.date.compareTo(o2.date);
    }
    
}
