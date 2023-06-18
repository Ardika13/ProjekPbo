package Com.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyConfig {
    private Connection Con;
    
    public Connection getConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            
        }
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ardika","root","");
            if(Con != null){
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
        return Con;
    }
}
