/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.facade.CategoriaFacade;
import jakarta.ejb.EJB;
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
public class CategoriaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private CategoriaFacade categoriaFacade;
    
    private String nombre;
    private String descripcion;
    private Sucursal sucursal;

    public String add(){
        
        return null;
    }
    
  
}
