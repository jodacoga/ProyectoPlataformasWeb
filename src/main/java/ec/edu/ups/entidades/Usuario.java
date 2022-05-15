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

/**
 *
 * @author johan
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombre;
    private String apellido;
    
    @Column(unique=true)
    private String cedula;
    
    private Date fechaNacimiento;
    
    @ManyToOne
    @JoinColumn
    private TipoUsuario tipoUsuario;
    
    @ManyToOne
    @JoinColumn
    private Sucursal sucursalUsuario;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Cuenta cuenta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFactura")
    private Factura factura;
    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String cedula, Date fechaNacimiento, TipoUsuario tipoUsuario, Sucursal sucursalUsuario, Cuenta cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoUsuario = tipoUsuario;
        this.sucursalUsuario = sucursalUsuario;
        this.cuenta = cuenta;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Sucursal getSucursalUsuario() {
        return sucursalUsuario;
    }

    public void setSucursalUsuario(Sucursal sucursalUsuario) {
        this.sucursalUsuario = sucursalUsuario;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", fechaNacimiento=" + fechaNacimiento + ", tipoUsuario=" + tipoUsuario + ", sucursalUsuario=" + sucursalUsuario + ", cuenta=" + cuenta + '}';
    }

   

    
    
    
    
    

     



   
}
