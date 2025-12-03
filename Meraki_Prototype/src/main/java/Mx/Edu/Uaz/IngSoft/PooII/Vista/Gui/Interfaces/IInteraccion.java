/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces;

import java.util.List;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;

/**
 *
 * @author khota
 */
public interface IInteraccion {
    void mostrar_Producto(Producto producto);
    Producto obtenerProducto();
    void mostrar_Productos(List<Producto> productosFlorero);
    void setController(IControlador c);
}