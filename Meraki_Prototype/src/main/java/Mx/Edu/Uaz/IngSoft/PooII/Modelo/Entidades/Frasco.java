/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
/**
 *
 * @author khota
 */
@Entity
@DiscriminatorValue("FRASCO")
public class Frasco extends Producto implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false)
    private int largo;

    @Column(nullable = false, length = 50)
    private String tipo;

    public Frasco() {
        super();
    }

    public Frasco(String nombre, double precio, int existencia, boolean activo,
                  String color, int largo, String tipo) {
        super(nombre, precio, existencia, activo);
        this.color = color;
        this.largo = largo;
        this.tipo = tipo;
    }

    public Frasco(String nombre, double precio, int existencia,
                  String color, int largo, String tipo) {
        this(nombre, precio, existencia, true, color, largo, tipo);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Frasco{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", largo=" + largo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}