/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;


/**
 *
 * @author khota
 */
public interface IControlador {
    void buscarProducto(long id);
    void guardarProducto(Producto producto);
    void listarProductos();
    void eliminarProducto(long id);
    void actualizarProducto(Producto producto);
}