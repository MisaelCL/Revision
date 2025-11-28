/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity; 
import java.io.Serializable;

/**
 *
 * @author khota
 */
@Entity
@Table(name = "Florero")
public class Florero implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private String color;

    @Column
    private int largo;

    @Column
    private String material;

    public Florero() {
    }

    public Florero(Long id, String color, int largo, String material) {
        this.id = id;
        this.color = color;
        this.largo = largo;
        this.material = material;
    }

    public Florero(String color, int largo, String material) {
        this.color = color;
        this.largo = largo;
        this.material = material;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", color='" + color + '\'' +
                ", largo=" + largo +
                ", material='" + material + '\'' +
                '}';
    }
}