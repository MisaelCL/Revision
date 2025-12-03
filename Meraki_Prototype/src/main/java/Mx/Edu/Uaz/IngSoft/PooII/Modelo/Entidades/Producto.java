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
@Table(name = "Producto")
public class Producto implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "tipo_producto", nullable = false, length = 20)
    private String tipoProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int existencia;

    @Column(nullable = false)
    private boolean activo = true;

    @Column(length = 50)
    private String color;

    @Column
    private Integer largo;

    @Column(length = 50)
    private String material;

    @Column(length = 50)
    private String tipo;

    public Producto() {
    }

    public Producto(String tipoProducto, String nombre, double precio, int existencia, boolean activo,
                    String color, Integer largo, String material, String tipo) {
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.activo = activo;
        this.color = color;
        this.largo = largo;
        this.material = material;
        this.tipo = tipo;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getIdProducto() {
        return id;
    }

    public void setIdProducto(Long idProducto) {
        this.id = idProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}