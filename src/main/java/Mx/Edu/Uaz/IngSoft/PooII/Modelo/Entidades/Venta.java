/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author khota
 */

@Entity
@Table(name = "Venta")
public class Venta implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha = LocalDate.now();

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "cancelada", nullable = false)
    private boolean cancelada = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenta> items = new ArrayList<>();

    @Override
    public Long getId() {
        return idVenta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenta> getItems() {
        return items;
    }

    public void setItems(List<ItemVenta> items) {
        this.items = items != null ? items : new ArrayList<>();
        this.items.forEach(i -> i.setVenta(this));
        recalcularTotal();
    }

    public void agregarItem(ItemVenta item) {
        if (item != null) {
            item.setVenta(this);
            this.items.add(item);
            recalcularTotal();
        }
    }

    public void recalcularTotal() {
        this.total = items.stream()
                .mapToDouble(i -> i.getCantidad() * i.getPrecioUnitario())
                .sum();
    }
}