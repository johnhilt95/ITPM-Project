/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author johnh
 */
public class Add_working_Days_And_Hours_Model {
     Connection con = DbConnection.dbconnect();
        PreparedStatement ps;
     public void insertUpdateDeleteAdd_working_Days_And_Hours_Model( char operation,Integer ID, Integer NumberOfWorkingDays, String WorkingDays, String WorkingTimePerDay ) 
                                          
    {
       
      
       // i for insert
        
       if(operation=='i')
        {
            try {
                ps = con.prepareStatement("insert into hniti.add_working_days_and_hours(Number_of_Working_Days,Working_Days,Working_Time_Per_Day) values (?,?,?)");           
                ps.setInt(1,NumberOfWorkingDays);
                ps.setString(2,WorkingDays);
                ps.setString(3,WorkingTimePerDay);
                
                
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "New Add_working_Days_And_Hours_Data Saved");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Add_working_Days_And_Hours_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       if(operation=='u')
        {
            try {
             
                ps = con.prepareStatement("update hniti.add_working_days_and_hours set  Number_of_Working_Days=?,Working_Days=?,Working_Time_Per_Day=? where ID=?" );
               
                
                ps.setInt(1,NumberOfWorkingDays);
                ps.setString(2,WorkingDays);
                ps.setString(3,WorkingTimePerDay);
                ps.setInt(4,ID);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Add_working_Days_And_Hours Data Updated");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Add_working_Days_And_Hours_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       if(operation=='d')
        {
            try {
                ps = con.prepareStatement("delete from hniti.add_working_days_and_hours where ID = ?");
                ps.setInt(1,ID);    
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Tag Data Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Add_working_Days_And_Hours_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }
}
