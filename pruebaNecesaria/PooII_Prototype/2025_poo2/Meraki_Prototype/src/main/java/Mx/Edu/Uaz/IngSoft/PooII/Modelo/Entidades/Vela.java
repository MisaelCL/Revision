/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author khota
 */
@Entity
@Table(name = "Vela")
public class Vela implements IEntidad, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private String color;

    @Column
    private int largo;

    @Column
    private String tipo;

    public Vela() {
    }

    public Vela(Long id, String color, int largo, String tipo) {
        this.id = id;
        this.color = color;
        this.largo = largo;
        this.tipo = tipo;
    }

    public Vela(String color, int largo, String tipo) {
        this.color = color;
        this.largo = largo;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vela{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", largo=" + largo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}