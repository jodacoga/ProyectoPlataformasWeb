/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.DetalleFactura;
import ec.edu.ups.entidades.EstadoPedido;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.PedidoDetalle;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.facade.CategoriaFacade;
import ec.edu.ups.facade.FacturaFacade;
import ec.edu.ups.facade.PedidoFacade;
import ec.edu.ups.facade.ProductoFacade;
import ec.edu.ups.facade.SucursalFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darwin
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ListarPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private PedidoFacade pedidoFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private SucursalFacade sucursalFacade;
    @EJB
    private FacturaFacade facturaFacade;
    
    private int idPedido;
    private Time tiempoAprox;
    private boolean estado;
    private double distanciaRecorrido;
    private double costoEnvio;
    
    
    List<String> list = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();
    List<PedidoDetalle> detalles = new ArrayList<>();
    

    
    @PostConstruct
    public void init() {
        pedidos = pedidoFacade.getPedido();
    }
    
    public String edit(Pedido p) {
        p.setEditable(true);
        return null;
    }

    public String save(Pedido p) {
        if(p.getEstado().getEtiqueta()=="Cancelado") {
            anular(p.getPedidoFactura().getCodigoFactura());
            
            pedidoFacade.edit(p);
        
            pedidos = pedidoFacade.findAll();
            p.setEditable(false);
            return null;
        } 
        else{
            
        
        pedidoFacade.edit(p);
        
        pedidos = pedidoFacade.findAll();
        p.setEditable(false);
        return null;
        }
        
        }
    
    public void anular(int codigoFactura) {
        Factura f = facturaFacade.getCodigo(codigoFactura);
        f.setEstadoFactura(false);
        List<DetalleFactura> d = f.getFacturadetalle();
        for (int i = 0; i < d.size(); i++) {
            Producto p = productoFacade.getProductoByName(d.get(i).getDescripcion());
            p.setStock(p.getStock() + d.get(i).getCantidad());
            productoFacade.edit(p);            
        }
        facturaFacade.edit(f); 
         
    }
    
    public void listarPedidos() {
        pedidos = pedidoFacade.listar();
        System.out.println(pedidos);
    }

    public void listarPedidos1() {
        pedidos = pedidoFacade.findAll();
        System.out.println("pedidoo "+ pedidos);
    }

    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public List<Pedido> getPedido() {
        return pedidos;
    }

    public void setPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalle> detalles) {
        this.detalles = detalles;
    }

    public PedidoFacade getPedidoFacade() {
        return pedidoFacade;
    }

    public void setPedidoFacade(PedidoFacade pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


}
