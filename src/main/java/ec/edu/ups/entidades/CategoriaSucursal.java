/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author johan
 */
@Entity
public class CategoriaSucursal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCategoria;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn
    private Sucursal sucursalCategoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Producto> producto = new ArrayList<Producto>();

    public CategoriaSucursal() {
    }

    public CategoriaSucursal(String nombre, String descripcion, Sucursal sucursalCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sucursalCategoria = sucursalCategoria;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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

    public Sucursal getSucursalCategoria() {
        return sucursalCategoria;
    }

    public void setSucursalCategoria(Sucursal sucursalCategoria) {
        this.sucursalCategoria = sucursalCategoria;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        String u = ",sucursalCategoria==(null)";
        if (this.sucursalCategoria != null) {
            u = ", sucursalCategoria=(" + this.sucursalCategoria.getCodigo() + ")";
        }
        String d = ", producto=(null)";
        if (this.producto != null) {
            d = ", producto=" + this.producto.toString() + ")";
        }
        return "CategoriaSucursal{" + "codigoCategoria=" + codigoCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + u + d + '}';
    }

}
