/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Producto;
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
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(name = "PlataformasWeb")
    private EntityManager em;
    
    @EJB
    private CategoriaFacade categoriaFacade;

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void guardarProducto(String nombre, String descripcion, double precio, int stock, String nombreCategoria) throws Exception {
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        p.setStock(stock);
        CategoriaProducto catSucursal = categoriaFacade.getCategoriaByName(nombreCategoria);
        if (catSucursal == null) {
            throw new Exception("La categoria no existe");
        }
        p.setCategoria(catSucursal);
        List<Producto> producto = catSucursal.getProducto();
        producto.add(p);
        catSucursal.setProducto(producto);
        categoriaFacade.edit(catSucursal);
    }
    
    public Producto getProductoByName(String name) {
        String jpql = "SELECT s FROM Producto s WHERE s.nombre = '" + name+"'";
        Producto producto = (Producto) em.createQuery(jpql).getSingleResult();
        return producto;
    }

    public List<String> getProductoNames() {
        String jpql = "SELECT u.nombre FROM Producto u ";
        List<String> res = em.createQuery(jpql).getResultList();
        return res;
    }

}
