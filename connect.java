package pateintreport;
import java.sql.*;
public class connect
{
 Connection con;
     connect()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
           con=DriverManager.getConnection("jdbc:derby://localhost:1527/pateintReport","harnoor","12345");
        } 
        catch(Exception e){}
     
    }
    
}
