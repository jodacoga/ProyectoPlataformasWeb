/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Darwin
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SucursalBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //@EJB
    //private SucursalFacade sucursalFacade;
    
    private String nombre;
    private String direccion;
    private double latencia;
    private double longitud;
    
    public String add(){
        return null;
    }
    
}
