/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author khota
 */
@Entity
@Table(name = "ItemVenta")
public class ItemVenta implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Override
    public Long getId() {
        return id;
    }

    public Long getIdItem() {
        return id;
    }

    public void setIdItem(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
}