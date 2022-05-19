/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.facade.SucursalFacade;

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
 * @author Darwin
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SucursalBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private SucursalFacade sucursalFacade;
    private List<Sucursal> list = new ArrayList<>();
    private String nombre;
    private String direccion;
    private double latencia;
    private double longitud;

    @PostConstruct
    public void init() {
        list = sucursalFacade.findAll();

    }
     
    public String add() {
        sucursalFacade.create(new Sucursal(nombre, direccion, latencia, longitud));
        return null;
    }

    public String delete(Sucursal su) {
        sucursalFacade.remove(su);
        list = sucursalFacade.findAll();
        return null;
    }

    public String edit(Sucursal su) {
        sucursalFacade.edit(su);
        list = sucursalFacade.findAll();
        return null;
    }

    public SucursalFacade getSucursalFacade() {
        return sucursalFacade;
    }

    public void setSucursalFacade(SucursalFacade sucursalFacade) {
        this.sucursalFacade = sucursalFacade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatencia() {
        return latencia;
    }

    public void setLatencia(double latencia) {
        this.latencia = latencia;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

}
