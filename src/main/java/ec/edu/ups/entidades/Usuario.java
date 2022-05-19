/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author johan
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true)
    private String cedula;
    
    private String nombre;
    private String apellido;

    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn
    private TipoUsuario tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Cuenta cuenta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFactura")
    private List<Factura> facturaUsuario = new ArrayList<Factura>();

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = java.time.LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Factura> getFacturaUsuario() {
        return facturaUsuario;
    }

    public void setFacturaUsuario(List<Factura> facturaUsuario) {
        this.facturaUsuario = facturaUsuario;
    }

  

    @Override
    public String toString() {
        String u = ",tipoUsuario==(null)";
        if (this.tipoUsuario != null) {
            u = ", tipoUsuario=(" + this.tipoUsuario.getIdTipo() + ")";
        }
        String d = ", facturaUsuario=(null)";
        if (this.facturaUsuario != null) {
            d = ", facturaUsuario=" + this.facturaUsuario.toString() + ")";
        }
        return "Usuario{" + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", fechaNacimiento=" + fechaNacimiento + u + ", cuenta=" + cuenta + d + '}';
    }

}
