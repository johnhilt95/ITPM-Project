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
import static javax.management.Query.value;
import java.sql.ResultSet;

/**
 *
 * @author johnh
 */
public class Lecturers_Model {
    Connection con = DbConnection.dbconnect();
        PreparedStatement ps;
     public void insertUpdateDeleteLecturers_Model( char operation, Integer ID, String LecturerName, String EmployeeID, String Faculty, String Department, String Center, String Building, String Level, String Rank ) 
                                          
    {
        
      
       // i for insert
        
       if(operation=='i')
        {
            try {
                ps = con.prepareStatement("insert into hniti.manage_lecturers(Lecturer_Name,Employee_ID,Faculty,Department,Center,Building,Levels,Ranks) values (?,?,?,?,?,?,?,?)");           
                ps.setString(1,LecturerName);
                ps.setString(2,EmployeeID);
                ps.setString(3,Faculty);
                ps.setString(4, Department);
                ps.setString(5, Center);
                ps.setString(6, Building);
                ps.setString(7, Level);
                ps.setString(8, Rank);
                
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "New Lecturers_Data Saved");
                }
                
            } catch (SQLException ex) {
               
                
//     Logger.getLogger(Lecturers_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       if(operation=='u')
        {
            try {
                ps = con.prepareStatement("update hniti.manage_lecturers set Lecturer_Name=?,Employee_ID=?,Faculty=?,Department=?,Center=?,Building=?,Levels=?,Ranks=? where ID=?;");
                ps.setString(1,LecturerName);
                ps.setString(2,EmployeeID);
                ps.setString(3,Faculty);
                ps.setString(4,Department);
                ps.setString(5,Center);
                ps.setString(6,Building);
                ps.setString(7,Level);
                ps.setString(8,Rank);
                ps.setInt(9,ID);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Lecturers Data Updated");
                }
                
            } catch (SQLException ex) {
              //  Logger.getLogger(Lecturers_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(operation=='d')
        {
            try {
                ps = con.prepareStatement("delete from hniti.manage_lecturers where ID = ?");
                ps.setInt(1,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Lecturers Data Deleted");
                }
                
            } catch (SQLException ex) {
            //    Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
