/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.facade.CuentaFacade;
import ec.edu.ups.facade.UsuarioFacade;
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
        List<String> list = new ArrayList<>();
        Cuenta cuenta = new Cuenta();
     
//        public Usuario codigoUsuario(){
//            codigo = (Usuario) facadeCuenta.getUsersCedula(cedula);
//            if (codigo == null){
//                System.out.println("No existe");
//            }else{
//                System.out.println("Creado Exitoso");
//            }
//            return null;
//        }
        
    public String addCuenta() throws Exception{
        cuentaFacade.guardarCuenta(correo, contrasena, cedulaCliente);
        //cuenta = cuentaFacade.findAll();
        return null;
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


        
        
}
