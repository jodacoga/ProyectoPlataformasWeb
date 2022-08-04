/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Sucursal;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<CategoriaProducto> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;
 
    @EJB
    private SucursalFacade facade;
    


    public CategoriaFacade() {
        super(CategoriaProducto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void guardarCategoria(String nombre, String descripcion) throws Exception {
        
        CategoriaProducto c = new CategoriaProducto();
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        
       
       
    }
    
    public CategoriaProducto getCategoriaByName(String name) {
        String jpql = "SELECT s FROM CategoriaProducto s WHERE s.nombre = '" + name+"'";
        CategoriaProducto catSucursal = (CategoriaProducto) em.createQuery(jpql).getSingleResult();
        return catSucursal;
    }

    public List<String> getCategoriaNames() {
        String jpql = "SELECT u.nombre FROM CategoriaProducto u ";
        List<String> res = em.createQuery(jpql).getResultList();
        return res;
    }
    
}
