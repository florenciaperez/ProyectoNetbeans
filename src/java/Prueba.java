
import DAO.CategoriaDao;
import transferObject.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CategoriaDao catedao = new CategoriaDao();
       
       Categoria cate = new Categoria ();
       cate.setIdCategoria(1);
       cate.setDescripcion("Metal");
       cate.setEstado('B');
       
       catedao.insertarCategoria(cate);
       
        
    }
    
}
