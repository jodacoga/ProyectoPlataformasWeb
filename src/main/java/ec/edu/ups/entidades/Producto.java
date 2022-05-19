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
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author johan
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoProducto;
    
     private String nombre;
     private String descripcion;
     private double precio;
     //private byte imagen;
     private int stock;
     
     @ManyToOne
     @JoinColumn
     private CategoriaSucursal categoria;
     
     @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
     private DetalleFactura detalleFactura;
     
    public Producto(String nombre, String descripcion, double precio, int stock, CategoriaSucursal categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        //this.imagen = imagen;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto() {
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
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
/**
    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }
**/
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public CategoriaSucursal getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSucursal categoria) {
        this.categoria = categoria;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    @Override
    public String toString() {
        String u = ",Categoria==(null)";
        if (this.categoria != null) {
            u = ", Categoria=(" + this.categoria.getCodigoCategoria()+ ")";
        }
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + u + ", detalleFactura=" + detalleFactura + '}';
    }
     
     
    
    

}

