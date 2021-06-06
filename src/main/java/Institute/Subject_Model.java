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
public class Subject_Model {
        public void insertUpdateDeleteSubject_Model( char operation,Integer ID, String OfferedYear, String OfferedSemester, String SubjectName, String SubjectCode, Integer NumberOfLectureHours, Integer NumberOfTutorialHours, Integer NumberOfLabHours, Integer NumberOfEvaluationHours )                                      
    {
        Connection con = DbConnection.dbconnect();
        PreparedStatement ps;
      
       // i for insert
        
       if(operation=='i')
        {
            try {
                ps = con.prepareStatement("insert into hniti.manage_subjects(Offered_Year,Offered_Semester,Subject_Name,Subject_Code,Number_of_Lecture_Hours,Number_of_Tutorial_Hours,Number_of_Lab_Hours,Number_of_Evaluation_Hours) values (?,?,?,?,?,?,?,?);");           
                ps.setString(1,OfferedYear);
                ps.setString(2,OfferedSemester);
                ps.setString(3,SubjectName);
                  ps.setString(4,SubjectCode);
                  ps.setInt(5,NumberOfLectureHours);
                  ps.setInt(6,NumberOfTutorialHours);
                  ps.setInt(7,NumberOfLabHours);
                   ps.setInt(8,NumberOfEvaluationHours);
                
                
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "New Subjects Details Saved");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Subject_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='u')
        {
            try {
                ps = con.prepareStatement("update hniti.manage_subjects set Offered_Year=?,Offered_Semester=?,Subject_Name=?,Subject_Code=?,Number_of_Lecture_Hours=?,Number_of_Tutorial_Hours=?,Number_of_Lab_Hours=?,Number_of_Evaluation_Hours=? where ID=?;");
               
                ps.setString(1,OfferedYear);
                ps.setString(2,OfferedSemester);
                ps.setString(3,SubjectName);
                ps.setString(4,SubjectCode);
                ps.setInt(5,NumberOfLectureHours);
                ps.setInt(6,NumberOfTutorialHours);
                ps.setInt(7,NumberOfLabHours);
                ps.setInt(8,NumberOfEvaluationHours);
                ps.setInt(9,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Subjects Details Updated");
                }
                
            } catch (SQLException ex) {
               Logger.getLogger(Subject_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='d')
        {
            try {
                ps = con.prepareStatement("delete FROM hniti.manage_subjects where ID = ?");
                ps.setInt(1,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Subjects Details Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Subject_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
  
//    public void fillTag_ModelJtable(JTable table, String valueToSearch)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_subjects where concat(TagName,TagCode,RelatedTag) like ?");
//                     
//            ps.setString(1,"%"+ valueToSearch+"%");
//            
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)table.getModel();
//            
//            Object[] row;
//            
//            while (rs.next()) {
//                row = new Object[4];
//                row[0] = rs.getInt(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                row[3] = rs.getString(4);
//                
//                model.addRow(row);
//                
//            }
            
//        } 
//        catch (SQLException ex) {
//            Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    


//      public void fillSubject_ModelJtable(JTable jTblManageSubject)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_subjects");            
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)jTblManageSubject.getModel();
//            
//            Object[] row;
//            
//            while (rs.next()) {
//                row = new Object[9];
//                row[0] = rs.getInt(1);  //getting course id in first row
//                row[1] = rs.getString(2);  //getting course name in second row
//                row[2] = rs.getString(3);  //getting duration in third row
//                row[3] = rs.getString(4);
//                row[4] = rs.getString(5);
//                row[5] = rs.getString(6);
//                row[6] = rs.getString(7);
//                row[7] = rs.getString(8);
//                row[8] = rs.getString(9);
//                
//                model.addRow(row);
//                
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
 
}
