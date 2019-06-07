/*
 
 */
package DAO;


import Conection.conexion;
import Interfaz.ICategoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferObject.Categoria;


public class CategoriaDao implements ICategoria{

    @Override
    public ArrayList<Categoria> listarCategorias() {
      //Crear una variable
    ArrayList<Categoria> listaCate = new ArrayList<>();
    conexion db = new conexion();
    Connection cn=db.getConnection();
    //conn.getConnection();
    String procedimientoalmacenado = "{CALL sp_listarcategoria()}";
    
    // PROCESO
    
    if (cn !=null){
        try {
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Categoria cate = new Categoria();
                cate.setIdCategoria(rs.getInt(" idCategoria"));
                cate.setDescripcion( rs.getString("descripcion")); 
                cate.setEstado(rs.getString("estado").charAt(0));
                listaCate.add(cate);
                
            }
        } catch (SQLException e) {
            System.out.println("error"+e);
        }finally{
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println("error");
            }
        }
    }
   
    return listaCate;
    }

    @Override
    public boolean insertarCategoria(Categoria cate) {
     boolean insert=false;  
     int res;
     conexion conn=new conexion();
     Connection cn = conn.getConnection();
     // proeso
     if (cn !=null){
         try {
            CallableStatement cs = cn.prepareCall("CALL sp_isertarcategoria(?,?,?)");
            // setear los parametros del procedimiento
            cs.setInt(1,cate.getIdCategoria());
            cs.setString(2,cate.getDescripcion());
            cs.setString(3,String.valueOf(cate.getEstado()));
            res = cs.executeUpdate();
            if (res==1){
                insert = true;
            }
         } catch (SQLException ex) {
             System.out.println("error"+ex);
         }finally{
             try {
                 cn.close();
             } catch (SQLException ex) {
                 System.out.println("error"+ex);
             }
         }
     }
     return insert;
    }
    @Override
    public boolean actualizarCategoria(Categoria cate) {
     boolean update=false; 
     int res;
     // la coneccion
     conexion conn =new conexion();
     Connection cn = conn.getConnection();
     // preguntar si conecto
     if(cn !=null){
         try { 
             CallableStatement cs = cn.prepareCall("CALL sp_actualizarcategoria(?,?,?)");
            cs.setString(1,cate.getDescripcion());
            cs.setString(2,String.valueOf(cate.getEstado()));
            cs.setInt(3,cate.getIdCategoria() );
            res = cs.executeUpdate();
            // actualizacion correctamente
            if(res==1){
                update = true;
            }
         } catch (SQLException ex) {
           } finally{
             try {
                 cn.close();
             } catch (Exception e) {
             }
         }
     }
     return update;
    }

    @Override
    public boolean eliminarCategoria(int idCategoria ) {
    boolean delete=false;  
    conexion conn = new conexion();
    Connection cn = conn.getConnection();
  int res;
    if(cn != null){
        try {
      CallableStatement cs = cn.prepareCall("CALL sp_eliminarcategoria(?,?,?)");
    cs.setInt(1,idCategoria);
    res =cs.executeUpdate();
    
    if(res==1){
        delete= true;   
    }
    
        } catch (Exception e) {
        }
        
    }
 
    // proceso
    return delete;
    
    
    }
    
    
}
