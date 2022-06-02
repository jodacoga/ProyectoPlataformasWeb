/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.facade.CategoriaFacade;
import ec.edu.ups.facade.ProductoFacade;
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
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private SucursalFacade sucursalFacade;

    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String nombreCategoria;
    private String nombreSucursal;
    List<String> list = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();
    private List<String> sucursales = new ArrayList<>();

    @PostConstruct
    public void init() {
        productos = productoFacade.findAll();
    }

    public String add() throws Exception {

        productoFacade.guardarProducto(nombre, descripcion, precio, stock, nombreCategoria);
        productoFacade.agregarSucursal(nombre, nombreSucursal);

        productos = productoFacade.findAll();

        return "mensaje-exito?faces-redirect=true&texto=Producto Creado con exito";
    }
    
    public String delete(Producto pro) {
        productoFacade.remove(pro);
        //list = sucursalFacade.findAll();
        return null;
    }

    public String edit(Producto p) {
        p.setEditable(true);
        return null;
    }

    public String save(Producto p) {
        productoFacade.edit(p);
        productos = productoFacade.findAll();
        p.setEditable(false);
        return null;
    }

    public List<String> getListaSucursales() {
        sucursales = sucursalFacade.getSucursalNames();

        return sucursales;
    }

    public List<String> getListaCategoria() {
        list = categoriaFacade.getCategoriaNames();
        return list;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
