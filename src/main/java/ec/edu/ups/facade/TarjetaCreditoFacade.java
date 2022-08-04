package ec.edu.ups.facade;

import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.entidades.TarjetaCredito;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
@Stateless
public class TarjetaCreditoFacade extends AbstractFacade<TarjetaCredito> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;

    public TarjetaCreditoFacade() {
        super(TarjetaCredito.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
