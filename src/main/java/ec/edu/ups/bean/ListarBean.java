/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.facade.ProductoFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author johan
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ListarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProductoFacade productoFacade;

    private String nombre;
    private String categoria;
    private List<Producto> producto;

    public ListarBean() {

    }

    @PostConstruct
    public void init() {
        producto = productoFacade.listar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public void listarPorNombreProducto() {
        producto = productoFacade.buscarporNombreProducto(nombre);
        System.out.println(nombre);
    }

    public void listarPorNombreCategoria() {
        producto = productoFacade.buscarPorCategoria(categoria);
    }

}
