/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios;

import java.time.LocalDate;
import java.util.List;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IBaseDAO;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.IEntidad;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;

/**
 *
 * @author khota
 */
public class VentaService {
    
     private final IBaseDAO<IEntidad> ventaDao; // añadir VentaDAO

    public VentaService(IBaseDAO<IEntidad> ventaDao) {
        this.ventaDao = ventaDao;
    }

    public Venta crearVenta(List<ItemVenta> items, Cliente cliente) {
        double total = calcularTotalVenta(items);

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setItems(items);
        venta.setFecha(LocalDate.now());
        venta.setTotal(total);

        ventaDao.save(venta);

        return venta;
    }

    public double calcularTotalVenta(List<ItemVenta> items) {
        return items.stream()
                .mapToDouble(i -> i.getPrecioUnitario() * i.getCantidad())
                .sum();
    }

    public void cancelarVenta(Long idVenta) {
        // cuando  se tengas entidad Venta, búscala por id y márcala como cancelada.
        throw new UnsupportedOperationException(
                "Implementar cancelarVenta cuando exista la entidad Venta.");
    }

    public List<Object> obtenerVentasPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        // filtrar ventas entre esas fechas.
        throw new UnsupportedOperationException(
                "Implementar obtenerVentasPorRangoFechas cuando tengas la entidad Venta.");
    }
    
}
