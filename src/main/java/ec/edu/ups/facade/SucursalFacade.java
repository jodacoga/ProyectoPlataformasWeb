/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Sucursal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author User
 */
@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;

    public SucursalFacade() {
        super(Sucursal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Sucursal getSucursalByName(String name) {
        String jpql = "SELECT s FROM Sucursal s WHERE s.nombre = '" + name+"'";
        Sucursal sucursal = (Sucursal) em.createQuery(jpql).getSingleResult();
        return sucursal;
    }

    public List<String> getSucursalNames() {
        String jpql = "SELECT u.nombre FROM Sucursal u ";
        List<String> res = em.createQuery(jpql).getResultList();

        return res;
    }
     


}
