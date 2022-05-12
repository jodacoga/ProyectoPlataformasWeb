package com.mycompany.proyectoplataformasweb.resources;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.TipoUsuario;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.CuentaFacade;
import ec.edu.ups.facade.TipoUsuarioFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author
 */
@Path("jakartaee9")
public class JakartaEE9Resource {

    @EJB
    private UsuarioFacade EJBusuario;

   @EJB
   private CuentaFacade EJBCuenta;

    @EJB
    private TipoUsuarioFacade EJBTipoUsu;

    @GET
    public Response ping() {

        TipoUsuario tipo1 = new TipoUsuario("usuario2");
        Usuario usu1 = new Usuario("johan", "Cordova", "1753803962", Date.from(Instant.MIN), tipo1);
        Cuenta cu1 = new Cuenta("johan@gmail.com", "230994", usu1);
        
        EJBTipoUsu.create(tipo1);
        EJBusuario.create(usu1);
        EJBCuenta.create(cu1);
        
        
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
