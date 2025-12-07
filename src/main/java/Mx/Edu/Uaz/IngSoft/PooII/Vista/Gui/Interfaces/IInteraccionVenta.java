/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControladorVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;

import java.util.List;

/**
 *
 * @author khota
 */
public interface IInteraccionVenta {
    Venta obtenerVenta();

    void mostrarVenta(Venta venta);

    void mostrarVentas(List<Venta> ventas);

    void mostrarClientes(List<Cliente> clientes);

    void mostrarProductos(List<Producto> productos);

    void mostrarMensaje(String msg);

    void setController(IControladorVenta controlador);
}