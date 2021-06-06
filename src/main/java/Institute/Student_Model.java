/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnh
 */
public class Student_Model {
     Connection conn = DbConnection.dbconnect();
        PreparedStatement ps;
      
       // i for insert
       public void insertUpdateDeleteStudent_Model( char operation,Integer ID, String Academic_Year_Semester, String Programme, String Group_Number,String Sub_Group_Number,String Group_ID,String Sub_Group_ID )                                      
    {
        Connection conn = DbConnection.dbconnect();
        PreparedStatement ps;  
       if(operation=='i')
        {
            try {
                ps = conn.prepareStatement("insert into hniti.manage_student_group(Academic_Year_Semester,Programme,Group_Number,Sub_Group_Number,Group_ID,Sub_Group_ID) values (?,?,?,?,?,?);");           
                ps.setString(1,Academic_Year_Semester);
                ps.setString(2,Programme);
                ps.setString(3,Group_Number);
                ps.setString(4,Sub_Group_Number);
                ps.setString(5,Group_ID);
                ps.setString(6,Sub_Group_ID);
                
                
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "New Student Details Saved");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Student_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='u')
        {
            try {
                ps = conn.prepareStatement("update hniti.manage_student_group set Academic_Year_Semester=?,Programme=?,Group_Number=?, Sub_Group_Number=?, Group_ID=?, Sub_Group_ID=? where ID=?;");
                
                ps.setString(1,Academic_Year_Semester);
                ps.setString(2,Programme);
                ps.setString(3,Group_Number);
                ps.setString(4,Sub_Group_Number);
                ps.setString(5,Group_ID);
                ps.setString(6,Sub_Group_ID);
                ps.setInt(7,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "student Details  Updated");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='d')
        {
            try {
                ps = conn.prepareStatement("delete FROM hniti.manage_student_group where ID = ?");
                ps.setInt(1,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Student Details Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
//        public void fillStudent_ModelJtable(JTable jTblManageStudent)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_student_group");            
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)jTblManageStudent.getModel();
//            
//            Object[] row;
//            
//            while (rs.next()) {
//                row = new Object[7];
//                row[0] = rs.getInt(1);  //getting course id in first row
//                row[1] = rs.getString(2);  //getting course name in second row
//                row[2] = rs.getString(3);  //getting duration in third row
//                row[3] = rs.getString(4);
//                row[3] = rs.getString(5);
//                row[3] = rs.getString(6);
//                row[3] = rs.getString(7);
//                
//                model.addRow(row);
//                
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Student_Model.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
