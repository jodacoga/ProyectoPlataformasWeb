/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Darwin
 */

public enum EstadoPedido {
    ENVIADO("Enviado"),
    RECEPTADO("Receptado"),
    CANCELADO("Cancelado"),
    EN_PROCESO("En proceso"),
    EN_CAMINO("En caminado"),
    FINALIZADO("Finalizado");
    
    private String etiqueta;  
    
    private EstadoPedido(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" +
                "etiqueta='" + etiqueta + '\'' +
                '}';
    } 
}
