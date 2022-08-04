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
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author johan
 */
@Entity
@Table(name="TipoPago")
public class TipoPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoTipo;
    
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPago")
    private Set<Factura> facturatipo = new HashSet<Factura>();    

    public TipoPago() {
    }

    public TipoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPago(int codigoTipo, String descripcion) {
        this.codigoTipo = codigoTipo;
        this.descripcion = descripcion;
    }
    

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Factura> getFacturatipo() {
        return facturatipo;
    }

    public void setFacturatipo(Set<Factura> facturatipo) {
        this.facturatipo = facturatipo;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "codigoTipo=" + codigoTipo + ", descripcion=" + descripcion + ", facturatipo=" + facturatipo + '}';
    }
    
    
    

}
