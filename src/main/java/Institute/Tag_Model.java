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

 
  public class Tag_Model {
      
        
     public void insertUpdateDeleteTag_Model( char operation, Integer ID, String TagName, String TagCode, String RelatedTag )                                      
    {
    Connection con = DbConnection.dbconnect();
        PreparedStatement ps;
      
       // i for insert
        
       if(operation=='i')
        {
            try {
                ps = con.prepareStatement("insert into hniti.manage_tag(Tag_Name,Tag_Code,Related_Tag) values (?,?,?);");           
                ps.setString(1,TagName);
                ps.setString(2,TagCode);
                ps.setString(3,RelatedTag);
                
                
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "New Tag Saved");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='u')
        {
            try {
             
                ps = con.prepareStatement("update hniti.manage_tag set  Tag_Name=?,Tag_Code=?,Related_Tag=? where ID=?;" );
               
                
                ps.setString(1,TagName);
                ps.setString(2,TagCode);
                ps.setString(3,RelatedTag);
                ps.setInt(4,ID);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Manage Tag Data Updated");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='d')
        {
            try {
                ps = con.prepareStatement("delete from hniti.manage_tag where ID = ?");
                ps.setInt(1,ID);    
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Tag Data Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
  
    
  
//    public void fillTagModelJtable(JTable jTable_Tags, String valueToSearch)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_tag where concat(Tag_Name,Tag_Code,Related_Tag) like ?");
//                     
//            ps.setString(1,"%"+ valueToSearch+"%");
//            
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)jTable_Tags.getModel();
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
//                
//                model.addRow(row);
//                
//            }
//            
//        } 
//        catch (SQLException ex) {
//            Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    


//      public void fillTag_ModelJtable(JTable jTable_Tags)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_tag");            
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)jTable_Tags.getModel();
//            
//            Object[] row;
//            
//            while (rs.next()) {
//                row = new Object[4];
//                row[0] = rs.getInt(1);  //getting course id in first row
//                row[1] = rs.getString(2);  //getting course name in second row
//                row[2] = rs.getString(3);  //getting duration in third row
//                row[3] = rs.getString(4);
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

    
    

