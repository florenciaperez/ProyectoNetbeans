
package Interfaz;


import java.util.ArrayList;
import transferObject.Categoria;

/**
 *
 * @author SINQUIA
 */
public interface ICategoria {
    
 /** insertar metodos abstracto */      
    public abstract ArrayList<Categoria> listarCategorias();
    public abstract boolean insertarCategoria(Categoria cate);
    public abstract boolean actualizarCategoria(Categoria cate);
    public abstract boolean eliminarCategoria(int idCategoria);
    
  /** implementar dentro de DAO*/                 
}
