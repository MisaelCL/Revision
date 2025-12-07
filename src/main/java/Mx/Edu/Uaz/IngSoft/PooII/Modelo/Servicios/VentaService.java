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
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Mensajes;

/**
 *
 * @author khota
 */
public class VentaService {
    
     private final IBaseDAO<IEntidad> ventaDao;

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
        throw new UnsupportedOperationException(
                Mensajes.get("mensaje.no_soportado", "cancelarVenta"));
    }

    public List<Object> obtenerVentasPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        throw new UnsupportedOperationException(
                Mensajes.get("mensaje.no_soportado", "obtenerVentasPorRangoFechas"));
    }
    
}