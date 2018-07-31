package virus_analyzer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbms {
    static Connection c;
    
    static Connection getCon() throws Exception{
        if (c==null) {
            
            String server=JOptionPane.showInputDialog("Enter Server name (ex:localhost)");
            String port=JOptionPane.showInputDialog("Enter Port");
            String uname=JOptionPane.showInputDialog("Enter username");
            String pw=JOptionPane.showInputDialog("Enter password");
            String dbname=JOptionPane.showInputDialog("Enter Database Name");
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+dbname,uname,pw );
            return c;
            
        } else {
            return c;
        }
    }
    static ResultSet getData(String sql)throws Exception{
    
        Connection c =dbms.getCon();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(sql);
        return rs;
    }
        
        
}
