 package pateintreport;
 
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NursePortal extends JFrame implements ActionListener ,WindowListener,FocusListener
{
    JPanel p;
    JLabel lmain,lsel,limg,lbck;
    JButton bnew,bpresc,bchrt,bdischarge,blogout;
    JComboBox cslct ;
    
        JPanel ppres,pnewadmit,pdisch,pdiet,ptime;

    JLabel pres_pid, pres_pname, pres_medname, pres_medtime;
    JTextField pres_tfid, pres_tfname, pres_tfmedname;
    JTextField pres_tfmedtime;
    JButton pres_add;//,pres_addagn;
    
    JLabel newadmit_id, newadmit_name,newadmit_dr,newadmit_disease,newadmit_addr,newadmit_admiton,newadmit_room,newadmit_guardian, newadmit_relation,newadmit_contact; 
    JTextField newadmit_tfid, newadmit_tfname,newadmit_tfdr,newadmit_tfdisease,newadmit_tfaddr,newadmit_tfadmiton,newadmit_tfroom,newadmit_tfguardian, newadmit_tfrelation,newadmit_tfcontact; 
    JButton newadmit_submit;
    JLabel newadmit_chkid,newadmit_chkname,newadmit_chkdr,newadmit_chkdisease,newadmit_chkaddr,newadmit_chkadmiton,newadmit_chkroom,newadmit_chkguardian,newadmit_chkrelation,newadmit_chkcontact;
    
    JLabel disch_id, disch_name, disch_addr, disch_admit, disch_dischargedon,disch_contact;
    JTextField disch_tfid, disch_tfname, disch_tfaddr, disch_tfadmit, disch_tfdischargedon,disch_tfcontact;
    
    JLabel diet_id, diet_name, diet_food, diet_time ;
    JTextField diet_tfid, diet_tfname, diet_tffood, diet_tftime ;
    JButton diet_bback;
    
   
    
        
    NursePortal(String uid, String nrsnm)
    {
        p=new JPanel();
        lbck=new JLabel();
        limg=new JLabel(new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/chknurse.jpg"));
        lmain=new JLabel("WELCOME "+nrsnm.toUpperCase());
        lmain.setFont(new java.awt.Font("Times New Roman", 1, 20));
        lmain.setForeground(Color.blue);
        
        lsel=new JLabel("select Pateint");
        lsel.setFont(new java.awt.Font("Times New Roman",4,19));
        lsel.setForeground(Color.black);
        blogout=new JButton("LOGOUT");

        cslct=new JComboBox();
        
        bnew=new JButton("New Entry");
        bpresc=new JButton("Prescription");
        bchrt=new JButton("Health Chart");
        bdischarge=new JButton("Discharge Form");
        pres_add=new JButton("ADD");
        cslct.addItem("--Select Pateint--");
         try
        {
         connect connn=new connect();               
         Statement st;
         st=connn.con.createStatement();

         ResultSet res=st.executeQuery("select * from newpat");
         while(res.next())
         {
            cslct.addItem(""+res.getString(1).toUpperCase()+" : "+res.getString(2).toUpperCase()+" ");
         }
                       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        bnew.addActionListener((ActionListener)this); 
        bdischarge.addActionListener((ActionListener)this);
        bpresc.addActionListener((ActionListener)this);
        bchrt.addActionListener((ActionListener)this);
        blogout.addActionListener((ActionListener)this);

            //JPanel ppres,padmit,pdisch,pdiet,ptime;

        p.add(limg);
        limg.add(lbck);
        limg.add(lmain);
        limg.add(lsel);
        limg.add(cslct);
        limg.add(bnew);
        limg.add(bpresc);
        limg.add(bchrt);
        limg.add(bdischarge);
        limg.add(blogout);
         // padmit,ppres,pdiet,pdisch
        lbck.setSize(1440,800);  
      //  lbck.setBounds(0,150,1440,600);
        lmain.setBounds(300,30,600,35);
        lsel.setBounds(20,70,100,35);
        bnew.setBounds(400,115,140,35);
        bpresc.setBounds(550,115,140,35);
        bchrt.setBounds(700,115,140,35);
        bdischarge.setBounds(850,115,140,35);
        blogout.setBounds(1150,50,140,20);
        cslct.setBounds(20, 110, 300, 45);

        lbck.setVisible(true);
        lmain.setVisible(true);
        lsel.setVisible(true);
        bnew.setVisible(true);
        cslct.setVisible(true);
        bpresc.setVisible(true);
        bchrt.setVisible(true);
        limg.setVisible(true);
        limg.setSize(1440,800);
        p.setSize(1440,800);
        p.setLayout(null);
        p.setVisible(true);
        
        add(p);
        setSize(1440,800);
        setVisible(true);
        setResizable(false);
        addWindowListener((WindowListener)this);
    
    

        ppres=new JPanel();
        pnewadmit=new JPanel();
        pdisch=new JPanel();
        pdiet=new JPanel();
        ptime=new JPanel();
       // pres_addagn=new JButton("click here to view prescriptionNO");
        
        ppres.setLayout(null);
        pnewadmit.setLayout(null);
        pdisch.setLayout(null);
        pdiet.setLayout(null);
        ptime.setLayout(null);
        
//    JLabel pres_pid, pres_pname, pres_medname, pres_medtime;
//    JTextField pres_tfid, pres_tfname, pres_tfmedname, pres_tfmedtime;
//    Prescription Panel
        pres_pid=new JLabel("Registration ID"); pres_pid.setForeground(Color.blue); pres_pid.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_pname=new JLabel("Patient Name");  pres_pname.setForeground(Color.blue); pres_pname.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_medname=new JLabel("Medicine Name"); pres_medname.setForeground(Color.blue); pres_medname.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_medtime=new JLabel("Medicine Time"); pres_medtime.setForeground(Color.blue); pres_medtime.setFont(new java.awt.Font("Times New Roman",3,16));

        pres_pid.setBounds(50,50,200,20); 
        pres_pname.setBounds(50,80,200,20);
        pres_medname.setBounds(50,110,200,20);
        pres_medtime.setBounds(50,140,200,20);

        pres_tfid=new JTextField();
        pres_tfname=new JTextField();
        pres_tfmedname=new JTextField();
        pres_tfmedtime=new JTextField();
//        pres_tfmedtime.addItem("--SELECT TIME--");
//        pres_tfmedtime.addItem("MORNING");
//        pres_tfmedtime.addItem("EVENING");
//        pres_tfmedtime.addItem("NIGHT");
     
        pres_tfid.setBounds(250,50,200,20);   pres_tfid.setEditable(false);
        pres_tfname.setBounds(250,80,200,20);   
        pres_tfmedname.setBounds(250,110,200,20); 
        pres_tfmedtime.setBounds(250,140,200,20);                 

        ppres.add(pres_pid);
        ppres.add(pres_pname);
        ppres.add(pres_medname);
        ppres.add(pres_medtime);
        ppres.add(pres_tfid);
        ppres.add(pres_tfname);
        ppres.add(pres_tfmedname);
        ppres.add(pres_tfmedtime);
        ppres.add( pres_add);
//        ppres.add(pres_addagn);
        pres_add.setBounds(250,200,100,30);
//        pres_addagn.setBounds(250,250,250,30);
        pres_add.addActionListener((ActionListener)this);
//        pres_addagn.addActionListener((ActionListener)this);
       
        
    
//    JLabel admit_id, admt_name,admit_addr,admit_admiton,admit_room,admit_guardian, admit_relation,admit_contact; 
//    JTextField admit_tfid, admit_tfname,admit_tfaddr,admit_tfadmiton,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
//    JLabel chkid,chkname,chkaddr,chkadmiton,chkroom,chkguardian,chkrelation,chkcontact;
      
        //ADMIT PATEINTS PANEL TO KNOW THE  DETAILS OF PATEINT
        newadmit_id=new JLabel("Registration ID");
        newadmit_name=new JLabel("Patient Name");
        newadmit_dr=new JLabel("Doctor Name");
        newadmit_disease=new JLabel("Disease");
        newadmit_addr=new JLabel("Address");
        newadmit_admiton=new JLabel("Admit On");
        newadmit_room=new JLabel("Room No");
        newadmit_guardian=new JLabel("Guardian Name");
        newadmit_relation=new JLabel("Guardian Relation");
        newadmit_contact=new JLabel("Contact No.");
        
        newadmit_tfid=new JTextField();  newadmit_tfid.setEditable(false);
        newadmit_tfname=new JTextField();
        newadmit_tfdr=new JTextField();
        newadmit_tfdisease=new JTextField();
        newadmit_tfaddr=new JTextField();
        newadmit_tfadmiton=new JTextField();
        newadmit_tfroom=new JTextField();
        newadmit_tfguardian=new JTextField();
        newadmit_tfrelation=new JTextField();
        newadmit_tfcontact=new JTextField();
        newadmit_submit=new JButton("SUBMIT");
        newadmit_submit.setFont(new java.awt.Font("Times New Roman",4,19));
        newadmit_submit.setForeground(Color.black);
        newadmit_submit.setVisible(true);        
        
          
        newadmit_chkid=new JLabel(""); 
        newadmit_chkname=new JLabel(""); 
        newadmit_chkdr=new JLabel("");
        newadmit_chkdisease=new JLabel("");
        newadmit_chkaddr=new JLabel("");
        newadmit_chkadmiton=new JLabel("");
        newadmit_chkroom =new JLabel("");
        newadmit_chkrelation=new  JLabel("");
        newadmit_chkguardian=new JLabel("");
        newadmit_chkcontact=new JLabel("");
        
      
        newadmit_id.setBounds(50,50,200,20);    newadmit_id.setForeground(Color.blue);  newadmit_id.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_name.setBounds(50,80,200,20); newadmit_name.setForeground(Color.blue);  newadmit_name.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_dr.setBounds(50,110,200,20);    newadmit_dr.setForeground(Color.blue);  newadmit_dr.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_disease.setBounds(50,140,200,20);    newadmit_disease.setForeground(Color.blue);  newadmit_disease.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_addr.setBounds(50,170,200,20);    newadmit_addr.setForeground(Color.blue);  newadmit_addr.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_admiton.setBounds(50,200,200,20); newadmit_admiton.setForeground(Color.blue);  newadmit_admiton.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_room.setBounds(50,230,200,20);    newadmit_room.setForeground(Color.blue);  newadmit_room.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_guardian.setBounds(50,260,200,20);    newadmit_guardian.setForeground(Color.blue);  newadmit_guardian.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_relation.setBounds(50,290,200,20);    newadmit_relation.setForeground(Color.blue);  newadmit_relation.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_contact.setBounds(50,320,200,20);     newadmit_contact.setForeground(Color.blue);  newadmit_contact.setFont(new java.awt.Font("Times New Roman",3,16));
        
        newadmit_tfid.setBounds(250,50,200,20);
        newadmit_tfname.setBounds(250,80,200,20);
        newadmit_tfdr.setBounds(250,110,200,20);
        newadmit_tfdisease.setBounds(250,140,200,20);
        newadmit_tfaddr.setBounds(250,170,200,20);
        newadmit_tfadmiton.setBounds(250,200,200,20);
        newadmit_tfroom.setBounds(250,230,200,20);
        newadmit_tfguardian.setBounds(250,260,200,20);
        newadmit_tfrelation.setBounds(250,290,200,20);
        newadmit_tfcontact.setBounds(250,320,200,20);        

        newadmit_chkid.setBounds(500,50,200,20);   newadmit_chkid.setForeground(Color.RED);  newadmit_chkid.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkname.setBounds(500,80,200,20);   newadmit_chkname.setForeground(Color.RED); newadmit_chkname.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkdr.setBounds(500,110,200,20);    newadmit_chkdr.setForeground(Color.RED); newadmit_chkdr.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkdisease.setBounds(500,140,200,20);   newadmit_chkdisease.setForeground(Color.RED); newadmit_chkdisease.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkaddr.setBounds(500,170,200,20);   newadmit_chkaddr.setForeground(Color.RED);   newadmit_chkaddr.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkadmiton.setBounds(500,200,200,20);    newadmit_chkadmiton.setForeground(Color.RED);  newadmit_chkadmiton.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkroom.setBounds(500,230,200,20);    newadmit_chkroom.setForeground(Color.RED);    newadmit_chkroom.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkguardian.setBounds(500,260,200,20);    newadmit_chkguardian.setForeground(Color.RED);    newadmit_chkguardian.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkrelation.setBounds(500,290,400,20);   newadmit_chkrelation.setForeground(Color.RED);     newadmit_chkrelation.setFont(new java.awt.Font("Times New Roman",3,16));
        newadmit_chkcontact.setBounds(500,320,200,20);   newadmit_chkcontact.setForeground(Color.RED);   newadmit_chkcontact.setFont(new java.awt.Font("Times New Roman",3,16));

        newadmit_submit.setBounds(500,360 , 200, 20);            newadmit_submit.addActionListener((ActionListener)this); 
//                newadmit_submit.addMouseListener((MouseListener)this);  

//        JLabel newadmit_id, newadmit_name,newadmit_dr,newadmit_disease,newadmit_addr,newadmit_admiton,newadmit_room,newadmit_guardian, newadmit_relation,newadmit_contact; 
//    JTextField newadmit_tfid, newadmit_tfname,newadmit_tfdr,newadmit_tfdisease,newadmit_tfaddr,newadmit_tfadmiton,newadmit_tfroom,newadmit_tfguardian, newadmit_tfrelation,newadmit_tfcontact; 
//    
        pnewadmit.add(newadmit_id);
        pnewadmit.add(newadmit_name);
        pnewadmit.add(newadmit_dr);
        pnewadmit.add(newadmit_disease);
        pnewadmit.add(newadmit_addr);
        pnewadmit.add(newadmit_admiton);
        pnewadmit.add(newadmit_room);
        pnewadmit.add(newadmit_relation);
        pnewadmit.add(newadmit_guardian);
        pnewadmit.add(newadmit_contact);
        
        pnewadmit.add(newadmit_tfid);
        pnewadmit.add(newadmit_tfname);
        pnewadmit.add(newadmit_tfdr);
        pnewadmit.add(newadmit_tfdisease);
        pnewadmit.add(newadmit_tfaddr);
        pnewadmit.add(newadmit_tfadmiton);
        pnewadmit.add(newadmit_tfroom);
        pnewadmit.add(newadmit_tfrelation);
        pnewadmit.add(newadmit_tfguardian);
        pnewadmit.add(newadmit_tfcontact);
        
        pnewadmit.add(newadmit_chkid);
        pnewadmit.add(newadmit_chkname);
        pnewadmit.add(newadmit_chkdr);
        pnewadmit.add(newadmit_chkdisease);
        pnewadmit.add(newadmit_chkaddr);
        pnewadmit.add(newadmit_chkadmiton);
        pnewadmit.add(newadmit_chkroom);
        pnewadmit.add(newadmit_chkrelation);
        pnewadmit.add(newadmit_chkguardian);
        pnewadmit.add(newadmit_chkcontact);
        
        pnewadmit.add(newadmit_submit);
       
        
        newadmit_tfid.addActionListener((ActionListener)this);     newadmit_tfid.addFocusListener((FocusListener)this);         
        newadmit_tfname.addActionListener((ActionListener)this);   newadmit_tfname.addFocusListener((FocusListener)this);
        newadmit_tfdr.addActionListener((ActionListener)this);   newadmit_tfdr.addFocusListener((FocusListener)this);
        newadmit_tfdisease.addActionListener((ActionListener)this);   newadmit_tfdisease.addFocusListener((FocusListener)this);
        newadmit_tfaddr.addActionListener((ActionListener)this);   newadmit_tfaddr.addFocusListener((FocusListener)this);
        newadmit_tfadmiton.addActionListener((ActionListener)this);    newadmit_tfadmiton.addFocusListener((FocusListener)this);
        newadmit_tfroom.addActionListener((ActionListener)this);   newadmit_tfroom.addFocusListener((FocusListener)this);
        newadmit_tfguardian.addActionListener((ActionListener)this);   newadmit_tfguardian.addFocusListener((FocusListener)this);
        newadmit_tfrelation.addActionListener((ActionListener)this);   newadmit_tfrelation.addFocusListener((FocusListener)this);
        newadmit_tfcontact.addActionListener((ActionListener)this);    newadmit_tfcontact.addFocusListener((FocusListener)this);
        
        //    JLabel admit_id, admt_name,admit_addr,admit_admiton,admit_room,admit_guardian, admit_relation,admit_contact; 
    
        
//    JLabel disch_id, disch_name, disch_addr, disch_admit, disch_dischargedon,disch_contact;
//    JTextField disch_tfid, disch_tfname, disch_tfaddr, disch_tfadmit, disch_tfdischargedon,disch_tfcontact; TO MAKE THE DISCHARGE FRM
//      DISCHARGE PORTAL
        disch_id=new JLabel("Registration ID");
        disch_name=new JLabel("Patient Name");
        disch_addr=new JLabel("Address");
        disch_admit=new JLabel("Admitted On");
        disch_dischargedon=new JLabel("Discharged On");
        disch_contact=new JLabel("Contact No.");

        disch_tfid=new JTextField();
        disch_tfname=new JTextField();
        disch_tfaddr=new JTextField();
        disch_tfadmit=new JTextField();
        disch_tfdischargedon=new JTextField();
        disch_tfcontact=new JTextField();
        
        disch_id.setBounds(50,50,200,20);
        disch_name.setBounds(50,80,200,20);
        disch_addr.setBounds(50,110,200,20);
        disch_admit.setBounds(50,140,200,20);
        disch_dischargedon.setBounds(50,170,200,20);
        disch_contact.setBounds(50,200,200,20);
        
        disch_tfid.setBounds(250,50,200,20);
        disch_tfname.setBounds(250,80,200,20);
        disch_tfaddr.setBounds(250,110,200,20);
        disch_tfadmit.setBounds(250,140,200,20);
        disch_tfdischargedon.setBounds(250,170,200,20);
        disch_tfcontact.setBounds(250,200,200,20);
        
        
        pdisch.add(disch_id);
        pdisch.add(disch_name);
        pdisch.add(disch_addr);
        pdisch.add(disch_admit);
        pdisch.add(disch_dischargedon);
        pdisch.add(disch_contact);
        
        pdisch.add(disch_tfid);
        pdisch.add(disch_tfname);
        pdisch.add(disch_tfaddr);
        pdisch.add(disch_tfadmit);
        pdisch.add(disch_tfdischargedon);
        pdisch.add(disch_tfcontact);
        
 
//    JLabel diet_id, diet_name, diet_food, diet_time ;
//    JTextField diet_tfid, diet_tfname, diet_tffood, diet_tftime ;
//  DIET CHART OF  THE PATEINT
        diet_id=new JLabel("Registration ID");
        diet_name=new JLabel("Patient Name");
        diet_food=new JLabel("Food Item");
        diet_time=new JLabel("Time");

        diet_tfid=new JTextField();
        diet_tfname=new JTextField();
        diet_tffood=new JTextField();
        diet_tftime=new JTextField();
        
        diet_bback=new JButton();
        diet_bback.setBounds(0,50,200,20);
        
        diet_id.setBounds(50,50,200,20);
        diet_name.setBounds(50,80,200,20);
        diet_food.setBounds(50,110,200,20);
        diet_time.setBounds(50,140,200,20);

        diet_tfid.setBounds(250,50,200,20);
        diet_tfname.setBounds(250,80,200,20);
        diet_tffood.setBounds(250,110,200,20);
        diet_tftime.setBounds(250,140,200,20);        
        
        
        pdiet.add(diet_id);
        pdiet.add(diet_name);
        pdiet.add(diet_food);
        pdiet.add(diet_time);

        pdiet.add(diet_tfid);
        pdiet.add(diet_tfname);
        pdiet.add(diet_tffood);
        pdiet.add(diet_tftime);
        pdiet.add(diet_bback);
        
       
        ppres.setBounds(50,180,1350,550);
        pnewadmit.setBounds(50,180,1350,550);
        pdisch.setBounds(50,180,1350,550);
        pdiet.setBounds(50,180,1350,550);
        ptime.setBounds(50,180,1350,550);
        
        ppres.setBackground(Color.white);
        pnewadmit.setBackground(Color.white);
        pdisch.setBackground(Color.white);
        pdiet.setBackground(Color.white);
        ptime.setBackground(Color.white);
        
        ppres.setVisible(false);
        pnewadmit.setVisible(false);
        pdisch.setVisible(false);
        pdiet.setVisible(false);
        ptime.setVisible(false);
        
        
        limg.add(ppres);
        limg.add(pnewadmit);
        limg.add(pdisch);
        limg.add(pdiet);
//    
         int row;
   Connection con;
        try
        {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from newpat");
        rs.last();
        row=rs.getRow();
         autogen(row);
        }
        catch(Exception f)
        { }
    }
    //AUTO GENERATION OF THE REGISTRTATION NUMBER     
    public void autogen(int row)
  {
      try
      {
          if(row<=8)
          {
              newadmit_tfid.setText("R00"+String.valueOf(row+1));
          }
          
          else if((row>=9)||(row<=98))
          {
              newadmit_tfid.setText("R0"+String.valueOf(row+1));
          }
          else if((row>=99))//||row<=999)
          {
              newadmit_tfid.setText("R"+String.valueOf(row+1));
          }
              
      }
      catch(Exception f)
      {
        System.out.println("catched auto gen error = "+f.getMessage());
      }
 
        
    }
    
         
    public static void main(String arg[])
    {
       NursePortal nrs= new NursePortal("userid","nurse");
    }

    
    
    
    //ACTIONS TO BE PERFORMED ON THE VARIOUS BUTTONS
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object o=e.getSource();
        if(o==blogout)
        {
            FirstPage fp=new FirstPage();
            setVisible(false);
        }
     // bnew,bpresc,bchrt,bdischarge,blogout
         if(o==bpresc)
        {
           // presNurse pn =new presNurse();
            prescription p=new prescription();
            p.setBounds(50,250,700,550);
       //  pn.setBounds(789,250,700,550);
//       
            ppres.setVisible(false);
            pnewadmit.setVisible(false);
            pdisch.setVisible(false);
            pdiet.setVisible(false);
            ptime.setVisible(false);
            
               
        }
         if(o==bnew)
         {
         ppres.setVisible(false);
            pnewadmit.setVisible(true);
            pdisch.setVisible(false);
            pdiet.setVisible(false);
            ptime.setVisible(false);
            
         }
        if(o==newadmit_submit)
        {
             try
                    {
                        connect c=new connect();               
                        PreparedStatement ps;
                        ps=c.con.prepareStatement("insert into newpat values(?,?,?,?,?,?,?,?,?,?)");
                    //id,name,rmno,dr,dis,dtadm,add,cnt,grd,rel
                        ps.setString(1,newadmit_tfid.getText());
                        ps.setString(2,newadmit_tfname.getText());
                        ps.setString(3,newadmit_tfdr.getText());
                        ps.setString(4,newadmit_tfdisease.getText());
                        ps.setString(5,newadmit_tfaddr.getText());
                        ps.setString(6,newadmit_tfadmiton.getText());
                        ps.setString(7,newadmit_tfroom.getText());
                        ps.setString(8,newadmit_tfguardian.getText());
                        ps.setString(9,newadmit_tfrelation.getText());
                        ps.setString(10,newadmit_tfcontact.getText());
                        //0,newadmit_tfcontact.getText());

                        int i=ps.executeUpdate();
                        if(i==1)
                        {
                        JOptionPane.showMessageDialog(null,"Ur Data is added..."+newadmit_tfid.getText()+" ","Data Stored", 3);              
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(null,"Ur info is not added...","Data storage Failed", 3);
                        }
                        
                    }
                catch(Exception ex)
                {
                    System.out.println("Error in code:");//+ex.getMessage());
                    //JOptionPane.showMessageDialog(null,"Error in code  : "+ex.getMessage(),"Error Message", 1);  
                }
         }
      
        if(o==newadmit_submit)
        {
            if((newadmit_tfid.getText().length()==0)||(newadmit_tfname.getText().length()==0)||(newadmit_tfdr.getText().length()==0)||(newadmit_tfdisease.getText().length()==0)||(newadmit_tfaddr.getText().length()==0)||(newadmit_tfadmiton.getText().length()==0)||(newadmit_tfroom.getText().length()==0)
              ||(newadmit_tfguardian.getText().length()==0)||(newadmit_tfrelation.getText().length()==0)||newadmit_tfcontact.getText().length()==0)
                {
                // System.out.println("invalid data ");
                JOptionPane.showMessageDialog(null,"Invalid Data","Data not Inserted ", 3);               
                }
 
// JLabel admit_id, admit_name,admit_addr,admit_admiton,admit_room,admit_guardian, admit_relation,admit_contact; 
//    JTextField admit_tfid, admit_tfname,admit_tfaddr,admit_tfadmiton,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
            else
            {   
                try
                    {
                        connect c=new connect();               
                        PreparedStatement ps;
                        ps=c.con.prepareStatement("insert into newpat values(?,?,?,?,?,?,?,?,?,?)");
                        ps.setString(1,newadmit_tfid.getText());
                        ps.setString(2,newadmit_tfname.getText());
                        ps.setString(3,newadmit_tfaddr.getText());
                        ps.setString(3,newadmit_tfaddr.getText());
                        ps.setString(4,newadmit_tfadmiton.getText());
                        ps.setString(5,newadmit_tfroom.getText());
                        ps.setString(6,newadmit_tfguardian.getText());
                        ps.setString(7,newadmit_tfrelation.getText());
                        ps.setString(8,newadmit_tfcontact.getText());
                        ps.setString(9,newadmit_tfcontact.getText());
                        ps.setString(10,newadmit_tfcontact.getText());

                        int i=ps.executeUpdate();
                        if(i==1)
                        {
                        JOptionPane.showMessageDialog(null,"Ur Data is added..."+newadmit_tfid.getText()+" ","Data Stored", 3);              
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(null,"Ur info is not added...","Data storage Failed", 3);
                        }
                    }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Error in code  : "+ex.getMessage(),"Error Message", 1);  
                }
            }
        }

        if(o==bdischarge)
        {
            discharge d=new discharge();
            // d.setBounds(50,230,1350,550);
            ppres.setVisible(false);
            pnewadmit.setVisible(false);
            pdisch.setVisible(false);
        }
        if(o==diet_bback)
        {
            //ppres,pnewadmit,pdisch,pdiet,ptime;
             ppres.setVisible(false);
            pnewadmit.setVisible(false);
            pdisch.setVisible(false);
           pdiet.setVisible(true);       
           // NursePortal np=new NursePortal();
            
        }
        if(o==bchrt)
        {
           DietChart dc =new DietChart();
         ppres.setVisible(false);
            pnewadmit.setVisible(false);
            pdisch.setVisible(false);
            pdiet.setVisible(false);
            ptime.setVisible(false);
            
            dc.setBounds(50,230,1350,550);
//            ppres.setVisible(false);
//            pnewadmit.setVisible(false);
//            pdisch.setVisible(false);
//                       // NursePortal np=new NursePortal();

        //nrs.setVisible(false);
          //  setVisible(false);
        }
//            ppres.setVisible(false);
//            padmit.setVisible(false);
//            pdisch.setVisible(false);
//            pdiet.setVisible(true);
//            ptime.setVisible(false);
//            try
//            {
//                String patientId=getSelectedPatient();
//                pres_tfid.setText(patientId);
//            }
//            catch(Exception ex)
//            {
//            
//            }
           
        
       
       
    }
    @Override
        public void focusLost(FocusEvent e) 
    {
     Object o=e.getSource();
                     if(o==newadmit_tfid)
                     {
                         if(newadmit_tfid.getText().length()==0)
                         {
                         newadmit_chkid.setText("!Enter Registration number");
                         }
                     }
                     if(o==newadmit_tfname) 
                          {
                              if(newadmit_tfname.getText().length()<=2)
                                 {
                                     newadmit_chkname.setText("Enter Patient name");
                                 }                        
                                 else{newadmit_chkname.setText("");}
                        }

                    if(o==newadmit_tfaddr)
                    {
                        if(newadmit_tfaddr.getText().length()==0)
                        {
                            newadmit_chkaddr.setText("!Enter your address");
                        }
                        else
                        {
                            newadmit_chkaddr.setText("");
                        }
                    }
                     
                     if(o==newadmit_tfadmiton)
                     { if(newadmit_tfadmiton.getText().length()==0)
                         {
                             newadmit_chkadmiton.setText("!Enter date admitted ");
                             //tfdtadm.requestFocus();
                         }
                         else
                             newadmit_chkadmiton.setText("");
                     }
                     if(o==newadmit_tfroom)
                     {
                         if(newadmit_tfroom.getText().length()==0)
                         {newadmit_chkroom.setText("!Enter room no");
                         //tfrmno.requestFocus();}
                         }else
                             newadmit_chkroom.setText("");
                     }
                     if(o==newadmit_tfguardian)
                     {if(newadmit_tfguardian.getText().length()==0)
                         {
                             newadmit_chkguardian.setText("!Enter guardian name ");
                             //tagrd.requestFocus();
                         }
                         else
                             newadmit_chkguardian.setText("");
                     }
                     
                     if(o==newadmit_tfrelation)
                     {
                     if(newadmit_tfrelation.getText().length()==0)
                         {
                             newadmit_chkrelation.setText("!Enter relation with guardian ");
                             //tagrd.requestFocus();
                         }
                         else
                             newadmit_chkrelation.setText("");
                     
                     }
                     if(o==newadmit_tfcontact)
                     { 
                       if((newadmit_tfcontact.getText().length()>10)||(newadmit_tfcontact.getText().length()<10))
                        {
                            newadmit_chkcontact.setText("! Enter your 24-hr available Contact");
                        }
                       else
                       {
                           newadmit_chkcontact.setText("");
                       }
                     }
    }

    
    public void keyTyped(KeyEvent e) 
    {
     Object o=e.getSource();
	if(o==newadmit_tfname)
	{	char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		//e.getToolkit.beep();
		newadmit_chkname.setText("! Enter characters only .");
		//altname.setForeground(new Color(204,0,0));
		}
		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		newadmit_chkname.setText("");
		}
	}
        if(o==newadmit_tfaddr)
                {}
        if(o==newadmit_tfadmiton)
        {}
       if(o==newadmit_tfroom)
        {
        char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		newadmit_chkroom.setText("! Enter no. of years only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		newadmit_chkroom.setText("");
		}
	}
       if(o==newadmit_tfguardian)
       {}
       if(o==newadmit_tfrelation)
       {}
     if(o==newadmit_tfcontact)
     {
         
	char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		newadmit_chkcontact.setText("! Enter valid number ");
		}
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		newadmit_chkcontact.setText(" ");
		}

  }  
  
    }
    public String getSelectedPatient()
    {
        String selectedPatient=cslct.getSelectedItem().toString();
        String pID=null;//, pName=null;
        pID=selectedPatient.substring(0,4);
//        System.out.println("selected patient = "+pID);
        return pID;
    }
            
       public void windowClosing(WindowEvent e)
      {  
	int a=JOptionPane.showConfirmDialog(this,"Are you sure to exit?");  
	if(a==JOptionPane.YES_OPTION)
        {  
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}}
         public void windowDeactivated(WindowEvent e){}
      public void windowActivated(WindowEvent e){}
      public void windowDeiconified(WindowEvent e){}
      public void windowIconified(WindowEvent e){}
      public void windowClosed(WindowEvent e){}
      public void windowOpened(WindowEvent e){}

//      public void MouseClicked(MouseEvent e)
//      { 
//                      Object o=e.getSource();
//
//      if(o==newadmit_submit)
//      {
////          newadmit_tfid.getText());
//                        ps.setString(2,newadmit_tfname.getText());
//                        ps.setString(3,newadmit_tfaddr.getText());
//                        ps.setString(4,newadmit_tfadmiton.getText());
//                        ps.setString(5,newadmit_tfroom.getText());
//                        ps.setString(6,newadmit_tfguardian.getText());
//                        ps.setString(7,newadmit_tfrelation.getText());
//                        ps.setString(8,newadmit_tfcontact.getText());
//                        ps.setString(9,newadmit_tfcontact.getText());
//                        ps.setString(10,newadmit_tfcontact.getText());
//
//       newadmit_tfid.setText("");
//                newadmit_tfname.setText("");
//                newadmit_tfaddr.setText("");
//                newadmit_tfadmiton.setText("");
//                newadmit_tfroom.setText("");
//                newadmit_tfguardian.setText("");
//                tcrtpass.setText("");
//                tcnfpnewadmit_tfrelationass.setText("");
//               
     @Override
    public void focusGained(FocusEvent e) {}

}   