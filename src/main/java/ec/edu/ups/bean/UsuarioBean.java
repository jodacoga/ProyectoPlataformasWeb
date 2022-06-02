/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.TipoUsuarioFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author johan
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private TipoUsuarioFacade tipoUsuarioFacade;

    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaNacimiento;
    private String tipo;
    
    Usuario usuario;
    Cuenta cuenta;
    
    List<String> list = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();

    @PostConstruct
    public void init() {
        usuarios = usuarioFacade.findAll();

    }

    public String add() throws Exception {
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
        usuarioFacade.guardarUsuario(nombre, apellido, cedula, fecha, tipo);
        usuarios = usuarioFacade.findAll();
        return "mensaje-exito?faces-redirect=true&texto=Persona ingresada con exito";
    }

    public String addCliente() throws Exception {
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
        tipo = "Cliente";
        usuarioFacade.guardarUsuario(nombre, apellido, cedula, fecha, tipo);
        usuarios = usuarioFacade.findAll();
        return "mensaje-exitoEmpleado?faces-redirect=true&texto=Persona ingresada con exito";
    }

    public String edit(Usuario u) {
        u.setEditable(true);
        return null;
    }

    public String save(Usuario u) {
        usuarioFacade.edit(u);
        usuarios = usuarioFacade.findAll();
        u.setEditable(false);
        return null;
    }

    public List<String> getlistaTipo() {

        list = tipoUsuarioFacade.getTipoDescripcion();

        return list;
    }
    
    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void cargarDatosUsuario() {
        System.out.println("LLega hasta aki " + cedula);
        if (cedula != null) {
            System.out.println("la cedula es " + cedula);
            usuario = usuarioFacade.getUsuarioCedula(cedula);
            System.out.println("El Usuario es: !!!!  " + usuario.getCedula());
        }
    }

}
