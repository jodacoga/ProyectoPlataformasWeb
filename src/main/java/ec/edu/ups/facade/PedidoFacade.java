/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Pedido;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;

    public PedidoFacade() {
        super(Pedido.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     public List<Pedido> getPedido() {
        String jpql = "SELECT u FROM Pedido u ";
        List<Pedido> res = em.createQuery(jpql).getResultList();
        System.out.println(res);
        return res;//em.createQuery(jpql, Pedido.class).getResultList();
    }

}
