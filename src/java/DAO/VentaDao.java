/*
 
 */
package DAO;
import Interfaz.IVenta;
import java.util.ArrayList;
import transferObject.Venta;
import Conection.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author SINQUIA
 */
public class VentaDao implements IVenta{

    @Override
    public ArrayList<Venta> listVenta() {
        ArrayList<Venta> list = new ArrayList<>();
        
        conexion conn = new conexion();
        Connection cn = conn.getConnection();
        
        String listprocedure = "{CALL sp_listarventa}";
        
        if(cn != null){
            try {
                CallableStatement cb = conn.getConnection().prepareCall(listprocedure);
                ResultSet rs = cb.executeQuery();
                
                while (rs.next()) {                    
                    Venta venta = new Venta();
                    venta.getDate();
                    venta.getIdVenta();
                    venta.getListaDetalle();
                    venta.getTotal();
                    
                    list.add(venta);
                }
            } catch (Exception e) {
            }finally{
                try {
                    cn.close();
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    @Override
    public boolean insertVenta(Venta venta) {
        return true;
    }

    @Override
    public boolean updateVenta(Venta venta) {
        return true;
    }

    @Override
    public boolean deleteVenta(int idVenta) {
        return true;
    }
    
}
