/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.TipoUsuario;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.TipoUsuarioFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate fechaNacimiento;
    private String tipo;

    List<String> list = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();

    @PostConstruct
    public void init() {
        usuarios = usuarioFacade.findAll();

    }

    public String add() throws Exception {
        fechaNacimiento = java.time.LocalDate.now();
        usuarioFacade.guardarUsuario(nombre, apellido, cedula, fechaNacimiento, tipo);
        usuarios = usuarioFacade.findAll();
        return "mensaje-exito?faces-redirect=true&texto=Persona ingresada con exito";
    }
    public String addCliente() throws Exception {
        fechaNacimiento = java.time.LocalDate.now();
        tipo="Cliente";
        usuarioFacade.guardarUsuario(nombre, apellido, cedula, fechaNacimiento, tipo);
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
