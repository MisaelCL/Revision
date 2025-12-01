/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.*;
import java.io.Serializable;

// Entidad para unificar los productos de la base de datos, de esta manera aqui heredan Florero, Vela, Maceta, etc.

/**
 *
 * @author khota
 */
@Entity
@Table(name = "Producto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_producto", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Producto implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    protected Long id;

    @Column(nullable = false, length = 100)
    protected String nombre;

    @Column(nullable = false)
    protected double precio;

    @Column(nullable = false)
    protected int existencia;   // para inventario

    @Column(nullable = false)
    protected boolean activo = true;

    protected Producto() {
    }

    protected Producto(String nombre, double precio, int existencia, boolean activo) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.activo = activo;
    }

    @Override
    public Long getId() {
        return id;
    }

    // ====== Getters y setters =======

    public Long getIdProducto() {
        return id;
    }

    public void setIdProducto(Long idProducto) {
        this.id = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}