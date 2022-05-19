/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.facade.CategoriaFacade;
import ec.edu.ups.facade.ProductoFacade;

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
public class ProductoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String nombreCategoria;
    List<String> list = new ArrayList<>();
    
    public String add() throws Exception {
        productoFacade.guardarProducto(nombre, descripcion, precio, stock, nombreCategoria);
        return null;
    }
    
    public String delete(Producto pro) {
        productoFacade.remove(pro);
        //list = sucursalFacade.findAll();
        return null;
    }
    
    public String edit(Producto pro) {
        productoFacade.edit(pro);
        //list = sucursalFacade.findAll();
        return null;
    }

    public List<String> getListaCategoria(){
        list = categoriaFacade.getCategoriaNames();
        return list;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
}
