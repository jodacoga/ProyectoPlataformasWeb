/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author johan
 */
@Entity
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCuenta;
    
    private String correo;
    private String contrasena;

    @OneToOne
    @JoinColumn
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private Set<TarjetaCredito> tarjetaC = new HashSet<TarjetaCredito>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaPedido")
    private Set<Pedido> pedido = new HashSet<Pedido>();

    public Cuenta() {
    }

    public Cuenta(String correo, String contrasena, Usuario usuario) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<TarjetaCredito> getTarjetaC() {
        return tarjetaC;
    }

    public void setTarjetaC(Set<TarjetaCredito> tarjetaC) {
        this.tarjetaC = tarjetaC;
    }

    public Set<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(Set<Pedido> pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "correo=" + correo + ", contrasena=" + contrasena + ", usuario=" + usuario + ", tarjetaC=" + tarjetaC + ", pedido=" + pedido + '}';
    }

   

}
