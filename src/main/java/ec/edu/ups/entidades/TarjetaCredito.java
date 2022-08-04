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
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author johan
 */
@Entity
@Table(name="TarjetaCredito")
public class TarjetaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTarjeta;
    private String numeroTarjeta;
    private Date fechaCa;
    private String codigoSegu;
    private String nombreTarj;

    @ManyToOne
    @JoinColumn
    private Cuenta cuenta;

    public TarjetaCredito() {
    }

    public TarjetaCredito(String numeroTarjeta, Date fechaCa, String codigoSegu, String nombreTarj, Cuenta cuenta) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCa = fechaCa;
        this.codigoSegu = codigoSegu;
        this.nombreTarj = nombreTarj;
        this.cuenta = cuenta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Date getFechaCa() {
        return fechaCa;
    }

    public void setFechaCa(Date fechaCa) {
        this.fechaCa = fechaCa;
    }

    public String getCodigoSegu() {
        return codigoSegu;
    }

    public void setCodigoSegu(String codigoSegu) {
        this.codigoSegu = codigoSegu;
    }

    public String getNombreTarj() {
        return nombreTarj;
    }

    public void setNombreTarj(String nombreTarj) {
        this.nombreTarj = nombreTarj;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
