/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.sql.Time;

/**
 *
 * @author johan
 */

public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;
    
    private Time tiempoAprox;
    private boolean estado;
    
    @ManyToOne
    @JoinColumn
    private Sucursal sucursal;
    
    private double distanciaRecorrido;
    private double costoEnvio;
    
    @ManyToOne
    @JoinColumn
    private Cuenta cuenta;
    
    @OneToOne
    @JoinColumn
    private Factura factura;

    public Pedido() {
    }

    public Pedido(Time tiempoAprox, boolean estado, Sucursal sucursal, double distanciaRecorrido, double costoEnvio, Cuenta cuenta, Factura factura) {
        this.tiempoAprox = tiempoAprox;
        this.estado = estado;
        this.sucursal = sucursal;
        this.distanciaRecorrido = distanciaRecorrido;
        this.costoEnvio = costoEnvio;
        this.cuenta = cuenta;
        this.factura = factura;
    }

    public Time getTiempoAprox() {
        return tiempoAprox;
    }

    public void setTiempoAprox(Time tiempoAprox) {
        this.tiempoAprox = tiempoAprox;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
        return "Pedido{" + "tiempoAprox=" + tiempoAprox + ", estado=" + estado + ", sucursal=" + sucursal + ", distanciaRecorrido=" + distanciaRecorrido + ", costoEnvio=" + costoEnvio + ", cuenta=" + cuenta + ", factura=" + factura + '}';
    }
    
    
}
