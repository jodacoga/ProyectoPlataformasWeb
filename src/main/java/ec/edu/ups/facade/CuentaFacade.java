package ec.edu.ups.facade;

import ec.edu.ups.entidades.Cuenta;
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

    @PersistenceContext(name = "PlataformasWeb")
    private EntityManager em;

    public List<String> getUsersCedula(String cedula) {

        String jpql1 = "SELECT u.codigo FROM usuario u where u.cedula="+"'"+cedula+"'";
        List<String> res = em.createQuery(jpql1).getResultList();

        return res;

    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
