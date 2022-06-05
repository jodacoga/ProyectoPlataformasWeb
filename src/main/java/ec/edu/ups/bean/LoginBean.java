/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.facade.CuentaFacade;
import ec.edu.ups.util.SessionUtils;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

/**
 *
 * @author johan
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private Cuenta cuenta;
    private String contra;
    private String correo;
    private String nombreUsu;

    @EJB
    private CuentaFacade cuentaFacade;

    @PostConstruct
    public void init() {
        cuenta = new Cuenta();
        System.out.println("INICIANDOOOOO....");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    
    public String login() {
        cuenta = cuentaFacade.getCuentaCorreo(correo);
        nombreUsu=cuenta.getUsuario().getNombre();
        System.out.println(cuenta.toString());
        if (cuenta == null || !cuenta.getContrasena().equals(contra)) {
            return "login?faces-redirect=true";
        }

        HttpSession session = SessionUtils.getSession();
        session.setAttribute("correo", correo);

        if (this.cuenta.getUsuario().getTipoUsuario().getDescripcion().equalsIgnoreCase("Administrador")) {
            return "index?faces-redirect=true";
        }
        if (this.cuenta.getUsuario().getTipoUsuario().getDescripcion().equalsIgnoreCase("Empleado")) {
            return "indexEmpleado?faces-redirect=true";
        }
        System.out.println("No hay rol");
        return "login?faces-redirect=true";
    }

    public String logout() {
        System.out.println("Logout");
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/login?faces-redirect=true";
    }

    public Cuenta cargarCuenta() {
        String correoUsuario = SessionUtils.getUserCorreo();
        return cuentaFacade.getCuentaCorreo(correo);
    }
}
