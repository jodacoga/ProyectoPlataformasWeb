/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.CuentaFacade;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;

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
        private CuentaFacade facadeCuenta;
        
        private int codigo;
        private String cedula;
        private String correo;
        private String contrasena;
        
        
     
//        public Usuario codigoUsuario(){
//            codigo = (Usuario) facadeCuenta.getUsersCedula(cedula);
//            if (codigo == null){
//                System.out.println("No existe");
//            }else{
//                System.out.println("Creado Exitoso");
//            }
//            return null;
//        }
        
        public String addCuenta(){
//            facadeCuenta.create(new Cuenta(correo, contrasena, cedula));
            return null;
        }

    public CuentaFacade getFacadeCuenta() {
        return facadeCuenta;
    }

    public void setFacadeCuenta(CuentaFacade facadeCuenta) {
        this.facadeCuenta = facadeCuenta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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


        
        
}
