/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author johan
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private String nombre;
    private String apellido;
    private String cedula;
    private Date fechaNacimiento;
    
    public String add(){
        usuarioFacade.create(new Usuario(nombre, apellido, cedula, fechaNacimiento));
        return null;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
