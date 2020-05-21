package pateintreport;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewDRlog extends JFrame implements ActionListener,WindowListener,FocusListener,KeyListener,MouseListener
{
    //Registering various components:
        JPanel p;
        JLabel l,name,qual,exp,age,spl,crtpass,cnfpass,userid,lcont;
        JLabel chkname,chkqual,chkexp,chkage,chkcont,chkspl,chkcrtpass,chkcnfpass,chkuserid;
        JButton submit,cancel,showrecord;
        JTextField tuid, tname,tqual,texp,tage,tcont,tspl;
        JPasswordField tcrtpass,tcnfpass;
        JOptionPane msg;
        Connection con;
        //constructor created
            NewDRlog()
    {
        //giving memory to all components
        p=new JPanel();
        chkuserid=new JLabel();
        chkname=new JLabel();
        chkqual=new JLabel();
        chkexp=new JLabel();
        chkage=new JLabel();
        chkcont=new JLabel();
        chkspl=new JLabel(); 
        chkcrtpass=new JLabel();
        chkcnfpass =new JLabel();
        l=new JLabel("Register Yourself");
        userid=new JLabel("Your UserId is:");
        name=new JLabel("Name");
        qual=new JLabel("Qualification");
        exp=new JLabel("Experience");
        age=new JLabel("Age");
        lcont=new JLabel("Contact No.");
        spl=new JLabel("Specialization");
        crtpass=new JLabel("New Password");
        cnfpass=new JLabel("Confirm Password");
        submit=new JButton("Submit");
        submit.setForeground(Color.blue);
        submit.addMouseListener((MouseListener)this);     

        cancel=new JButton("Cancel");
        cancel.setFont(new java.awt.Font("Times New Roman", 8, 18)); cancel.setForeground(Color.blue); 
        cancel.addMouseListener((MouseListener)this);   cancel.addActionListener((ActionListener)this);

        showrecord=new JButton("RESET");
        showrecord.setFont(new java.awt.Font("Times New Roman", 8, 18)); showrecord.setForeground(Color.blue); 
        showrecord.addMouseListener((MouseListener)this);   showrecord.addActionListener((ActionListener)this);

        tuid=new JTextField();
        tname=new JTextField();
        tqual=new JTextField();  
        texp=new JTextField();
        tage=new JTextField();
        tspl=new JTextField();
        tcrtpass=new JPasswordField();
        tcnfpass=new JPasswordField();
        tcont=new JTextField();
        msg=new JOptionPane();
        msg.setSize(300,300);
      
        l.setBounds(500,50,350,30);
        l.setForeground(Color.blue);
        l.setFont(new java.awt.Font("Times New Roman",1,25));
        
        userid.setFont(new java.awt.Font("Times New Roman",4,18));
        name.setFont(new java.awt.Font("Times New Roman",4,18));        
        qual.setFont(new java.awt.Font("Times New Roman",4,18));
        exp.setFont(new java.awt.Font("Times New Roman",4,18));
        age.setFont(new java.awt.Font("Times New Roman",4,18));
        lcont.setFont(new java.awt.Font("Times New Roman",4,18));
        spl.setFont(new java.awt.Font("Times New Roman",4,18));
        crtpass.setFont(new java.awt.Font("Times New Roman",4,18));
        cnfpass.setFont(new java.awt.Font("Times New Roman",4,18));
        submit.setFont(new java.awt.Font("Times New Roman",4,18));
        cancel.setFont(new java.awt.Font("Times New Roman",4,18));
        showrecord.setFont(new java.awt.Font("Times New Roman",4,18));
        
        userid.setBounds(100,100,250,30);
        name.setBounds(100,150,150,30);         
        qual.setBounds(100,200,150,30);
        exp.setBounds(100,250,150,30);
        age.setBounds(100,300,150,30);
        lcont.setBounds(100,350,150,30);
        spl.setBounds(100,400,150,30);
        crtpass.setBounds(100,450,250,30);
        cnfpass.setBounds(100,500,250,30);
        
        tuid.setBounds(250,100,250,30);     tuid.setEditable(false);     //tuid.addFocusListener((FocusListener)this);
        tname.setBounds(250,150,250,30);    tname.addFocusListener((FocusListener)this);   tname.addKeyListener((KeyListener)this);
        tqual.setBounds(250,200,250,30);    tqual.addFocusListener((FocusListener)this);    tqual.addKeyListener((KeyListener)this);
        texp.setBounds(250,250,250,30);     texp.addFocusListener((FocusListener)this);    texp.addKeyListener((KeyListener)this);
        tage.setBounds(250,300,250,30);     tage.addFocusListener((FocusListener)this);     tage.addKeyListener((KeyListener)this);
        tcont.setBounds(250,350,250,30);     tcont.addFocusListener((FocusListener)this);     tcont.addKeyListener((KeyListener)this);
        tspl.setBounds(250,400,250,30);     tspl.addFocusListener((FocusListener)this);     tspl.addKeyListener((KeyListener)this);
        tcrtpass.setBounds(250,450,250,30);  tcrtpass.addFocusListener((FocusListener)this);   tcrtpass.addKeyListener((KeyListener)this);
        tcnfpass.setBounds(250,500,250,30);     tcnfpass.addFocusListener((FocusListener)this);     tcnfpass.addKeyListener((KeyListener)this);
        
        submit.setBounds(130,560,150,30);   submit.addActionListener((ActionListener)this);
        cancel.setBounds(320,560,150,30);           cancel.addActionListener((ActionListener)this);
        showrecord.setBounds(490,560,160,30);   showrecord.addActionListener((ActionListener)this);
                  
        chkname.setBounds(500,150,250,30);   chkname.setForeground(new Color(204,0,0)); 
        chkqual.setBounds(500,200,250,30);   chkqual.setForeground(new Color(204,0,0));
        chkexp.setBounds(500,250,250,30);    chkexp.setForeground(new Color(204,0,0));
        chkage.setBounds(500,300,250,30);    chkage.setForeground(new Color(204,0,0));
        chkcont.setBounds(500,350,250,30);    chkcont.setForeground(new Color(204,0,0));
        chkspl.setBounds(500,400,250,30);    chkspl.setForeground(new Color(204,0,0));
        chkcrtpass.setBounds(500,450,250,30);   chkcrtpass.setForeground(new Color(204,0,0));
        chkcnfpass.setBounds(500,500,250,30);   chkcnfpass.setForeground(new Color(204,0,0));

        p.add(l);
        p.add(name);
        p.add(qual);
        p.add(exp);
        p.add(age);
        p.add(lcont);
        p.add(spl);
        p.add(crtpass);
        p.add(cnfpass);
        p.add(userid);
        p.add(tname);
        p.add(tqual);
        p.add(texp);
        p.add(tage);
        p.add(tcont);
        p.add(tspl);
        p.add(tcrtpass);
        p.add(tcnfpass);
        p.add(tuid);
        p.add(submit);
        p.add(cancel);
        p.add(showrecord);
        p.add(chkname);
        p.add(chkqual);
        p.add(chkexp);
        p.add(chkage);
        p.add(chkcont);
        p.add(chkspl);
        p.add(chkcrtpass);
        p.add(chkcnfpass);
        p.setBackground(Color.white);
        p.setVisible(true);
       p.setSize(1440,800);
        p.setLayout(null);
    int row;
   
        try
        {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from DOCTER");
        rs.last();
        row=rs.getRow();
         autogen(row);
        }
        catch(Exception e)
        { }
       add(p);
       setVisible(true);
       setSize(1440,800);
       setTitle("Docter Register ");
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
                ps=con.prepareStatement("insert into DOCTER values(?,?,?,?,?,?,?,?)"); 
                ps.setString(1,tuid.getText());
                ps.setString(2,tname.getText());
                ps.setString(3,tqual.getText());
                ps.setString(4,texp.getText());
                ps.setString(5,tage.getText());
                ps.setString(6,tcont.getText());
                ps.setString(7,tspl.getText());
                ps.setString(8,tcnfpass.getText());
                    
                int ret=ps.executeUpdate();
                if(ret==1)
                {
                JOptionPane.showMessageDialog(null,"Your info is added...","Data Stored", 3);               
                }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Error in code  : "+e.getMessage().toString(),"Error Message", 1);
        }
    }
    @Override   public void actionPerformed(ActionEvent e)
        { 
            Object o= e.getSource();
            if(o==showrecord)
                {
                    //tuid, tname,tqual,texp,tage,tcont,tspl;
    //    JPasswordField tcrtpass,tcnfpass;
                    tname.setText("");
                tqual.setText("");
                texp.setText("");
                tage.setText("");
                tcont.setText("");
                tspl.setText("");
                tcrtpass.setText("");
                tcnfpass.setText("");
                
                }
              if(o==submit)
              { if((tcrtpass.getText()).equals(tcnfpass.getText()))//&&((tname.getText().length()==0)||(tqual.getText().length()==0)||(texp.getText().length()==0)||(tage.getText().length()==0)||(tcont.getText().length()==0)||(ctime.getSelectedIndex(0)))
                              {
                                  addData();
                                  //chkcnfpass.setText("");
                              }
                              else
                              {
                              chkcnfpass.setText("Password Mismatch");
                              tcrtpass.setText("");
                              tcnfpass.setText("");
                              }
             
              // addData();  
              }
              if(o==cancel)
              {
                  FirstPage lp=new FirstPage();
              }
              
        }
    public void windowClosing(WindowEvent e)
            {  
                int a=JOptionPane.showConfirmDialog(this,"Are you sure to exit?");  
                if(a==JOptionPane.YES_OPTION)
                {  
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                }
            }
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
            
    public void showData()
    {
        try
        {
        Statement st;
        ResultSet rs;
        st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=st.executeQuery("select * from DOCTER");
        rs.next();
        tname.setText(rs.getString(1));
        tqual.setText(rs.getString(2));
        texp.setText(rs.getString(3));
        tage.setText(rs.getString(4));
        tspl.setText(rs.getString(5));
        tcrtpass.setText(rs.getString(6));
        tcnfpass.setText(rs.getString(7));
        if(rs.next())
        {
        System.out.print("Record Found");///want to disply in table HOW??
        }
        
        }
        catch(Exception e)
        {
        }
    
    }
    public void autogen(int row)
  {
      try
      {
          if(row<=8)
          {
              tuid.setText("D00"+String.valueOf(row+1));
          }
          
          else if((row>=9)||(row<=98))
          {
              tuid.setText("D0"+String.valueOf(row+1));
          }
          else if((row>=99))
          {
              tuid.setText("D"+String.valueOf(row+1));
          }
              
      }
      catch(Exception e)
      {
        System.out.println("catched auto gen error = "+e.getMessage());
      }
  } 

    public void focusLost(FocusEvent e)
 {
     Object o=e.getSource();
     if(o==tname) 
     {
         if(tname.getText().length()<=2)
         {chkname.setText("Enter name");}                        
     }
     if(o==tqual)
     {
         if(tqual.getText().length()==0)
         {chkqual.setText("Enter your qualification ");}
         else
             chkqual.setText(" ");
     }
     if(o==texp)
     {
         if(texp.getText().length()<3||texp.getText().length()!=0)
         {
             Pattern MyPattern =Pattern.compile("0-9");
             Matcher MyMatcher=MyPattern.matcher(texp.getText());
             Boolean MyBoolean =MyMatcher.matches();
             if(MyBoolean==true)
             {
                      chkexp.setText("");
             }
             if(texp.getText().length()>3||texp.getText().length()==0)
             {
                                     chkexp.setText("Enter Valid Experience ");
             }
         }
     }
     if(o==tage)
     {
         if(tage.getText().length()<3||tage.getText().length()!=0)
         {
             Pattern MyPattern =Pattern.compile("0-9");
             Matcher MyMatcher=MyPattern.matcher(tage.getText());
             Boolean MyBoolean =MyMatcher.matches();
             if(MyBoolean==true)
             {
                 chkage.setText("");
             }
             if(tage.getText().length()>=3)
             { 
                 chkage.setText("Enter Valid age  ");
             }
             else
             {chkage.setText("");}
             if(texp.getText().equals(tage.getText()))
             {
                 chkexp.setText("Enter Valid Experience");
             }
         }
     }
     if(o==tcont)
     {
         if((tcont.getText().length()>10)||(tcont.getText().length()<10))
         {chkcont.setText("! Enter your 24-hr available Contact");}
     }
     if(o==tspl)
     {
         if(tspl.getText().length()==0)
         {chkspl.setText("Enter ur specialization");}
         else
             chkspl.setText(" ");
     }
     if(o==tcrtpass)
     {
         if(tcrtpass.getText().length()<5)
         {
             chkcrtpass.setText("password length should atleast 5");
         }
     }
     if(o==tcnfpass)
     {
         if((tcrtpass.getText()).equals(tcnfpass.getText()))
         {
             chkcnfpass.setText("");
         }
         else
         {
             chkcnfpass.setText("Password Mismatch");
             tcrtpass.setText("");
             tcnfpass.setText("");
         }
     }
 }

 @Override  public void keyPressed(KeyEvent e) {}  
 @Override  public void keyReleased(KeyEvent e) {}  
 @Override  
 public void keyTyped(KeyEvent e) 
 {
     Object o=e.getSource();
	if(o==tname)
	{	
            //char c=e.getKeyChar();
//		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
//		{
//		e.consume();
//		chkname.setText("! Enter characters only .");
//		}
//		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
//		{
//		chkname.setText("");
//		}
	}
        if(o==tqual)
	{
//            char c=e.getKeyChar();
//		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
//		{
//		e.consume();
//		chkqual.setText("! Enter characters only .");
//		}
//		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
//		{
//		chkqual.setText("");
//		}
	}
        if(o==texp)
        {
        char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		chkexp.setText("! Enter no. of years only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkexp.setText("");
		}
	}
        if(o==tage)
        {
        char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		chkage.setText("! Enter no. of years only");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkage.setText("");
		}
	}
        if(o==tspl)
	{
		char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		chkspl.setText("! Enter valid character ");
		}
		if((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkspl.setText("");
		}
	}
       if(o==tcont)
	{
	char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		chkcont.setText("! Enter valid number ");
		}
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		chkcont.setText(" ");
		}
	}
	
}

    @Override   public void focusGained(FocusEvent e) {}
    
      public void mouseEntered(MouseEvent e)
      {
            Object o=e.getSource();
            if(o==cancel)
            {  cancel.setForeground(new Color(255,51,51));
               cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(new java.awt.Color(0,0,0)));
               cancel.setBackground(new Color(0,0,0));
               cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            if(o==submit)
            { 
                      submit.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(new java.awt.Color(0,0,0)));
                      submit.setForeground(new Color(0,204,0));  
                      submit.setBackground(new Color(0,0,0));
                      submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));   
            }
           /* if(o==Reset)
            {  Reset.setForeground(Color.PINK);
               Reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
               Reset.setBackground(new Color(1,191,224));
               Reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }*/
       }  
	
      public void mouseExited(MouseEvent e)
      {
          Object o=e.getSource();
            if(o==cancel)
            {
               cancel.setBackground(new Color(204,0,0));
               cancel.setForeground(Color.BLUE);
               //cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(Color.LIGHT_GRAY));

            }
    /*       if(o==Reset)
            { // reset.setBounds(400,660,150,20);
               Reset.setBackground(null);
               Reset.setForeground(Color.BLUE);
               Reset.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            }
    */
            if(o==submit)
            {
            submit.setBackground(new Color(204,0,0));
            submit.setForeground(Color.BLUE);
            //submit.setBorder(javax.swing.BorderFactory.createEmptyBorder());//LineBorder(Color.LIGHT_GRAY));
            }   
      }

    @Override   public void mouseClicked(MouseEvent e) {}

    @Override   public void mousePressed(MouseEvent e) {}

    @Override   public void mouseReleased(MouseEvent e) {}
    
    public static void main(String arg[])
    {
        new NewDRlog();
    }
}