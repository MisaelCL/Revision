/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author khota
 */
public interface IControladorVenta {
    void guardarVenta(Venta venta);

    void crearVenta(Cliente cliente, List<ItemVenta> items);

    void cancelarVenta(long idVenta);

    List<Venta> listarVentas();

    List<Venta> listarPorCliente(long idCliente);

    List<Venta> listarPorRangoFechas(LocalDate inicio, LocalDate fin);

    void buscarVenta(long idVenta);

    void limpiarVentaActual();
}