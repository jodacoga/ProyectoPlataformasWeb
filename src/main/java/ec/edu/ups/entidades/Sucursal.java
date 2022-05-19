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
import java.util.HashSet;
import java.util.Set;

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
    private Set<Pedido> pedido = new HashSet<Pedido>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalCategoria")
    private Set<CategoriaSucursal> categoriaSucursal = new HashSet<CategoriaSucursal>();

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


    public Set<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(Set<Pedido> pedido) {
        this.pedido = pedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Set<CategoriaSucursal> getCategoriaSucursal() {
        return categoriaSucursal;
    }

    public void setCategoriaSucursal(Set<CategoriaSucursal> categoriaSucursal) {
        this.categoriaSucursal = categoriaSucursal;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", latencia=" + latencia + ", longitud=" + longitud + ", pedido=" + pedido + ", categoriaSucursal=" + categoriaSucursal + '}';
    }

 

    
    
    
}
