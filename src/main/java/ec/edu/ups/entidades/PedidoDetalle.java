/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

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
 * @author Darwin
 */
@Entity
public class PedidoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoDetalle;

    private String descripcion;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    @OneToOne
    @JoinColumn
    private Producto producto;

    @ManyToOne
    @JoinColumn
    private Pedido pedidoDetalle;

    public PedidoDetalle() {
    }

    public PedidoDetalle(String descripcion, int cantidad, double precioUnitario, double precioTotal, Producto producto, Pedido pedidoDetalle) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.producto = producto;
        this.pedidoDetalle = pedidoDetalle;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(int codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }


    public Pedido getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(Pedido pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        String u = ",pedidoDetalle==(null)";

        if (this.pedidoDetalle != null) {
            u = ", facturadetalle=(" + this.pedidoDetalle.getIdPedido() + ")";
        }
        return "PedidoDetalle{" + "codigoDetalle=" + codigoDetalle + ", descripcion=" + descripcion + u + '}';
    }

}
