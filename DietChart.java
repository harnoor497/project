package pateintreport;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DietChart extends javax.swing.JFrame 
{

    public DietChart() 
    {
      //  initComponents();
        setVisible(true);
       // setBounds(50,150,1350,550);
     // setEditable(true);
       setResizable(false);
    
        DefaultTableModel model = new DefaultTableModel(); 
Container cnt = this.getContentPane();
JTable jtbl = new JTable(model);
   // public fetch_DATA_from_DB_into_JTBL()
    //{
    cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
    model.addColumn("patid"); model.addColumn("patname"); model.addColumn("shift1");
    model.addColumn("shift2");model.addColumn("shift3");
    try
    { 
//        Class.forName("com.mysql.jdbc.Driver"); 
//        Connection con =DriverManager.getConnection("jdbc:mysql://localhost/java_db", "root", ""); 
         Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");
        
PreparedStatement pstm = con.prepareStatement("SELECT * FROM nrs_presc");
ResultSet Rs = pstm.executeQuery(); while(Rs.next()){
model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
}
} catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error in code is "+e.getMessage());}
JScrollPane pg = new JScrollPane(jtbl); cnt.add(pg);
this.pack();

    }
    public static void main(String arg[])
    {
        new DietChart();
    }

    private void setEditable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}