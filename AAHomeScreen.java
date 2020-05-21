package pateintreport;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
//import java.awt.event.*;

public class AAHomeScreen implements Runnable
{   JFrame f;
    JLabel lpic;
    ImageIcon img[];
    Thread th;
    Timer t;   
    int i = 0;
    
    public static void main(String a2rgs[])
    {
    AAHomeScreen h=new AAHomeScreen();
    
    }
    AAHomeScreen() 
    {
        f=new JFrame("PATEINT'S REPORT");
        th=new Thread(this);
        t = new Timer();
        img = new ImageIcon[4];
        img[0] = new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/frontq.jpg");
        img[1] = new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/download.jpeg");	
        img[2] = new ImageIcon("/Users/kuldipsingh/Desktop/prj2019/img.jpg");	
        lpic = new JLabel(img[i]);
        f.setLocation(new Point(500,250));
        f.setResizable(false);
        f.add(lpic);
        f.setVisible(true);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        th.start();
        t.schedule(new LoginSc(), 5000);
   }
    public void run()
    {
        while (th != null)
        {
            try 
            {
                display();
                Thread.sleep(3000);
            }
            catch (InterruptedException e) 
            {}

        }
        
    }

    void display() {
        i = i + 1;
        if (i > 2) {
            i = 0;
        }
        lpic.setIcon(img[i]);
    }

    
    public class LoginSc extends TimerTask
    {

        @Override
        public void run() 
        {
            FirstPage fp=new FirstPage();
            fp.setVisible(true);
            f.setVisible(false);
        }
    }
}
