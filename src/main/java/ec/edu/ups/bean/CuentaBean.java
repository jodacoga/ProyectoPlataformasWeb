/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.CuentaFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CuentaBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
        
    @EJB
    private CuentaFacade cuentaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
        
    private int codigo;
    private String correo;
    private String contrasena;
        
    private String cedulaCliente;
        
    Usuario usuario = new Usuario();
    List<String> list = new ArrayList<>();
    Cuenta cuenta = new Cuenta();
    List<Cuenta> cuentas = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        cuentas = cuentaFacade.findAll();
    }
        
    public String addCuenta() throws Exception{
        usuario = usuarioFacade.getUsuarioCedula(cedulaCliente);
        Cuenta cuenta = new Cuenta(correo, contrasena, usuario);
        cuentaFacade.create(cuenta);
        cuentas = cuentaFacade.findAll();
        //cuentaFacade.guardarCuenta(correo, contrasena, cedulaCliente);
        //cuenta = cuentaFacade.findAll();
        return "mensaje-exito?faces-redirect=true&texto=Cuenta ingresada con exito";
    }
    
    public String buscarCorreo() throws Exception{
        cuentaFacade.getUsersCorreo(correo);
        return null;
    }
    
    public String delete(Cuenta pro) {
        cuentaFacade.remove(pro);
        //list = sucursalFacade.findAll();
        return null;
    }
    
    public String edit(Cuenta p) {
	p.setEditable(true);
	return null;
    }

    public String save(Cuenta p) {
        cuentaFacade.edit(p);
        //cuenta= productoFacade.findAll();
	p.setEditable(false);
	return null;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }


    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void cargarDatosUsuario() {
        System.out.println("LLega hasta aki " + cedulaCliente);
        if (cedulaCliente != null) {
            System.out.println("la cedula es " + cedulaCliente);
            usuario = usuarioFacade.getUsuarioCedula(cedulaCliente);
            System.out.println("El Usuario es: !!!!  " + usuario.getCedula());

        }

    }
        
        
}
