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

    @Column(name = "tipo_producto", nullable = false, length = 50)
    private String tipo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "existencia", nullable = false)
    private int existencia;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "material", length = 100)
    private String material;

    @Column(name = "tamanio", length = 50)
    private String tamanio;

    @Column(name = "categoria", length = 100)
    private String categoria;

    public Producto() {
    }

    public Producto(String tipo, String nombre, double precio, int existencia, boolean activo,
                    String color, String material, String tamanio, String categoria) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.activo = activo;
        this.color = color;
        this.material = material;
        this.tamanio = tamanio;
        this.categoria = categoria;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}