package ec.edu.ups.facade;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author johan
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(name = "PracticaPlataformasWeb")
    private EntityManager em;

    @EJB
    private UsuarioFacade usuarioFacade;

    public CuentaFacade() {
        super(Cuenta.class);
    }

    public void guardarCuenta(String correo, String contrasena, String cedulaCliente) throws Exception {
        Cuenta c = new Cuenta();
        c.setCorreo(correo);
        c.setContrasena(contrasena);
        Usuario usu = usuarioFacade.getUsuarioCedula(cedulaCliente);
        if (usu == null) {
            throw new Exception("Cliente no registrado");
        }
        //c.setUsuario(usu);
        usu.setCuenta(c);
        usuarioFacade.edit(usu);
    }

    public List<String> getUsersCedula(String cedula) {

        String jpql1 = "SELECT u.codigo FROM usuario u where u.cedula=" + "'" + cedula + "'";
        List<String> res = em.createQuery(jpql1).getResultList();

        return res;
    }

    //Para Login
    public List<String> getUsersCorreo(String correo) {

        String jpql1 = "SELECT u.codigo FROM usuario u where u.correo=" + "'" + correo + "'";
        List<String> res = em.createQuery(jpql1).getResultList();
        return res;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Cuenta getCuentaNumero(int numero) {
        String jpql = "SELECT u FROM Cuenta u WHERE u.codigoCuenta = " + numero;
        Cuenta cuenta = (Cuenta) em.createQuery(jpql).getSingleResult();
        return cuenta;
    }

    public Cuenta getCuentaCorreo(String correo) {
        String jpql = "SELECT c FROM Cuenta c WHERE c.correo = '" + correo + "'";
        Cuenta cuenta = (Cuenta) em.createQuery(jpql).getSingleResult();
        return cuenta;

    }
}
