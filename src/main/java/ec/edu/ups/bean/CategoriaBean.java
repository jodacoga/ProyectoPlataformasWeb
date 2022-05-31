/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.facade.CategoriaFacade;
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
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private SucursalFacade sucursalFacade;

    private String nombre;
    private String descripcion;

    List<String> list = new ArrayList<>();
    List<CategoriaProducto> categorias = new ArrayList<>();

    @PostConstruct
    public void init() {
        categorias = categoriaFacade.findAll();
    }

    public String add() throws Exception {
        categoriaFacade.create(new CategoriaProducto(nombre, descripcion));
        //categoriaFacade.guardarCategoria(nombre, descripcion);
        categorias = categoriaFacade.findAll();
        return "mensaje-exito?faces-redirect=true&texto=Categoria Creada con exito";
    }

    public String delete(CategoriaProducto cs) {
        categoriaFacade.remove(cs);
        //list = sucursalFacade.findAll();
        return null;
    }

    public String edit(CategoriaProducto c) {
        c.setEditable(true);
        return null;
    }

    public String save(CategoriaProducto p) {
        categoriaFacade.edit(p);
        categorias = categoriaFacade.findAll();
        p.setEditable(false);
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

    public List<CategoriaProducto> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaProducto> categorias) {
        this.categorias = categorias;
    }

}
