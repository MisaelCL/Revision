/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.*;

/**
 *
 * @author khota
 */
@Entity
@DiscriminatorValue("FLORERO")
public class Florero extends Producto {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false)
    private int largo;

    @Column(nullable = false, length = 50)
    private String material;

    public Florero() {
        super();
    }

    public Florero(String nombre, double precio, int existencia, boolean activo,
                   String color, int largo, String material) {
        super(nombre, precio, existencia, activo);
        this.color = color;
        this.largo = largo;
        this.material = material;
    }

    public Florero(String nombre, double precio, int existencia,
                   String color, int largo, String material) {
        this(nombre, precio, existencia, true, color, largo, material);
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Florero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", largo=" + largo +
                ", material='" + material + '\'' +
                '}';
    }
}