/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.TipoUsuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author johan
 */
@Stateless
public class TipoUsuarioFacade extends AbstractFacade<TipoUsuario> {

    @PersistenceContext(name = "PlataformasWeb")
    private EntityManager em;

    public TipoUsuarioFacade() {
        super(TipoUsuario.class);
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
        public TipoUsuario getTipoNombre(String nombre) {
        String jpql = "SELECT u FROM TipoUsuario u WHERE u.descripcion = '" + nombre+"'";
        TipoUsuario tipoUsuario = (TipoUsuario) em.createQuery(jpql).getSingleResult();
        return tipoUsuario;
    }

    public List<String> getTipoDescripcion() {
        String jpql = "SELECT u.descripcion FROM TipoUsuario u ";
        List<String> res = em.createQuery(jpql).getResultList();

        return res;
    }

}
