/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author khota
 */
public interface IDaoVenta extends IBaseDAO<Venta> {
    List<Venta> findByCliente(long idCliente);

    List<Venta> findByRangoFechas(LocalDate inicio, LocalDate fin);

    Optional<Venta> crearVenta(Cliente cliente, List<ItemVenta> items);

    boolean eliminarVentaYRestaurarInventario(long idVenta);
}