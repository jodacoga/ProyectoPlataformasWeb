/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.CategoriaSucursal;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.facade.CategoriaFacade;
import ec.edu.ups.facade.SucursalFacade;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @EJB
    private SucursalFacade sucursalFacade;
    
    private String nombre;
    private String descripcion;
    private String nombreSucursal;
    List<String> list = new ArrayList<>();
    
    public String add() throws Exception {
        categoriaFacade.guardarCategoria(nombre, descripcion, nombreSucursal);
        return null;
    }
    
    public String delete(CategoriaSucursal cs) {
        categoriaFacade.remove(cs);
        //list = sucursalFacade.findAll();
        return null;
    }
    
    public String edit(CategoriaSucursal cs) {
        categoriaFacade.edit(cs);
        //list = sucursalFacade.findAll();
        return null;
    }
    
    public List<String> getlistaSucursal() {
        
        list = sucursalFacade.getSucursalNames();
        return list;
    }
    
    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }
    
    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombreSucursal() {
        return nombreSucursal;
    }
    
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
    
}
