/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;

    public DetalleFacturaFacade() {
        super(DetalleFactura.class);
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void calcularSubtoral(){
        
    }
    
        public DetalleFactura getCodigo(int codigo) {
        String jpql = "SELECT u FROM DetalleFactura u WHERE u.codigoDetalle = '" + codigo+"'";
        DetalleFactura factura = (DetalleFactura) em.createQuery(jpql).getSingleResult();
        return factura;
    }
    
}
