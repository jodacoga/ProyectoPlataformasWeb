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
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author johan
 */
@Entity
public class Sucursal implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    private String nombre;
    private String direccion;
    private double latencia;
    private double longitud;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "sucursal")
    private List<Pedido> pedido = new ArrayList<Pedido>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalCategoria")
    private List<CategoriaSucursal> categoriaSucursal = new ArrayList<CategoriaSucursal>();

    public Sucursal() {
    }

    public Sucursal(String nombre, String direccion, double latencia, double longitud) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.latencia = latencia;
        this.longitud = longitud;
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


   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<CategoriaSucursal> getCategoriaSucursal() {
        return categoriaSucursal;
    }

    public void setCategoriaSucursal(List<CategoriaSucursal> categoriaSucursal) {
        this.categoriaSucursal = categoriaSucursal;
    }

   

    @Override
    public String toString() {
        String d = ", categoriaSucursal=(null)";
        if (this.categoriaSucursal != null) {
            d = ", categoriaSucursal=" + this.categoriaSucursal.toString() + ")";
        }
        return "Sucursal{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", latencia=" + latencia + ", longitud=" + longitud + ", pedido=" + pedido + d+ '}';
    }

 

    
    
    
}
