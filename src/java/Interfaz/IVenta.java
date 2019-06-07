
package Interfaz;

import java.util.ArrayList;
import transferObject.Venta;

/**
 *
 * @author SINQUIA
 */
public interface IVenta {
    public abstract ArrayList<Venta> listVenta();
    public boolean insertVenta(Venta venta);
    public boolean updateVenta(Venta venta);
    public boolean deleteVenta(int idVenta);
}
