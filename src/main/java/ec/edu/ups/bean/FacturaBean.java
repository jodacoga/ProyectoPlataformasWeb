/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.DetalleFactura;
import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.TipoPago;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.CuentaFacade;
import ec.edu.ups.facade.DetalleFacturaFacade;
import ec.edu.ups.facade.FacturaFacade;
import ec.edu.ups.facade.ProductoFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EJB
    private FacturaFacade facturaFacade;
    @EJB
    private DetalleFacturaFacade detalleFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private CuentaFacade cuentaFacade;
    
    private int codigoFactura;
    private Date fechaFactura;
    private double subtotal;
    private double iva;
    private double total;
    private boolean estadoFactura;
    
    private int codigoDetalle;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private double precioTotal;
    private String cedulaPersona;
    private int numeroCuenta;
    private String nombreProducto;
    
    Usuario usuario;
    Producto producto;
    Cuenta cuenta;
    List<DetalleFactura> detalles = new ArrayList<>();
    List<DetalleFactura> detallesvista = new ArrayList<>();
    List<Factura> facturas = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        facturas = facturaFacade.findAll();
    }
    
    public FacturaFacade getFacturaFacade() {
        return facturaFacade;
    }
    
    public void setFacturaFacade(FacturaFacade facturaFacade) {
        this.facturaFacade = facturaFacade;
    }
    
    public DetalleFacturaFacade getDetalleFacade() {
        return detalleFacade;
    }
    
    public void setDetalleFacade(DetalleFacturaFacade detalleFacade) {
        this.detalleFacade = detalleFacade;
    }
    
    public Date getFechaFactura() {
        return fechaFactura;
    }
    
    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public double getIva() {
        return iva;
    }
    
    public void setIva(double iva) {
        this.iva = iva;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public boolean isEstadoFactura() {
        return estadoFactura;
    }
    
    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
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
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getPrecioTotal() {
        return precioTotal;
    }
    
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public List<DetalleFactura> getDetalles() {
        return detalles;
    }
    
    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Cuenta getCuenta() {
        return cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public List<Factura> getFacturas() {
        return facturas;
    }
    
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    public String getCedulaPersona() {
        return cedulaPersona;
    }
    
    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }
    
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public int getCodigoFactura() {
        return codigoFactura;
    }
    
    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }
    
    public List<DetalleFactura> getDetallesvista() {
        return detallesvista;
    }
    
    public void setDetallesvista(List<DetalleFactura> detallesvista) {
        this.detallesvista = detallesvista;
    }
    
    public void cargarDatosUsuario() {
        System.out.println("LLega hasta aki " + cedulaPersona);
        if (cedulaPersona != null) {
            System.out.println("la cedula es " + cedulaPersona);
            usuario = usuarioFacade.getUsuarioCedula(cedulaPersona);
            System.out.println("El Usuario es: !!!!  " + usuario.getCedula());
            
        }
        
    }
    
    public void cargarDatosCuenta() {
        System.out.println("LLega hasta aki " + numeroCuenta);
        if (numeroCuenta != 0) {
            System.out.println("la cuenta es " + numeroCuenta);
            cuenta = cuentaFacade.getCuentaNumero(numeroCuenta);
            System.out.println("La cuenta es: !!!!  " + cuenta.getCodigoCuenta());
            
        }
        
    }
    
    public void cargarDatosProducto() {
        System.out.println("LLega hasta aki " + nombreProducto);
        if (nombreProducto != null) {
            producto = productoFacade.getProductoByName(nombreProducto);
            System.out.println("El producto es: !!!!  " + producto.getNombre());
            
        }
        
    }
    
    public void calcularTotalProducto() {
        if (cantidad < producto.getStock()) {
            if (producto.getPrecio() != 0) {
                precioUnitario = producto.getPrecio();
                precioTotal = producto.getPrecio() * cantidad;
                
            }
            
        }
    }
    
    public void addDetalle() {
        
        DetalleFactura detalle = new DetalleFactura();
        detalle.setDescripcion(nombreProducto);
        detalle.setPrecioUnitario(precioUnitario);
        detalle.setCantidad(cantidad);
        detalle.setPrecioTotal(precioTotal);
        System.out.println("PRECIO ********** ** : " + precioTotal);
        detalles.add(detalle);
        
        for (int i = 0; i < detalles.size(); i++) {
            subtotal = subtotal + detalles.get(i).getPrecioTotal();
            System.out.println("*******TOTAL *** : " + subtotal);
        }
        iva = (subtotal * 0.12);
        total = (subtotal + iva);
        
    }
    
    public String add() {
        Factura factura = new Factura();
        factura.setFechaFactura(new Date());
        factura.setCuentaFactura(cuenta);
        factura.setUsuarioFactura(usuario);
        factura.setFacturadetalle(detalles);
        factura.setEstadoFactura(true);
        factura.setTipoPago(new TipoPago(1, "Corriente"));
        factura.setSubtotal(subtotal);
        factura.setIva(iva);
        factura.setTotal(total);
        facturaFacade.create(factura);
        
        for (int i = 0; i < detalles.size(); i++) {
            detalles.get(i).setFacturadetalle(factura);
            Producto p = productoFacade.getProductoByName(detalles.get(i).getDescripcion());
            p.setStock(p.getStock() - detalles.get(i).getCantidad());
            detalleFacade.edit(detalles.get(i));
            productoFacade.edit(p);
            
        }
        cuenta = new Cuenta();
        usuario = new Usuario();
        detalles = new ArrayList<>();
        subtotal = 0;
        iva = 0;
        total = 0;
        producto = new Producto();
        cantidad = 0;
        nombreProducto = "";
        numeroCuenta = 0;
        cedulaPersona = "";
        precioTotal = 0;
        facturas = facturaFacade.findAll();
        
        return "mensaje-exito?faces-redirect=true&texto=Se ha generado la factura";
        
    }

    public String addFac() {
        Factura factura = new Factura();
        factura.setFechaFactura(new Date());
        factura.setCuentaFactura(cuenta);
        factura.setUsuarioFactura(usuario);
        factura.setFacturadetalle(detalles);
        factura.setEstadoFactura(true);
        factura.setTipoPago(new TipoPago(1, "Corriente"));
        factura.setSubtotal(subtotal);
        factura.setIva(iva);
        factura.setTotal(total);
        facturaFacade.create(factura);
        
        for (int i = 0; i < detalles.size(); i++) {
            detalles.get(i).setFacturadetalle(factura);
            Producto p = productoFacade.getProductoByName(detalles.get(i).getDescripcion());
            p.setStock(p.getStock() - detalles.get(i).getCantidad());
            detalleFacade.edit(detalles.get(i));
            productoFacade.edit(p);
            
        }
        cuenta = new Cuenta();
        usuario = new Usuario();
        detalles = new ArrayList<>();
        subtotal = 0;
        iva = 0;
        total = 0;
        producto = new Producto();
        cantidad = 0;
        nombreProducto = "";
        numeroCuenta = 0;
        cedulaPersona = "";
        precioTotal = 0;
        facturas = facturaFacade.findAll();
        
        return "mensaje-exitoEmpleado?faces-redirect=true&texto=Se ha generado la factura";
        
    }

    public String edit(Factura f) {
        f.setEditable(true);
        return null;
    }
    
    public String save(Factura f) {
        facturaFacade.edit(f);
        facturas = facturaFacade.findAll();
        f.setEditable(false);
        return null;
    }
    
    public String verDetalles(int codigo) {
        return "detalles?faces-redirect=true&codigo=" + codigo;
    }

    public void loadDetalles() {
        Factura f = facturaFacade.getCodigo(codigoFactura);
        detallesvista = f.getFacturadetalle();
    }

    public String verDetallesEmpleado(int codigo) {
        return "detallesEmpleado?faces-redirect=true&codigo=" + codigo;
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
        facturas = facturaFacade.findAll();
        
        
        
    }
}
