package pateintreport;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstPage extends JFrame implements ActionListener,WindowListener
{
        JPanel pimg;
        JLabel l,userid,passwrd,z,dt,lbck ,err,head,limg;
       // JTextArea timetable;
        JButton btnlogin;
        
        JButton nwdoc, nwnrs;
        
        JRadioButton rbdoc,rbnrs;
        ButtonGroup bg;
        
        JTextField tfid;
        JPasswordField pwd;
        JOptionPane msg;
        FirstPage lp;
            FirstPage()
    {   
            Date d;
            SimpleDateFormat ft;
            d=new Date();
            dt=new JLabel();
            ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy 'at' hh:mm a zzz");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,20));
            dt.setForeground(new Color(0,024,204));
    
            head=new JLabel("HEATH CARE ");
            head.setForeground(Color.BLUE);
            head.setFont(new Font("Times New Roman",1 ,24));
            head.setBounds(50,50,200,30);
                pimg=new JPanel();
              //  timetable =new JTextArea();
                bg=new ButtonGroup();                       
        
                rbdoc=new JRadioButton("DOCTOR");               rbdoc.setFont(new Font("Times New Roman",0,16));   
                rbnrs=new JRadioButton("NURSE");             rbnrs.setFont(new Font("Times New Roman",0,16));
                      
                bg.add(rbdoc);             bg.add(rbnrs);         
               
                rbdoc.setBounds(1000,430,110,30);         rbnrs.setBounds(1150,430,90,30);       
        
        l=new JLabel("Login Yourself");
        limg=new JLabel(new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/nurse.jpeg"));
        userid=new JLabel("User id");
        passwrd=new JLabel("Password");
        
        err=new JLabel();
        btnlogin=new JButton("LOGIN");
        
        nwdoc=new JButton ("New Doctor");
        nwnrs=new JButton ("New Nurse");
        
        tfid=new JTextField();
         pwd= new JPasswordField();
        msg=new JOptionPane();
        
        msg.setSize(300,300);
        l.setBounds(1000,55,250,35);
        l.setFont(new java.awt.Font("Times New Roman", 0,25));
        l.setForeground(Color.BLUE);
        
        limg.setBounds(998,90,200,200);
        
        
        userid.setBounds(900,300,200,25);
        userid.setFont(new java.awt.Font("Times New Roman",0,18));
        userid.setForeground(new Color(0,51,255));
      
        
        err.setBounds(950,520,300,20);
        err.setFont(new java.awt.Font("Times New Roman",0,18));
        err.setForeground(Color.red);
        
        passwrd.setBounds(900,370,200,25);
        passwrd.setFont(new java.awt.Font("Times New Roman",0,18));
        passwrd.setForeground(new Color(0,51,255));
        tfid.setBounds(1050,300,200,25);
        pwd.setBounds(1050,370,200,25);
        btnlogin.setBounds(1050,480,100,25);
        btnlogin.setForeground(Color.blue);
        btnlogin.setFont(new java.awt.Font("Times New Roman",0,16));

        nwdoc.setBounds(1000,550,100,35);
        nwdoc.setForeground(Color.blue);
        nwdoc.setFont(new java.awt.Font("Times New Roman",0,16));
        
        nwnrs.setBounds(1150,550,100,35);
        nwnrs.setForeground(Color.blue);
        nwnrs.setFont(new java.awt.Font("Times New Roman",0,16));
        

        dt.setBounds(1000,20,400,35);
        lbck= new JLabel(new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/nurse.jpeg.png"));
        lbck.setSize(1440,800);
        lbck.setVisible(true);
        l.setVisible(true);
        userid.setVisible(true);
        passwrd.setVisible(true);
        tfid.setVisible(true);
        pwd.setVisible(true);
        msg.setVisible(true);
        dt.setVisible(true);
        btnlogin.addActionListener((ActionListener)this);
       
        nwdoc.addActionListener((ActionListener)this);
        nwnrs.addActionListener((ActionListener)this);
        
        lbck.add(l);
        lbck.add(limg);
        lbck.add(head);
        lbck.add(userid);
        lbck.add(err);
        lbck.add(passwrd);
//        lbck.add(bnew);
       // lbck.add(blogin);
        lbck.add(btnlogin);
        
        lbck.add(nwdoc);
        lbck.add(nwnrs);
       
        lbck.add(tfid);
        lbck.add(pwd);
        lbck.add(dt);
        pimg.add(lbck);
        pimg.setVisible(true);
        pimg.setLayout(null);
        pimg.setSize(1440,800);
        
      //  pimg.add(timetable);        
      // pimg.setBackground(new Color(204,255,255));
                lbck.add(rbdoc);         //  rbdoc.addMouseListener((MouseListener)this);
                lbck.add(rbnrs);           //rbnrs.addMouseListener((MouseListener)this);
              
        add(pimg);
        setSize(1440,800);
        setVisible(true);
        setLayout(null);
        setTitle(" LOGIN YOURSELF ");
        setResizable(false);
        addWindowListener((WindowListener)this);
    }
    public static void main(String arg[])
    {
        FirstPage lp = new FirstPage();
    }
   
     public void actionPerformed (ActionEvent e)
        {
            
            Object o =e.getSource();
            if(o==btnlogin)
            {
              String user=null,pass=null;
                Boolean bu=false ;//,bp=false;
                       user=tfid.getText();
                       pass=pwd.getText();

                if(rbdoc.isSelected())               
                {
                      try
            
                      {
                        connect c=new connect();               
                        Statement st;
                        st=c.con.createStatement();

                        ResultSet res=st.executeQuery("select * from docter");
                        String  password=null,userid=null;
                        
                        String docname=null; 
                        while(res.next())
                        {
                            if( (pass.equals(res.getString(8)))    &&(user.equalsIgnoreCase(res.getString(1))))
                            {
                             bu=true;
//                    bp=true;
//                    password=res.getString(2);
            
                                userid=res.getString(1);
                                docname=res.getString(2);
                            }
                        }
                        if((bu==true))//&&(bp==true))
                        {   
                            DocterPortal dp=new DocterPortal(userid,docname);
                                setVisible(false);
                        }
                        else
                        {
                             err.setText(" ! User ID or Password is incorrect ");
                             tfid.setText("");
                             pwd.setText("");
                             bg.clearSelection();
                        }
                         
                      }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }

                }
                else if(rbnrs.isSelected())
                {
                   
                     try
            
                      {
                        connect c=new connect();               
                        Statement st;
                        st=c.con.createStatement();

                        ResultSet res=st.executeQuery("select * from nurse");
                        String  password=null,userid=null;
                        String nrsname=null;
                        while(res.next())
                        {
                            if( (pass.equals(res.getString(8)))    &&(user.equalsIgnoreCase(res.getString(1))))
                            {
                             bu=true;
                             userid=res.getString(1);
                             nrsname=res.getString(2);
                            }
                        }
                        if((bu==true))//&&(bp==true))
                        {   
                           NursePortal np=new NursePortal(userid,nrsname);
                           setVisible(false);
                        }
                        else
                        {
                             err.setText(" ! User ID or Password is incorrect ");
                             tfid.setText("");
                             pwd.setText("");
                             bg.clearSelection();

                        }
                         
                      }
                        catch(Exception ex)
                        {
                            System.out.println(ex.getMessage());
                        }
  
                }
//                else if(rbcsh.isSelected())
//                {
//                   
//                     try
//            
//                      {
//                        connect c=new connect();               
//                        Statement st;
//                        st=c.con.createStatement();
//
//                        ResultSet res=st.executeQuery("select * from cashier");
//                        String  password=null,userid=null;
//                        while(res.next())
//                        {
//                            if( (pass.equals(res.getString(8)))    &&(user.equalsIgnoreCase(res.getString(7))))
//                            {
//                             bu=true;
////                    bp=true;
////                    password=res.getString(2);
////                    userid=res.getString(1);
//                            }
//                        }
//                        if((bu==true))//&&(bp==true))
//                        {   
//                           CashierPortal np=new CashierPortal();
//                           setVisible(false);
//                        }
//                        else
//                        {
//                             err.setText(" ! User ID or Password is incorrect ");
//                             tfid.setText("");
//                             pwd.setText("");
//                             bg.clearSelection();
//                             //err.setText("");
//
//                        }
//                         
//                      }
//                        catch(Exception ex)
//                        {
//                            System.out.println(ex.getMessage());
//                        }
//  
//                }
                
                else
                {
                    err.setText("Please select your designation !"); 
               }
                
            }   
            
            if(o==nwdoc)
            {
                NewDRlog n=new NewDRlog();
                setVisible(false);
            }
            
            if(o==nwnrs)
            {
                           NewNRSlog nrs=new NewNRSlog();
                                           setVisible(false);

            }
        }
     public void windowClosing(WindowEvent e)
      {  
            int a=JOptionPane.showConfirmDialog(this,"Are you sure to exit?\n This will close your application ");  
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
          
}