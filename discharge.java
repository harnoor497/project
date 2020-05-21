package pateintreport;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class discharge extends javax.swing.JFrame 
{
    public discharge() 
    {
        initComponents();
        setVisible(true);
        setSize(1440,800);
        try
            {   
                String patientId;
           // patientId = getSelectedPatient();
             //   tf_patid.setText(patientId);
                connect c=new connect();               
                Statement st;
                st=c.con.createStatement();
                ResultSet res=st.executeQuery("select * from newpat where registrationno='");//+patientId+"'"); 
                while(res.next()){
                //System.out.println("hel");
                //System.out.println("hel"+res.getString(2));
       // JTextField admit_tfid, admit_tfname,admit_tfaddr,admit_tfadmiton,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
//id,name,dis,add,admton,rmno.grdnname,grdnrel,cont
                tf_patname.setText(res.getString(2));
                tf_drname.setText(res.getString(3));
                tf_disease.setText(res.getString(4));
                tf_address.setText(res.getString(5));
                // ps.setString(3,tcourse.getSelectedItem().toString());
                             
                tf_admiton.setText(res.getString(6));
                //admit_tfroom.setText(res.getString(7));
               // admit_tfguardian.setText(res.getString(8));
                //admit_tfrelation.setText(res.getString(9));
                tf_contact.setText(res.getString(10));
              }
            }
            catch(Exception ex)
            {
            System.out.println("Exception catched by me = "+ex.getMessage());
            }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p = new javax.swing.JPanel();
        l_main = new javax.swing.JLabel();
        patname = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        admiton = new javax.swing.JLabel();
        disease = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        dison = new javax.swing.JLabel();
        remarks = new javax.swing.JLabel();
        drname = new javax.swing.JLabel();
        tf_disease = new javax.swing.JTextField();
        tf_dison = new javax.swing.JTextField();
        tf_contact = new javax.swing.JTextField();
        tf_address = new javax.swing.JTextField();
        tf_patname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_drname = new javax.swing.JTextField();
        b_gen_rprt = new javax.swing.JButton();
        patid = new javax.swing.JLabel();
        tf_patid = new javax.swing.JTextField();
        tf_admiton = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        p.setBounds(new java.awt.Rectangle(0, 0, 100, 100));
        p.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        p.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p.setPreferredSize(new java.awt.Dimension(1440, 700));

        l_main.setText("DISCHARGE FORM ");

        patname.setText("PATIENT NAME ");

        address.setText("ADDRESS");

        admiton.setText("ADMIT ON");

        disease.setText("DISEASE");

        contact.setText("CONTACT");

        dison.setText("DISCHARGED ON ");

        remarks.setText("REMARKS ");

        drname.setText("DOCTOR NAME ");

        tf_dison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_disonActionPerformed(evt);
            }
        });

        tf_patname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_patnameActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("          CONSULT RECEPTIONIST FOR UNDERGONE TREATMENT  REPORT");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("                               WISH YOU A HEALTHY LIFE!!");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        b_gen_rprt.setText("GENERATE REPORT ");
        b_gen_rprt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_gen_rprtActionPerformed(evt);
            }
        });

        patid.setText("PATIENT ID");

        tf_admiton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_admitonActionPerformed(evt);
            }
        });

        tf_remarks.setColumns(20);
        tf_remarks.setRows(5);
        jScrollPane1.setViewportView(tf_remarks);

        jButton1.setText("go to docter portal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("go to nurse portal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                        .addComponent(l_main, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(462, 462, 462)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton2)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                        .addComponent(b_gen_rprt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(558, 558, 558))))
            .addGroup(pLayout.createSequentialGroup()
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drname)
                            .addComponent(admiton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disease, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dison)
                            .addComponent(contact)
                            .addComponent(remarks))
                        .addGap(30, 30, 30)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_disease, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dison, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pLayout.createSequentialGroup()
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pLayout.createSequentialGroup()
                                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tf_admiton, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_patname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(tf_drname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                        .addGap(122, 122, 122)
                                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(patid)
                                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(51, 51, 51)
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_address, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(tf_patid)))))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_main, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patid)
                            .addComponent(tf_patid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address)
                            .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_patname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_drname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drname))
                        .addGap(27, 27, 27)))
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admiton)
                    .addComponent(tf_admiton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_disease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disease, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_dison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dison))
                .addGap(34, 34, 34)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact))
                .addGap(36, 36, 36)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(remarks)))
                .addGap(13, 13, 13)
                .addComponent(b_gen_rprt)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jLabel12.getAccessibleContext().setAccessibleName("             \t      WISH YOU A HEALTHY LIFE!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_disonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_disonActionPerformed
    }//GEN-LAST:event_tf_disonActionPerformed

    private void b_gen_rprtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_gen_rprtActionPerformed
   
    }//GEN-LAST:event_b_gen_rprtActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      //  DocterPortal dp=new DocterPortal("userid","static method");
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //DocterPortal dp=new DocterPortal("userid","static method");

    }//GEN-LAST:event_formWindowClosed

    private void tf_patnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_patnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_patnameActionPerformed

    private void tf_admitonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_admitonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_admitonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        NursePortal np=new NursePortal("userid","static method");
         np.ppres.setVisible(false);
            np.pnewadmit.setVisible(false);
            np.pdisch.setVisible(false);
            np.pdiet.setVisible(false);
            np.ptime.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          DocterPortal dp=new DocterPortal("userid","static ");


    }//GEN-LAST:event_jButton1ActionPerformed
public void windowClosing(WindowEvent e)
      {  
//
//          DocterPortal dp=new DocterPortal("userid","static ");
            int a=JOptionPane.showConfirmDialog(this,"Are you sure to exit?");  
            if(a==JOptionPane.YES_OPTION)
            {  
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            }
          }
    
    

    public static void main(String args[]) 
    {
      new discharge();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel admiton;
    private javax.swing.JButton b_gen_rprt;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel disease;
    private javax.swing.JLabel dison;
    private javax.swing.JLabel drname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_main;
    private javax.swing.JPanel p;
    private javax.swing.JLabel patid;
    private javax.swing.JLabel patname;
    private javax.swing.JLabel remarks;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_admiton;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_disease;
    private javax.swing.JTextField tf_dison;
    private javax.swing.JTextField tf_drname;
    private javax.swing.JTextField tf_patid;
    private javax.swing.JTextField tf_patname;
    private javax.swing.JTextArea tf_remarks;
    // End of variables declaration//GEN-END:variables
}