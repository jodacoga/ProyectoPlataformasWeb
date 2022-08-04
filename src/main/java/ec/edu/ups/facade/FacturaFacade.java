/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;

    public FacturaFacade() {
        super(Factura.class);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void calcularSubtoral() {

    }

    public Factura getCodigo(int codigo) {
        String jpql = "SELECT u FROM Factura u WHERE u.codigoFactura = '" + codigo + "'";
        Factura factura = (Factura) em.createQuery(jpql).getSingleResult();
        return factura;
    }

}
