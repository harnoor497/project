///submit button to tackle and SAVE and RETRIVE DATA in the database
//change font and color and DATE retriving !!!
package pateintreport;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewPatEntry extends JFrame implements ActionListener , WindowListener ,MouseListener,FocusListener,KeyListener
{
    JPanel p;
        JOptionPane msg;
        JLabel lreg,lnew,lname,lrm,ldr,ldis,ldtadm,ladd,lcont,lgrd,limg;
        JLabel chkreg,chkname,chkrm,chkdr,chkdis,chkdtadm,chkadd,chkcont,chkgrd;
        JButton submit,cancel,reset;
        JTextField tfreg,tfname,tfrmno,tfdr,tfdis,tfdtadm,tfcont;
        JTextArea taadd,tagrd;

    NewPatEntry()
    {
        
        p=new JPanel();
        limg=new JLabel();//new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/chknurse.jpg"));
        lreg=new JLabel("Registration No.");
        lnew=new JLabel("New Register");
        lname=new JLabel("Name");
        lrm=new JLabel("Room No.");
        ldr=new JLabel("Docter");
        ldis=new JLabel("Diesease");
        ldtadm=new JLabel("Date Admitted");
        //ldtdis=new JLabel("Date Discharged");
        ladd=new JLabel("Address");
        lcont=new JLabel("Contact No.");
        lgrd=new JLabel("Guardian");
        
        chkreg=new JLabel(); chkname=new JLabel();   chkrm=new JLabel(); chkdr=new JLabel(); chkdis=new  JLabel(); chkdtadm=new JLabel();
        //chkdtdis=new JLabel();
        chkadd=new JLabel(); chkcont=new JLabel(); chkgrd=new JLabel();
        
        tfreg=new JTextField(); tfreg.addFocusListener((FocusListener)this);
        tfname=new JTextField(); tfname.addFocusListener((FocusListener)this);
        tfrmno=new JTextField();    tfrmno.addFocusListener((FocusListener)this);
        tfdr=new JTextField();      tfdr.addFocusListener((FocusListener)this);
        tfdis=new JTextField();         tfdis.addFocusListener((FocusListener)this);
        tfdtadm=new JTextField();   tfdtadm.addFocusListener((FocusListener)this);
       // tfdtdis=new JTextField();       tfdtdis.addFocusListener((FocusListener)this);
        tfcont=new JTextField();        tfcont.addFocusListener((FocusListener)this);
        taadd=new JTextArea();      taadd.addFocusListener((FocusListener)this);
        tagrd=new JTextArea();      tagrd.addFocusListener((FocusListener)this);
        submit=new JButton("Submit");
        submit.setFont(new java.awt.Font("Futura", 1, 18)); submit.setForeground(Color.blue); submit.addMouseListener((MouseListener)this);
        cancel=new JButton("Cancel");
        cancel.setFont(new java.awt.Font("Futura", 1, 18)); cancel.setForeground(Color.blue); cancel.addMouseListener((MouseListener)this);
        reset=new JButton();
        reset.setFont(new java.awt.Font("Futura", 1, 18)); reset.setForeground(Color.blue); reset.addMouseListener((MouseListener)this);

        msg=new JOptionPane();
        msg.setSize(300,300);
        submit.addActionListener((ActionListener)this);
        cancel.addActionListener((ActionListener)this);
        
        lnew.setBounds(1000,50,250,30);    lnew.setFont(new java.awt.Font("Futura",1,23));         //lnew.setForeground( new Color(238,238,238));
       
        lreg.setBounds(845,104,200,35);       lreg.setFont(new java.awt.Font("Farisi",1,18));
        lname.setBounds(845,154,200,35);        lname.setFont(new java.awt.Font("Farisi",1,18));
        lrm.setBounds(845,204,200,35);        lrm.setFont(new java.awt.Font("Farisi",1,18));
        ldr.setBounds(845,254,200,35);       ldr.setFont(new java.awt.Font("Farisi",1,18));
        ldis.setBounds(845,304,200,35);              ldis.setFont(new java.awt.Font("Farisi",1,18));
        ldtadm.setBounds(845,354,200,35);         ldtadm.setFont(new java.awt.Font("Farisi",1,18));
       // ldtdis.setBounds(845,404,200,35);        ldtdis.setFont(new java.awt.Font("Farisi",1,18));
        ladd.setBounds(845,454,200,35);        ladd.setFont(new java.awt.Font("Farisi",1,18));      
        lcont.setBounds(845,534,200,35);        lcont.setFont(new java.awt.Font("Farisi",1,18));
        lgrd.setBounds(845,588,200,35);        lgrd.setFont(new java.awt.Font("Farisi",1,18));
       
        tfreg.setBounds(1000,100,210,35);   tfreg.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));  tfreg.setBackground(new Color(238,238,238));    
        tfname.setBounds(1000,150,210,35);  tfname.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tfname.setBackground(new Color(238,238,238));
        tfrmno.setBounds(1000,200,210,35);  tfrmno.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tfrmno.setBackground(new Color(238,238,238));
        tfdr.setBounds(1000,250,210,35);    tfdr.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tfdr.setBackground(new Color(238,238,238));
        tfdis.setBounds(1000,300,210,35);   tfdis.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tfdis.setBackground(new Color(238,238,238));
        tfdtadm.setBounds(1000,350,210,35); tfdtadm.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tfdtadm.setBackground(new Color(238,238,238));
       // tfdtdis.setBounds(1000,400,210,35); tfdtdis.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tfdtdis.setBackground(new Color(238,238,238));
        taadd.setBounds(1000,455,210,55);   taadd.setLineWrap(true);    taadd.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); taadd.setBackground(new Color(238,238,238));
        tfcont.setBounds(1000,530,210,35);  tfcont.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));tfcont.setBackground(new Color(238,238,238));
        tagrd.setBounds(1000,578,210,55);   tagrd.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY)); tagrd.setBackground(new Color(238,238,238));
       
        submit.setBounds(1000,700,100,35);     // submit.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        cancel.setBounds(1100,700,100,35);      //cancel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        //reset.setBounds(490,500,160,30);
        
        chkreg.setBounds(588,100,250,30);   chkreg.setForeground(new Color(255,51,51));  chkreg.setFont(new java.awt.Font("Times New Roman",3,18));
        chkname.setBounds(588,150,250,30);   chkname.setForeground(new Color(255,51,51)); chkname.setFont(new java.awt.Font("Times New Roman",3,18));
        chkrm.setBounds(588,200,250,30);   chkrm.setForeground(new Color(255,51,51));   chkrm.setFont(new java.awt.Font("Times New Roman",3,18));
        chkdr.setBounds(588,250,250,30);    chkdr.setForeground(new Color(255,51,51));  chkdr.setFont(new java.awt.Font("Times New Roman",3,18));
        chkdis.setBounds(588,300,250,30);    chkdis.setForeground(new Color(255,51,51));    chkdis.setFont(new java.awt.Font("Times New Roman",3,18));
        chkdtadm.setBounds(588,350,250,30);    chkdtadm.setForeground(new Color(255,51,51));    chkdtadm.setFont(new java.awt.Font("Times New Roman",3,18));
       // chkdtdis.setBounds(588,400,250,30);    chkdtdis.setForeground(new Color(255,51,51));    chkdtdis.setFont(new java.awt.Font("Times New Roman",3,18));
        chkadd.setBounds(588,450,250,30);   chkadd.setForeground(new Color(255,51,51));     chkadd.setFont(new java.awt.Font("Times New Roman",3,18));
        chkcont.setBounds(588,534,250,30);   chkcont.setForeground(new Color(255,51,51));   chkcont.setFont(new java.awt.Font("Times New Roman",3,18));
        chkgrd.setBounds(540,588,300,30);   chkgrd.setForeground(new Color(255,51,51)); chkgrd.setFont(new java.awt.Font("Times New Roman",3,18));

        p.add(limg);
        limg.setBounds(0,0,1440,800);
        limg.add(chkreg);
        limg.add(chkname);
        limg.add(chkrm);
        limg.add(chkdr);
        limg.add(chkdis);
        limg.add(chkdtadm);
      //  limg.add(chkdtdis);
        limg.add(chkadd);
        limg.add(chkcont);
        limg.add(chkgrd);
        limg.add(lreg);
        limg.add(lnew);
        limg.add(lname);
        limg.add(lrm);
        limg.add(ldr);
        limg.add(ldis);
        limg.add(ldtadm);
       // limg.add(ldtdis);
        limg.add(ladd);
        limg.add(lcont);
        limg.add(lgrd);
        limg.add(tfreg);
        limg.add(tfname);
        limg.add(tfrmno);
        limg.add(tfdr);
        limg.add(tfdis);
        limg.add(tfdtadm);
      //  limg.add(tfdtdis);
        limg.add(tfcont);
        limg.add(taadd);
        limg.add(tagrd);
        limg.add(submit);
        limg.add(cancel);
        limg.add(reset);
        
        p.setVisible(true);
        p.setSize(1440,800);
        p.setLayout(null);
        
         int row;
   Connection con;
        try
        {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from newpatentry");
        rs.last();
        row=rs.getRow();
         autogen(row);
        }
        catch(Exception e)
        { }
   
        
        add(p);
        setSize(1440,800);
        setVisible(true);
        setTitle("New Pateint Login");
        setResizable(false);
        addWindowListener((WindowListener)this);
    }
    
         public void addData()
    {
        try
        {
            Connection con;
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");
            PreparedStatement ps;
                  //  JTextField tfreg,tfname,tfrmno,tfdr,tfdis,tfdtadm,tfdtdis,tfcont;
       // JTextArea taadd,tagrd;

                ps=con.prepareStatement("insert into NEWPATENTRY values(?,?,?,?,?,?,?,?,?)"); 
                ps.setString(1,tfreg.getText());
                ps.setString(2,tfname.getText());
                ps.setString(3,tfrmno.getText());
                ps.setString(4,tfdr.getText());
                ps.setString(5,tfdis.getText());
                ps.setString(6,tfdtadm.getText());
             //   ps.setString(7,tfdtdis.getText());
                 ps.setString(7,taadd.getText());
                  ps.setString(8,tfcont.getText());
                   ps.setString(9,tagrd.getText());
                int ret=ps.executeUpdate();
                if(ret==1)
                {
                JOptionPane.showMessageDialog(null,"Ur info is added...","Data Stored", 3);               
                }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Error in code  : "+e.getMessage().toString(),"Error Message", 1);
        }
    }
    
       public void autogen(int row)
  {
      try
      {
          if(row<=8)
          {
              tfreg.setText("R00"+String.valueOf(row+1));
          }
          
          else if((row>=9)||(row<=98))
          {
              tfreg.setText("R0"+String.valueOf(row+1));
          }
          else if((row>=99))//||row<=999)
          {
              tfreg.setText("R"+String.valueOf(row+1));
          }
              
      }
      catch(Exception e)
      {
        System.out.println("catched auto gen error = "+e.getMessage());
      }
  } 

    
    public static void main(String arg[])
    {
        new NewPatEntry();
    }
          public void actionPerformed(ActionEvent e)
        { 
            Object o= e.getSource();
              if(o==submit)
              {
               addData();
              }
              if(o==cancel)
              {
                  NursePortal np=new NursePortal("userid","static method");
              }
              
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
     
      
      public void mouseEntered(MouseEvent e)
        {
        Object o=e.getSource();
        if(o==cancel)
        {  cancel.setForeground(new Color(255,51,51));
          // cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(new java.awt.Color(0,0,0)));
           //cancel.setBackground(new Color(0,0,0));
           cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        if(o==submit)
        { 
                 // submit.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(new java.awt.Color(0,0,0)));
                  submit.setForeground(new Color(0,204,0));  
                  //submit.setBackground(new Color(0,0,0));
                  submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));   
        }
       /* if(o==reset)
        {  reset.setForeground(Color.WHITE);
           reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
           reset.setBackground(new Color(1,191,224));
           reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }*/
        }  
	@Override
	public void mouseExited(MouseEvent e)
        {
        
        Object o=e.getSource();
        if(o==cancel)
        {
           cancel.setBackground(new Color(204,0,0));
           cancel.setForeground(Color.BLUE);
           //cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(Color.LIGHT_GRAY));
         
        }
       /* if(o==reset)
        { // reset.setBounds(400,660,150,20);
           reset.setBackground(null);
           reset.setForeground(Color.BLACK);
           reset.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
         
        }*/
        if(o==submit)
        {
        submit.setBackground(new Color(204,0,0));
        submit.setForeground(Color.BLUE);
        //submit.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(Color.LIGHT_GRAY));
        }   
        }
        @Override
	public void mousePressed(MouseEvent e) {}  
        @Override
	public void mouseReleased(MouseEvent e){} 

    @Override
    public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) 
    {
     Object o=e.getSource();
                     if(o==tfreg)
                     {
                         if(tfreg.getText().length()==0)
                         {
                         chkreg.setText("!Enter Registration number");
                         }
                     }
                     if(o==tfname) 
                          {
                            if(tfname.getText().length()==0)
                                {chkname.setText("!Enter name");
                               // tfname.requestFocus();
                                } 
                            else{chkname.setText("");}
                        }
                     if(o==tfrmno)
                     {
                         if(tfrmno.getText().length()==0)
                         {chkrm.setText("!Enter room no");
                         //tfrmno.requestFocus();}
                         }else
                             chkrm.setText("");
                     }
                     if(o==tfdr)
                     {
                         if(tfdr.getText().length()==0)
                         {
                             chkdr.setText("!Enter dr name");
                             //tfdr.requestFocus();
                         }
                         else
                             chkdr.setText("");
                     }
                     if(o==tfdis)
                     {
                          if(tfdis.getText().length()==0)
                         {
                             chkdis.setText("!Enter disease");
                             //tfdis.requestFocus();
                         }
                         else
                             chkdis.setText("");
                     }
                                          //tfname,tfrmno,tfdr,tfdis,tfdtadm,tfdtdis,tfcont;
                     //chkname,chkrm,chkdr,chkdis,chkdtadm,chkdtdis,chkadd,chkcont,chkgrd
                     if(o==tfdtadm)
                     { if(tfdtadm.getText().length()==0)
                         {
                             chkdtadm.setText("!Enter date admitted ");
                             //tfdtadm.requestFocus();
                         }
                         else
                             chkdtadm.setText("");
                     }
                     if(o==tfcont)
                     { if(tfcont.getText().length()==0)
                         {
                             chkcont.setText("!Enter contact number");
                             //tfcont.requestFocus();
                         }
                         else
                             chkcont.setText("");
                     }
                     if(o==taadd)
                     {
                     if(taadd.getText().length()==0)
                         {
                             chkadd.setText("!Enter address");
                             //taadd.requestFocus();
                         }
                         else
                             chkadd.setText("");
                     }
                     if(o==tagrd)
                     {if(tagrd.getText().length()==0)
                         {
                             chkgrd.setText("!Enter guardian name with contact");
                             //tagrd.requestFocus();
                         }
                         else
                             chkgrd.setText("");
                     }
                     
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
     Object o=e.getSource();
	if(o==tfname)
	{	char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		//e.getToolkit.beep();
		chkname.setText("! Enter characters only .");
		//altname.setForeground(new Color(204,0,0));
		}
		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkname.setText("");
		}
	}
       if(o==tfrmno)
        {
        char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		chkrm.setText("! Enter no. of years only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkrm.setText("");
		}
	}
       if(o==tfdr)
	{	char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		//e.getToolkit.beep();
		chkdr.setText("! Enter characters only .");
		//altname.setForeground(new Color(204,0,0));
		}
		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkdr.setText("");
		}
	}
        //   tfname,tfrmno,tfdr,tfdis,tfdtadm,tfdtdis,tfcont,taadd,tagrd
     if(o==tfdtadm)
     {}
     if(o==tfcont)
     {
          char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		chkcont.setText("! Enter valid number only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkcont.setText("");
		}
	
     }

    }
    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
   
      }
          
          

