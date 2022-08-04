/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.TipoUsuario;
import ec.edu.ups.entidades.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author johan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    
    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;
    
    @EJB
    private TipoUsuarioFacade facadeTipo;
    
    
    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
       public Usuario getUsuarioCedula(String cedula) {
        String jpql = "SELECT u FROM Usuario u WHERE u.cedula = '" + cedula+"'";
        Usuario usuario = (Usuario) em.createQuery(jpql).getSingleResult();
        return usuario;
    }

    public List<String> getUsuarioCedulas() {
        String jpql = "SELECT u.cedula FROM Usuario u ";
        List<String> res = em.createQuery(jpql).getResultList();

        return res;
    }
    
    public void guardarUsuario(String nombre, String apellido, String cedula,Date fecha, String tipoUsu) throws Exception {
        Usuario usu = new Usuario();
        usu.setCedula(cedula);
        usu.setApellido(apellido);
        usu.setNombre(nombre);
        usu.setFechaNacimiento(fecha);

        TipoUsuario tipo = facadeTipo.getTipoNombre(tipoUsu);

        if (tipo == null) {
            throw new Exception("El tipo de Usuario no existe");
        }
        usu.setTipoUsuario(tipo);
        List<Usuario> usuarios = tipo.getUsuarios();
        usuarios.add(usu);
        tipo.setUsuarios(usuarios);
        facadeTipo.edit(tipo);
    }
  
    
}
