
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author johan
 */
@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;

    private Time tiempoAprox;

   @Enumerated(value = EnumType.ORDINAL)
   private EstadoPedido estado;
 
    @ManyToOne
    @JoinColumn
    private Sucursal sucursal;

    private double distanciaRecorrido;
    private double costoEnvio;
    
    @Transient
    private boolean editable;
    
    @ManyToOne
    @JoinColumn
    private Cuenta cuentaPedido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Factura pedidoFactura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoDetalle")
    private List<PedidoDetalle> pedidoDetalle;

    public Pedido() {
        estado= EstadoPedido.ENVIADO;
    }

    public Pedido(Time tiempoAprox, EstadoPedido estado, Sucursal sucursal, double distanciaRecorrido, double costoEnvio, Cuenta cuentaPedido, Factura factura) {
        this.tiempoAprox = tiempoAprox;
        this.estado = estado;
        this.sucursal = sucursal;
        this.distanciaRecorrido = distanciaRecorrido;
        this.costoEnvio = costoEnvio;
        this.cuentaPedido = cuentaPedido;
        this.pedidoFactura = factura;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }


    public Time getTiempoAprox() {
        return tiempoAprox;
    }

    public void setTiempoAprox(Time tiempoAprox) {
        this.tiempoAprox = tiempoAprox;
    }

    public EstadoPedido isEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
    }

    public double getDistanciaRecorrido() {
        return distanciaRecorrido;
    }

    public void setDistanciaRecorrido(double distanciaRecorrido) {
        this.distanciaRecorrido = distanciaRecorrido;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cuenta getCuentaPedido() {
        return cuentaPedido;
    }

    public void setCuentaPedido(Cuenta cuentaPedido) {
    this.cuentaPedido = cuentaPedido;
    }


    public Factura getPedidoFactura() {
        return pedidoFactura;
    }

    public void setPedidoFactura(Factura pedidoFactura) {
        this.pedidoFactura = pedidoFactura;
    }

    public List<PedidoDetalle> getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public void calcularSubtotal(){

    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        String s =",sucursal==(null)";
        String c =",cuentaPedido==(null)";
        String d = ", pedidoDetalle=(null)";
        if (this.pedidoDetalle != null) {
            d = ", pedidoDetalle=" + this.pedidoDetalle.toString() + ")";
        }
        if (this.sucursal != null) {
            s = ", Sucursal=(" + this.sucursal.getCodigo() + ")";
        }
        if (this.cuentaPedido != null) {
            c = ", Cuenta=(" + this.cuentaPedido.getCodigoCuenta() + ")";
        }
        return "Pedido{" + "idPedido=" + idPedido + ", tiempoAprox=" + tiempoAprox + ", estado=" + estado.toString() + s + ", distanciaRecorrido=" + distanciaRecorrido + ", costoEnvio=" + costoEnvio  + c + d+'}';
    }
    
}