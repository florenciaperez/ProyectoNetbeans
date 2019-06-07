
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SINQUIA
 */
public class conexion {
  
    public Connection getConnection(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ferreteria","root","");
            
        }catch(SQLException e){  
        } catch (Exception e) {
        }
        return cn;
    }
}
