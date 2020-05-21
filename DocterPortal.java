package pateintreport;
//importing all the classes
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class DocterPortal extends JFrame implements WindowListener,ActionListener,FocusListener
{//registering components
    
String d=null,m=null,y=null,date=null;

    JPanel p;
    JLabel l,lslct,lbck,dname;
    JButton bpres,badmit,bdisch,bdiet, blogout;
    JComboBox cslctpat;
    
    JPanel ppres,padmit,pdisch,pdiet;//,ptime;
    
    JLabel pres_pid, pres_pname, pres_medname, pres_medtime,pres_quant;
    JTextField pres_tfid, pres_tfname, pres_tfmedname,pres_tfmedtime,pres_tfquant;
    JButton pres_add,pres_addagn;
    
    JLabel admit_id, admit_name,admit_dr,admit_disease,admit_addr,admit_admiton,admit_room,admit_guardian, admit_relation,admit_contact; 
    JTextField admit_tfid, admit_tfname,admit_tfdr,admit_tfaddr,admit_tfadmiton,admit_tfdisease,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
    JLabel admit_chkid,admit_chkname,admit_chkdisease,admit_chkaddr,admit_chkadmiton,admit_chkroom,admit_chkguardian,admit_chkrelation,admit_chkcontact;
    JComboBox admit_day ,admit_month ,admit_year;//,tcourse ; 

    
    JLabel disch_name,disch_id, disch_dr,disch_addr, disch_admit,disch_dis, disch_dischargedon,disch_contact,disch_remark;
    JTextField disch_tfname,disch_tfid,disch_tfdr, disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;
    JButton disch_ok,disch_gnrprt;
    JTextArea disch_taremark;
    
    JLabel diet_id, diet_name ;
    JTextField diet_tfid, diet_tfname;//, diet_tffood, diet_tftime ;
    JButton diet_bcheck;
    
//    JLabel time_id, time_name, time_shift;
//    JTextField time_tfid, time_tfname, time_tfshift;
//    
    //constructor 

    DocterPortal(String uid, String dnm)
    {
    //giving memory to all the objects and setting all the attributes
        cslctpat=new JComboBox();
        p=new JPanel();
        l=new JLabel("Docter Portal");
        l.setFont(new java.awt.Font("Times New Roman", 1, 24));
        l.setForeground(Color.blue);
  
        dname=new JLabel("WELCOME "+dnm.toUpperCase());
        dname.setFont(new java.awt.Font("Times New Roman", 0, 20));
        dname.setForeground(Color.blue);
        lbck=new JLabel();
        p.setBackground(new Color(0,153,255));
        lbck=new JLabel(new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/nurse.jpg"));
        lbck.setSize(1440,800);
        lbck.setVisible(true);
        lslct=new JLabel("Select Pateint");
        lslct.setFont(new java.awt.Font("American Typewriter", 1, 15));
        bpres=new JButton("PRESCRIPTION");
        badmit=new JButton("ADMIT PATIENT");
        bdisch=new JButton("DISCHARGED");
        bdiet=new JButton("PRESCRIPTION/DIET TABLE");
//        btime=new JButton("UPDATE TIME TABLE");
        
        pres_add=new JButton("ADD");
        pres_addagn=new JButton("Click here to view prescription ?");
        
        blogout=new JButton("LOGOUT");
        
        cslctpat.addItem("---Select Pateint---");
        //retreiving all the admitted pateints and their registration ids into  the combobox
        try
        {
         connect connn=new connect();               
         Statement st;
         st=connn.con.createStatement();

         ResultSet res=st.executeQuery("select * from newpat");
         while(res.next())
         {
            cslctpat.addItem(""+res.getString(1).toUpperCase()+" : "+res.getString(2).toUpperCase()+" ");
         }
                       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        p.add(lbck);
        lbck.add(l);
        lbck.add(dname);
        lbck.add(lslct);
        lbck.add(bpres);      
        lbck.add(badmit);
        lbck.add(bdisch);
        lbck.add(bdiet);
//        lbck.add(btime);
        lbck.add(blogout);
        lbck.add(cslctpat);
        
        l.setBounds(150,30,250,30);
        dname.setBounds(500,30,250,30);
        
        lslct.setBounds(110,90,150,25);
        bpres.setBounds(450,120,150,35);
        badmit.setBounds(620,120,150,35);
        bdisch.setBounds(800,120,150,35);
        bdiet.setBounds(970,120,150,35);
//        btime.setBounds(1140,120,150,35);
        
        blogout.setBounds(1300,100,100,20);
        cslctpat.setBounds(100,120,200,35);
        p.setLayout(null);
        p.setVisible(true);
        
        bpres.addActionListener((ActionListener)this);
        badmit.addActionListener((ActionListener)this);
        bdisch.addActionListener((ActionListener)this);
        bdiet.addActionListener((ActionListener)this);
//        btime.addActionListener((ActionListener)this);
        
        blogout.addActionListener((ActionListener)this);
        add(p);
        setSize(1440,800);
        setVisible(true);
        setResizable(false);
        addWindowListener((WindowListener)this);
        
        //creating panels on the basis of buttons and retreiving functions as per the buttons
        ppres=new JPanel();
        padmit=new JPanel();
        pdisch=new JPanel();
        pdiet=new JPanel();
//        ptime=new JPanel();
//        
        ppres.setLayout(null);
        padmit.setLayout(null);
        pdisch.setLayout(null);
        pdiet.setLayout(null);
//        ptime.setLayout(null);
//        
//    JLabel pres_pid, pres_pname, pres_medname, pres_medtime;
//    JTextField pres_tfid, pres_tfname, pres_tfmedname, pres_tfmedtime;
//    Prescription Panel
        pres_pid=new JLabel("Registration ID"); pres_pid.setForeground(Color.blue); pres_pid.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_pname=new JLabel("Patient Name");  pres_pname.setForeground(Color.blue); pres_pname.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_medname=new JLabel("Medicine Name"); pres_medname.setForeground(Color.blue); pres_medname.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_medtime=new JLabel("Medicine Time"); pres_medtime.setForeground(Color.blue); pres_medtime.setFont(new java.awt.Font("Times New Roman",3,16));
        pres_quant=new JLabel("Quantity per 1time"); pres_quant.setForeground(Color.blue); pres_quant.setFont(new java.awt.Font("Times New Roman",3,16));
       
        pres_pid.setBounds(50,50,200,20); 
        pres_pname.setBounds(50,80,200,20);
        pres_medname.setBounds(50,110,200,20);
        pres_medtime.setBounds(50,140,200,20);
        pres_quant.setBounds(50,170,200,20);

        pres_tfid=new JTextField();
        pres_tfname=new JTextField();
        pres_tfmedname=new JTextField();
        pres_tfmedtime=new JTextField();
        pres_tfquant=new JTextField();
     
        pres_tfid.setBounds(250,50,200,20);   pres_tfid.setEditable(false);
        pres_tfname.setBounds(250,80,200,20);  pres_tfname.setEditable(false);
        pres_tfmedname.setBounds(250,110,200,20); 
        pres_tfmedtime.setBounds(250,140,200,20); 
        pres_tfquant.setBounds(250,170,200,20);

        ppres.add(pres_pid);
        ppres.add(pres_pname);
        ppres.add(pres_medname);
        ppres.add(pres_medtime);
        ppres.add(pres_quant);
        
        ppres.add(pres_tfid);
        ppres.add(pres_tfname);
        ppres.add(pres_tfmedname);
        ppres.add(pres_tfmedtime);
        ppres.add(pres_tfquant);
        ppres.add( pres_add);
        ppres.add(pres_addagn);
        pres_add.setBounds(250,200,100,30);
        pres_addagn.setBounds(250,250,250,30);
        pres_add.addActionListener((ActionListener)this);
        pres_addagn.addActionListener((ActionListener)this);
       
        
    
//    JLabel admit_id, admt_name,admit_addr,admit_admiton,admit_room,admit_guardian, admit_relation,admit_contact; 
//    JTextField admit_tfid, admit_tfname,admit_tfaddr,admit_tfadmiton,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
//    JLabel chkid,chkname,chkaddr,chkadmiton,chkroom,chkguardian,chkrelation,chkcontact;
      
        //ADMIT PATEINTS PANEL TO KNOW THE  DETAILS OF PATEINT
        admit_id=new JLabel("Registration ID");
        admit_name=new JLabel("Patient Name");
        admit_disease=new JLabel("Disease");
        admit_addr=new JLabel("Address");
        admit_admiton=new JLabel("Admit On");
        admit_room=new JLabel("Room No");
        admit_guardian=new JLabel("Guardian Name");
        admit_relation=new JLabel("Guardian Relation");
        admit_contact=new JLabel("Contact No.");
        admit_dr=new JLabel("Doctor name ");
//        admit_day=new JComboBox();
//         admit_day.setModel(new DefaultComboBoxModel(new String[]{"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
//         admit_month=new JComboBox();
//         admit_month.setModel(new DefaultComboBoxModel(new String[]{"month","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"}));
//         admit_year=new JComboBox(); 
//         admit_year.setModel(new DefaultComboBoxModel(new String[]{"year","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006",}));
//         
        admit_tfid=new JTextField();  admit_tfid.setEditable(false);
        admit_tfname=new JTextField();  admit_tfname.setEditable(false);
        admit_tfdr=new JTextField();  admit_tfdr.setEditable(false);
        admit_tfaddr=new JTextField();  admit_tfaddr.setEditable(false);
        admit_tfdisease=new JTextField();   admit_tfdisease.setEditable(false);
        admit_tfroom=new JTextField();      admit_tfroom.setEditable(false);
        admit_tfguardian=new JTextField();  admit_tfguardian.setEditable(false);
        admit_tfrelation=new JTextField();  admit_tfrelation.setEditable(false);
        admit_tfcontact=new JTextField();   admit_tfcontact.setEditable(false);
        admit_tfadmiton=new JTextField();   admit_tfadmiton.setEditable(false);
       
          
        admit_chkid=new JLabel(""); 
        admit_chkname=new JLabel(""); 
        admit_chkaddr=new JLabel("");
        admit_chkdisease=new JLabel("");
        admit_chkadmiton=new JLabel("");
        admit_chkroom =new JLabel("");
        admit_chkrelation=new  JLabel("");
        admit_chkguardian=new JLabel("");
        admit_chkcontact=new JLabel("");
        
      
        admit_id.setBounds(50,50,200,20);    admit_id.setForeground(Color.blue);  admit_id.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_name.setBounds(50,80,200,20); admit_name.setForeground(Color.blue);  admit_name.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_dr.setBounds(50,110,200,20);    admit_dr.setForeground(Color.blue);  admit_dr.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_disease.setBounds(50,140,200,20); admit_disease.setForeground(Color.blue);  admit_disease.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_addr.setBounds(50,170,200,20);    admit_addr.setForeground(Color.blue);  admit_addr.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_admiton.setBounds(50,200,200,20); admit_admiton.setForeground(Color.blue);  admit_admiton.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_room.setBounds(50,230,200,20);    admit_room.setForeground(Color.blue);  admit_room.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_guardian.setBounds(50,260,200,20);    admit_guardian.setForeground(Color.blue);  admit_guardian.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_relation.setBounds(50,290,200,20);    admit_relation.setForeground(Color.blue);  admit_relation.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_contact.setBounds(50,320,200,20);     admit_contact.setForeground(Color.blue);  admit_contact.setFont(new java.awt.Font("Times New Roman",3,16));
        
        admit_tfid.setBounds(250,50,200,20);
        admit_tfname.setBounds(250,80,200,20);
        admit_tfdr.setBounds(250,110,200,20);
        admit_tfdisease.setBounds(250, 140, 200, 20);
        admit_tfaddr.setBounds(250,170,200,20);
        admit_tfadmiton.setBounds(250,200,200,20);
//        admit_day.setBounds(250,200,60,20);	admit_month.setBounds(320,200,100,20);	admit_year.setBounds(430,200,70,20);	
//        
        admit_tfroom.setBounds(250,230,200,20);
        admit_tfguardian.setBounds(250,260,200,20);
        admit_tfrelation.setBounds(250,290,200,20);
        admit_tfcontact.setBounds(250,320,200,20);        

        admit_chkid.setBounds(500,50,200,20);   admit_chkid.setForeground(Color.RED);  admit_chkid.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkname.setBounds(500,80,200,20);   admit_chkname.setForeground(Color.RED); admit_chkname.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkdisease.setBounds(500,140,200,20);   admit_chkdisease.setForeground(Color.RED);   admit_chkdisease.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkaddr.setBounds(500,170,200,20);   admit_chkaddr.setForeground(Color.RED);   admit_chkaddr.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkadmiton.setBounds(500,200,200,20);    admit_chkadmiton.setForeground(Color.RED);  admit_chkadmiton.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkroom.setBounds(500,200,230,20);    admit_chkroom.setForeground(Color.RED);    admit_chkroom.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkguardian.setBounds(500,260,200,20);    admit_chkguardian.setForeground(Color.RED);    admit_chkguardian.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkrelation.setBounds(500,290,400,20);   admit_chkrelation.setForeground(Color.RED);     admit_chkrelation.setFont(new java.awt.Font("Times New Roman",3,16));
        admit_chkcontact.setBounds(500,320,200,20);   admit_chkcontact.setForeground(Color.RED);   admit_chkcontact.setFont(new java.awt.Font("Times New Roman",3,16));

        
        padmit.add(admit_id);
        padmit.add(admit_name);
        padmit.add(admit_dr);
        padmit.add(admit_disease);
        padmit.add(admit_addr);
        padmit.add(admit_admiton);
        padmit.add(admit_room);
        padmit.add(admit_guardian);
        padmit.add(admit_relation);
        padmit.add(admit_contact);
        
        padmit.add(admit_tfid);
        padmit.add(admit_tfdr);
        padmit.add(admit_tfname);
        padmit.add(admit_tfdisease);
        padmit.add(admit_tfaddr);
        padmit.add(admit_tfadmiton);
        padmit.add(admit_tfroom);
        padmit.add(admit_tfguardian);
        padmit.add(admit_tfrelation);
        padmit.add(admit_tfcontact);
        
//        padmit.add(admit_day);
//        padmit.add(admit_month);
//        padmit.add(admit_year);
//        
        padmit.add(admit_chkid);
        padmit.add(admit_chkname);
        padmit.add(admit_chkdisease);
        padmit.add(admit_chkaddr);
        padmit.add(admit_chkadmiton);
        padmit.add(admit_chkroom);
        padmit.add(admit_chkrelation);
        padmit.add(admit_chkguardian);
        padmit.add(admit_chkcontact);
        
        admit_tfid.addActionListener((ActionListener)this);     admit_tfid.addFocusListener((FocusListener)this);         
        admit_tfname.addActionListener((ActionListener)this);   admit_tfname.addFocusListener((FocusListener)this);
        admit_tfdr.addActionListener((ActionListener)this);   admit_tfdr.addFocusListener((FocusListener)this);
        admit_tfdisease.addActionListener((ActionListener)this);   admit_tfdisease.addFocusListener((FocusListener)this);
        admit_tfaddr.addActionListener((ActionListener)this);   admit_tfaddr.addFocusListener((FocusListener)this);
       admit_tfadmiton.addActionListener((ActionListener)this);    admit_tfadmiton.addFocusListener((FocusListener)this);
        admit_tfroom.addActionListener((ActionListener)this);   admit_tfroom.addFocusListener((FocusListener)this);
        admit_tfguardian.addActionListener((ActionListener)this);   admit_tfguardian.addFocusListener((FocusListener)this);
        admit_tfrelation.addActionListener((ActionListener)this);   admit_tfrelation.addFocusListener((FocusListener)this);
        admit_tfcontact.addActionListener((ActionListener)this);    admit_tfcontact.addFocusListener((FocusListener)this);
//        admit_day.addFocusListener((FocusListener)this);admit_day.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        admit_month.addFocusListener((FocusListener)this);admit_month.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        admit_year.addFocusListener((FocusListener)this);admit_year.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//         
// JLabel disch_name,disch_id, disch_dr,disch_addr, disch_admit,disch_dis, disch_dischargedon,disch_contact,disch_remark;
// JTextField disch_tfname,disch_tfid,disch_tfdr, disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;
// JButton disch_ok,disch_gnrprt;
// JTextArea disch_taremark;
 
//      DISCHARGE PORTAL
   
        disch_name=new JLabel("Patient Name");
        disch_id=new JLabel("Registration ID");
        disch_dr=new JLabel("Doctor Name");
        disch_addr=new JLabel("Address");
        disch_admit=new JLabel("Admitted On");
        disch_dis=new JLabel("Disease");
        disch_dischargedon=new JLabel("Discharged On");
        disch_contact=new JLabel("Contact No.");
        disch_remark=new JLabel("Remarks");
        
        disch_ok=new JButton("CONFIRMED");
        disch_gnrprt=new JButton("GENERATE REPORT");

        disch_tfid=new JTextField();  disch_tfid.setEditable(false);
        disch_tfname=new JTextField();  disch_tfname.setEditable(false);
        disch_tfdr=new JTextField();    disch_tfdr.setEditable(false);
        disch_tfaddr=new JTextField();  disch_tfaddr.setEditable(false);
        disch_tfadmit=new JTextField(); disch_tfadmit.setEditable(false);
        disch_tfdis=new JTextField();   disch_tfdis.setEditable(false);
        disch_tfdischargedon=new JTextField();      disch_tfdischargedon.setEditable(false);
        disch_tfcontact=new JTextField();       disch_tfcontact.setEditable(false);
        disch_taremark=new JTextArea();     disch_taremark.setEditable(true);
        
        // JLabel disch_name,disch_id, disch_dr,disch_addr, disch_admit,disch_dis, disch_dischargedon,disch_contact,disch_remark;
// JTextField disch_tfname,disch_tfid,disch_tfdr, disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;

        disch_name.setBounds(50,50,200,20);
        disch_id.setBounds(50,80,200,20);
        disch_dr.setBounds(50,110,200,20);
        disch_addr.setBounds(50,140,200,20);
        disch_admit.setBounds(50,170,200,20);
        disch_dis.setBounds(50,200,200,20);
        disch_dischargedon.setBounds(50,230,200,20);
        disch_contact.setBounds(50,260,200,20);
        disch_remark.setBounds(50,290,200,20);
        
        disch_ok.setBounds(250,320,150,30);
        disch_gnrprt.setBounds(500,320,200,30);
        disch_ok.setForeground(Color.blue);   disch_ok.setFont(new java.awt.Font("Times New Roman",3,13));
        disch_gnrprt.setForeground(Color.blue); disch_gnrprt.setFont(new java.awt.Font("Times New Roman",3,13));
       
// ,disch_tfdr, disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;

        disch_tfname.setBounds(250,50,200,20);
        disch_tfid.setBounds(250,80,200,20);
        disch_tfdr.setBounds(250,110,200,20);
        disch_tfaddr.setBounds(250,140,200,20);
        disch_tfadmit.setBounds(250,170,200,20);
        disch_tfdis.setBounds(250,200,200,20);
        disch_tfdischargedon.setBounds(250,230,200,20);
        disch_tfcontact.setBounds(250,260,200,20);
        disch_taremark.setBounds(250,290,200,30);
        
        //JLabel disch_name,disch_id, disch_dr,disch_addr, disch_admit,disch_dis, disch_dischargedon,disch_contact,disch_remark;
// JTextField disch_tfname,disch_tfid,disch_tfdr, disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;
// JButton disch_ok,disch_gnrprt;
// JTextArea disch_taremark;
 
        pdisch.add(disch_id);
        pdisch.add(disch_name);
        pdisch.add(disch_dr);
        pdisch.add(disch_addr);
        pdisch.add(disch_admit);
        pdisch.add(disch_dis);
        pdisch.add(disch_dischargedon);
        pdisch.add(disch_contact);
        pdisch.add(disch_remark);
        pdisch.add(disch_ok);
        pdisch.add(disch_gnrprt);
        disch_ok.addActionListener(this);
        disch_gnrprt.addActionListener(this);
        
        // JTextField disch_tfname,disch_tfid,disch_tfdr, disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;
// JButton disch_ok,disch_gnrprt;
// JTextArea disch_taremark;

        pdisch.add(disch_tfid);
        pdisch.add(disch_tfname);
        pdisch.add(disch_tfdr);
        pdisch.add(disch_tfaddr);
        pdisch.add(disch_tfadmit);
        pdisch.add(disch_tfdis);
        pdisch.add(disch_tfdischargedon);
        pdisch.add(disch_tfcontact);
        pdisch.add(disch_taremark);
        
 
//    JLabel diet_id, diet_name, diet_food, diet_time ;
//    JTextField diet_tfid, diet_tfname, diet_tffood, diet_tftime ;
//  DIET CHART OF  THE PATEINT
        diet_id=new JLabel("Registration ID");
        diet_name=new JLabel("Patient Name");
        diet_bcheck=new JButton("CHECK");
        diet_tfid=new JTextField();
        diet_tfname=new JTextField();
        
        diet_id.setBounds(50,50,200,20);
        diet_name.setBounds(50,80,200,20);
        
        diet_tfid.setBounds(250,50,200,20);
        diet_tfname.setBounds(250,80,200,20);
        diet_bcheck.setBounds(250,130,200,20);
        
        pdiet.add(diet_id);
        pdiet.add(diet_name);
        pdiet.add(diet_bcheck);
        
        pdiet.add(diet_tfid);
        pdiet.add(diet_tfname);
        diet_bcheck.addActionListener((ActionListener)this);    diet_bcheck.addFocusListener((FocusListener)this);

        lbck.add(ppres);
        lbck.add(padmit);
        lbck.add(pdisch);
        lbck.add(pdiet);
//        lbck.add(ptime);

        ppres.setBounds(50,180,1350,550);
        padmit.setBounds(50,180,1350,550);
        pdisch.setBounds(50,180,1350,550);
        pdiet.setBounds(50,180,1350,550);
//        ptime.setBounds(50,180,1350,550);
        
        ppres.setBackground(Color.white);
        padmit.setBackground(Color.white);
        pdisch.setBackground(Color.white);
        pdiet.setBackground(Color.white);
//        ptime.setBackground(Color.white);
        
        ppres.setVisible(false);
        padmit.setVisible(false);
        pdisch.setVisible(false);
        pdiet.setVisible(false);
//        ptime.setVisible(false);
//        
//        //// now each pannel
      //RETRIVING DATA OF THE ADMIT PATEINTS
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
              admit_tfid.setText("R00"+String.valueOf(row+1));
          }
          
          else if((row>=9)||(row<=98))
          {
              admit_tfid.setText("R0"+String.valueOf(row+1));
          }
          else if((row>=99))//||row<=999)
          {
              admit_tfid.setText("R"+String.valueOf(row+1));
          }
              
      }
      catch(Exception f)
      {
        System.out.println("catched auto gen error = "+f.getMessage());
      }
  } 
    
    //ACTIONS TO BE PERFORMED ON THE VARIOUS BUTTONS
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object o=e.getSource();
        if(o==bpres)
        {
            ppres.setVisible(true);
            padmit.setVisible(false);
            pdisch.setVisible(false);
            pdiet.setVisible(false);
//            ptime.setVisible(false);
            
            try
            {   
                String patientId=getSelectedPatient();
                pres_tfid.setText(patientId);
                connect c=new connect();               
                Statement st;
                st=c.con.createStatement();
                ResultSet res=st.executeQuery("select * from newpat where registrationno='"+patientId+"'"); 
                while(res.next()){
                //System.out.println("hel");
                //System.out.println("hel"+res.getString(2));
                pres_tfname.setText(res.getString(2));
                }
            }
            catch(Exception ex)
            {
            System.out.println("Exception catched by me = "+ex.getMessage());
            }    
        }
        if(o==badmit)
        {
            ppres.setVisible(false);
            padmit.setVisible(true);
            pdisch.setVisible(false);
            pdiet.setVisible(false);
//            ptime.setVisible(false);
            
//             d=admit_day.getSelectedItem().toString();
//                           m=admit_month.getSelectedItem().toString();                
//                           y=admit_year.getSelectedItem().toString(); 
//                           date=d+"/"+m+"/"+y;
//                            //if((tname.getText().length()==0)||(taddr.getText().length()==0)||(tcourse.getSelectedItem().toString()=="Course")||(troll.getText().length()==0)||(teid.getText().length()==0)||(tcont.getText().length()==0)||(tusr.getText().length()==0)||(day.getSelectedItem()==null)||(month.getSelectedItem()==null)||(year.getSelectedItem()==null)||(acreate.getText()=="Password Mismatch"))
//                                 {//System.out.println("invalid data ");
//                              //    err.setText("please fill all blocks .");
//                                 }
//                                // else{         
                          
            try
            {   
                String patientId=getSelectedPatient();
                admit_tfid.setText(patientId);
                connect c=new connect();               
                Statement st;
                st=c.con.createStatement();
                ResultSet res=st.executeQuery("select * from newpat where registrationno='"+patientId+"'"); 
                while(res.next()){
                //System.out.println("hel");
                //System.out.println("hel"+res.getString(2));
       // JTextField admit_tfid, admit_tfname,admit_tfaddr,admit_tfadmiton,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
//id,name,dis,add,admton,rmno.grdnname,grdnrel,cont
                admit_tfname.setText(res.getString(2));
                admit_tfdr.setText(res.getString(3));
                admit_tfdisease.setText(res.getString(4));
                admit_tfaddr.setText(res.getString(5));
                // ps.setString(3,tcourse.getSelectedItem().toString());
                             
                admit_tfadmiton.setText(res.getString(6));
                admit_tfroom.setText(res.getString(7));
                admit_tfguardian.setText(res.getString(8));
                admit_tfrelation.setText(res.getString(9));
                admit_tfcontact.setText(res.getString(10));
              }
            }
            catch(Exception ex)
            {
            System.out.println("Exception catched by me = "+ex.getMessage());
            }
           
        }
      
        
     if(o==pres_add)
     {
//         pres_tfmedname.setText("");
//         pres_tfquant.setText("");
//         pres_tfmedtime.setText("");         
     try
            {
                connect c=new connect();               
                PreparedStatement ps;
                ps=c.con.prepareStatement("insert into prescription values(?,?,?,?,?)");
                // pres_tfid, pres_tfname, pres_tfmedname
                ps.setString(1,pres_tfid.getText());
                ps.setString(2,pres_tfname.getText());
                ps.setString(3,pres_tfmedname.getText());
                ps.setString(4,pres_tfquant.getText());
                ps.setString(5,pres_tfmedtime.getText());
                
                
                int i=ps.executeUpdate();
                if(i==1)
                {
                                JOptionPane.showMessageDialog(this,"Prescription Added");

//                   System.out.println("record inserted");
                }
            }
            catch(Exception ex)
            {
            System.out.println("Exception = "+ex.getMessage());
            }
     
         pres_tfmedname.setText("");
         pres_tfquant.setText("");
         pres_tfmedtime.setText("");
         
     }
      if(o==pres_addagn)
        {
            ppres.setVisible(false);
            padmit.setVisible(false);
           pdisch.setVisible(false);
            pdiet.setVisible(false);
////          
            prescription p=new prescription();
           // p.setBounds(590,220,696,546 );
        p.setBounds(50,230,1350,550);
        }
        
        if(o==bdisch)
        {
            ppres.setVisible(false);
            padmit.setVisible(false);
            pdisch.setVisible(true);
            pdiet.setVisible(false);
////          
//            discharge d=new discharge();
//            d.setResizable(false);
//        //    d.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
//            d.setBounds(50,220,1350,590);
////            ppres.setVisible(false);
//            padmit.setVisible(false);
//            pdisch.setVisible(true);
//            pdiet.setVisible(false);
////            ptime.setVisible(false);
            try
            {   
                String patientId=getSelectedPatient();
                disch_tfid.setText(patientId);
                connect c=new connect();               
                Statement st;
                st=c.con.createStatement();
                ResultSet res=st.executeQuery("select * from newpat where registrationno='"+patientId+"'"); 
                while(res.next()){
                //System.out.println("hel");
                //System.out.println("hel"+res.getString(2));
//  disch_tfaddr, disch_tfadmit,disch_tfdis, disch_tfdischargedon,disch_tfcontact;
                disch_tfname.setText(res.getString(2));
                disch_tfdr.setText(res.getString(3));
                disch_tfaddr.setText(res.getString(4));
                disch_tfadmit.setText(res.getString(5));
                disch_tfdis.setText(res.getString(6));
                disch_tfdischargedon.setText(res.getString(7));
                disch_tfcontact.setText(res.getString(8));
                
                }
            }
            catch(Exception ex)
            {
            System.out.println("Exception catched by me = "+ex.getMessage());
            }  
        }
        
        if(o==bdiet)
        {
            DietChart dc=new DietChart();
            dc.setBounds(50,250,1350,550);
            ppres.setVisible(false);
            padmit.setVisible(false);
            pdisch.setVisible(false);
//            pdiet.setVisible(true);
//            ptime.setVisible(false);
//           try
//            {   
//                String patientId=getSelectedPatient();
//                diet_tfid.setText(patientId);
//                connect c=new connect();               
//                Statement st;
//                st=c.con.createStatement();
//                ResultSet res=st.executeQuery("select * from newpat where registrationno='"+patientId+"'"); 
//                while(res.next()){
//                //System.out.println("hel");
//                //System.out.println("hel"+res.getString(2));
//                   // JTextField disch_tfid, disch_tfname, disch_tfaddr, disch_tfadmit, disch_tfdischargedon,disch_tfcontact;
//
//                diet_tfname.setText(res.getString(2));
//                }
//            }
//            catch(Exception ex)
//            {
//            System.out.println("Exception catched by me = "+ex.getMessage());
//            } 
        }
//        if(o==btime)
//        {
//            ppres.setVisible(false);
//            padmit.setVisible(false);
//            pdisch.setVisible(false);
//            pdiet.setVisible(false);
////            ptime.setVisible(true);
//            try
//            {
//                String patientId=getSelectedPatient();
//                pres_tfid.setText(patientId);
//            }
//            catch(Exception ex)
//            {
//            
//            }
//           
//        }
        
        if(o==blogout)
        {
            FirstPage fp=new FirstPage();
            setVisible(false);
        }
        if(o==diet_bcheck)
        {
            //dietChart dc=new dietChart();
            setVisible(false);
        }
    
       if(o==disch_ok)
       {
            try
            { 
                String patientId=getSelectedPatient();
            connect c=new connect();               
                PreparedStatement ps;
                ps=c.con.prepareStatement("delete from  newpat where registrationno='"+patientId+"'");
                // pres_tfid, pres_tfname, pres_tfmedname
//                ps.setString(1,p_tfid.getText());
//                ps.setString(2,pres_tfname.getText());
//                ps.setString(3,pres_tfmedname.getText());
//                ps.setString(4,(String) pres_tfmedtime.getSelectedItem());
//                
                int i=ps.executeUpdate();
                if(i==1)
                {
                   System.out.println("record inserted");
                }
            }
            catch(Exception ex)
            {
            System.out.println("Exception = "+ex.getMessage());
            }
   
       }
       if(o==disch_gnrprt)
       {
           discharge d=new discharge();
//           setVisible(true);
       }
    }
    
    
      @Override
        public void focusLost(FocusEvent e) 
    {
     Object o=e.getSource();
     
                     if(o==admit_tfid)
                     {
                         if(admit_tfid.getText().length()==0)
                         {
                         admit_chkid.setText("!Enter Registration number");
                         }
                     }
                     if(o==admit_tfname) 
                          {
                                 if(admit_tfname.getText().length()<=2)
                                 {
                                     admit_chkname.setText("Enter Patient name");
                                 }                        
                                 else{admit_chkname.setText("");}
                        }
                     if(o==admit_tfdisease) 
                          {
                            if(admit_tfdisease.getText().length()==0)
                                {admit_chkdisease.setText("!Enter disease name");
                               // tfname.requestFocus();
                                } 
                            else{admit_chkdisease.setText("");}
                        }

                    if(o==admit_tfaddr)
                    {
                        if(admit_tfaddr.getText().length()==0)
                        {
                            admit_chkaddr.setText("!Enter your address");
                        }
                        else
                        {
                            admit_chkaddr.setText("");
                        }
                    }
                     
                     if(o==admit_tfadmiton)
                     { if(admit_tfadmiton.getText().length()==0)
                         {
                             admit_chkadmiton.setText("!Enter date admitted ");
                             //tfdtadm.requestFocus();
                         }
                         else
                             admit_chkadmiton.setText("");
                     }
                     if(o==admit_tfroom)
                     {
                         if(admit_tfroom.getText().length()==0)
                         {admit_chkroom.setText("!Enter room no");
                         //tfrmno.requestFocus();}
                         }else
                             admit_chkroom.setText("");
                     }
                     if(o==admit_tfguardian)
                     {if(admit_tfguardian.getText().length()==0)
                         {
                             admit_chkguardian.setText("!Enter guardian name ");
                             //tagrd.requestFocus();
                         }
                         else
                             admit_chkguardian.setText("");
                     }
                     
                     if(o==admit_tfrelation)
                     {
                     if(admit_tfrelation.getText().length()==0)
                         {
                             admit_chkrelation.setText("!Enter relation with guardian ");
                             //tagrd.requestFocus();
                         }
                         else
                             admit_chkrelation.setText("");
                     
                     }
                     if(o==admit_tfcontact)
                     { 
                          if((admit_tfcontact.getText().length()>10)||(admit_tfcontact.getText().length()<10))
         {admit_chkcontact.setText("! Enter your 24-hr available Contact");}
                     }
    }

//    JLabel admit_id, admt_name,admit_addr,admit_admiton,admit_room,admit_guardian, admit_relation,admit_contact; 
//    JTextField admit_tfid,admit_tfaddr,admit_tfadmiton,admit_tfroom,admit_tfguardian, admit_tfrelation,admit_tfcontact; 
//    JLabel chkid,chkaddr,chkadmiton,chkroom,chkguardian,chkrelation,chkcontact;
    
    public void keyTyped(KeyEvent e) 
    {
     Object o=e.getSource();
	if(o==admit_tfname)
	{	char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		//e.getToolkit.beep();
		admit_chkname.setText("! Enter characters only .");
		//altname.setForeground(new Color(204,0,0));
		}
		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		admit_chkname.setText("");
		}
	}
        if(o==admit_tfdisease)
        {}
        if(o==admit_tfaddr)
                {}
        if(o==admit_tfadmiton)
        {}
       if(o==admit_tfroom)
        {
        char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		admit_chkroom.setText("! Enter no. of years only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		admit_chkroom.setText("");
		}
	}
       if(o==admit_tfguardian)
       {}
       if(o==admit_tfrelation)
       {}
     if(o==admit_tfcontact)
     {
          char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		admit_chkcontact.setText("! Enter valid number only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		admit_chkcontact.setText("");
		}
     }
  }  
  
    public String getSelectedPatient()
    {
        String selectedPatient=cslctpat.getSelectedItem().toString();
        String pID=null;//, pName=null;
        pID=selectedPatient.substring(0,4);
//        System.out.println("selected patient = "+pID);
        return pID;
    }
    
    public static void main(String args[])
    {
        DocterPortal dp=new DocterPortal("userid","doctor ");
    }

    @Override
    public void focusGained(FocusEvent e) {}
    public void windowClosing(WindowEvent e)
      {  

          DocterPortal dp=new DocterPortal("userid","static ");
//            int a=JOptionPane.showConfirmDialog(this,"Are you sure to exit?");  
//            if(a==JOptionPane.YES_OPTION)
//            {  
//                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//            }
          }
          public void windowDeactivated(WindowEvent e)
          {
          }
          public void windowActivated(WindowEvent e)
          {
          }
          public void windowDeiconified(WindowEvent e)
          {
          }
          public void windowIconified(WindowEvent e)
          {
          }
          public void windowClosed(WindowEvent e)
          {          DocterPortal dp=new DocterPortal("userid","static ");

          }
          public void windowOpened(WindowEvent e)
          {
          }
}