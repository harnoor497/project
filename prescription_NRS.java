package pateintreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class prescription_NRS extends javax.swing.JFrame 
{
    public prescription_NRS() 
    {
        initComponents();
    }
public void addData()
    {
        Connection con;
        PreparedStatement pst;
        int rows=prsec_nrs.getRowCount(); 
            
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
                       con=DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");

            String queryco = "insert into nrs_presc values (?,?,?,?,?)";//values (?,?,?,?,?)";
            pst = con.prepareStatement(queryco);
            for(int row = 0; row<rows; row++)
            {
                String patname = (String)prsec_nrs.getValueAt(row, 0);
                String patid = (String)prsec_nrs.getValueAt(row, 1);
                String medicinetime = (String)prsec_nrs.getValueAt(row, 2);
                String quantity = (String)prsec_nrs.getValueAt(row, 3); 
                String timings = (String)prsec_nrs.getValueAt(row, 4); 
               // String dosegiven = (String)prsec_nrs.getValueAt(row,4); 

                pst.setString(1, patname);
                pst.setString(2, patid);
                pst.setString(3, medicinetime);
                pst.setString(4, quantity);
                pst.setString(5, timings); 
               // pst.setString(6, dosegiven);

                pst.addBatch();

                pst.executeBatch();
                con.commit();

                int ret=pst.executeUpdate();
                if(ret==1)
                {
                    JOptionPane.showMessageDialog(null,"<html>Ur info is added...<p>","Data Stored", 3);               
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Ur info is not added...","Data storage Failed", 3);               
                }

            }
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error in code is "+e.getMessage());
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        prsec_nrs = new javax.swing.JTable();
        B_ADD_PRESC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Prescription ");

        jButton2.setText("Click here to add Prescription ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        prsec_nrs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "patient name  ", "patient id", "medicine name", "quantity", "timings", "dose given"
            }
        ));
        jScrollPane1.setViewportView(prsec_nrs);

        B_ADD_PRESC.setText("ADD");
        B_ADD_PRESC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ADD_PRESCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(B_ADD_PRESC)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(B_ADD_PRESC)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void B_ADD_PRESCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ADD_PRESCActionPerformed
        addData();
    }//GEN-LAST:event_B_ADD_PRESCActionPerformed

    public static void main(String args[]) 
    {
                new prescription_NRS().setVisible(true);
    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_ADD_PRESC;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable prsec_nrs;
    // End of variables declaration//GEN-END:variables
}
