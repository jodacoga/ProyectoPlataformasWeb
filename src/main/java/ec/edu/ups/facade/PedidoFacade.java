/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Pedido;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(name = "PlataformasWeb")
    private EntityManager em;

    public PedidoFacade() {
        super(Pedido.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
