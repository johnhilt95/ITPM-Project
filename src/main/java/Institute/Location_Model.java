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
public class Location_Model {
    
     public void insertUpdateDeleteLocation_Model( char operation,Integer ID, String BuildingName, String RoomName, String RoomType, String Capacity )                                      
    {
        Connection conn = DbConnection.dbconnect();
        PreparedStatement ps;
      
       // i for insert
        
       if(operation=='i')
         
        {
             
            try {
                ps = conn.prepareStatement("insert into hniti.manage_location(Building_Name,Room_Name,Room_Type,Capacity) values (?,?,?,?);");           
              
                
                ps.setString(1,BuildingName);
                ps.setString(2,RoomName);
                ps.setString(3,RoomType);
                ps.setString(4,Capacity);
                
                
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "New Location Saved");
                }
                
            } 
             
            catch (SQLException ex) {
                Logger.getLogger(Location_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
       
       if(operation=='u')
        {
            try {
                ps = conn.prepareStatement("update hniti.manage_location set Building_Name=?,Room_Name=?,Room_Type=?,Capacity=? where ID=?");
               
                ps.setString(1,BuildingName);
                ps.setString(2,RoomName);
                ps.setString(3,RoomType);
                ps.setString(4,Capacity);
                ps.setInt(5,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Location Data Updated");
                }
                
            } catch (SQLException ex) {
              Logger.getLogger(Location_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
       if(operation=='d')
        {
            try {
                ps = conn.prepareStatement("delete FROM hniti.manage_location where ID = ?");
                ps.setInt(1,ID);
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "Location Data Deleted");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Location_Model.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
  
//    public void fillTag_ModelJtable(JTable table, String valueToSearch)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_location where concat(TagName,TagCode,RelatedTag) like ?");
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
//            
//        } 
//        catch (SQLException ex) {
//            Logger.getLogger(Tag_Model.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    


//      public void fillTag_ModelJtable(JTable jTable_location)
//    {
//        Connection con = DbConnection.dbconnect();
//        PreparedStatement ps;
//        
//        try {
//            ps = con.prepareStatement("SELECT * FROM hniti.manage_location");            
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel)jTable_location.getModel();
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
