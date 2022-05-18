/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.CategoriaSucursal;
import ec.edu.ups.entidades.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<CategoriaSucursal>{
    
      @PersistenceContext(name = "PlataformasWeb")
    private EntityManager em;

    public CategoriaFacade() {
        super(CategoriaSucursal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
