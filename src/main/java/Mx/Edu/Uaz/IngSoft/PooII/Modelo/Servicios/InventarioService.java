/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios;

import java.util.List;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Mensajes;

/**
 *
 * @author khota
 */
public class InventarioService {

    private final IDaoProducto productoDao;

    public InventarioService(IDaoProducto productoDao) {
        this.productoDao = productoDao;
    }

    public void registrarEntradaProducto(Long idProducto, int cantidad, String motivo) {
        throw new UnsupportedOperationException(
                Mensajes.get("mensaje.no_soportado", "registrarEntradaProducto"));
    }

    public void registrarSalidaProducto(Long idProducto, int cantidad, String motivo) {
        throw new UnsupportedOperationException(
                Mensajes.get("mensaje.no_soportado", "registrarSalidaProducto"));
    }

    public int obtenerExistenciaActual(Long idProducto) {
        return productoDao.findById(idProducto)
                .map(Producto::getExistencia)
                .orElse(0);
    }

    public List<Producto> alertasDeStockBajo() {
        return productoDao.findAll().stream()
                .filter(p -> p.getExistencia() <= 2)
                .toList();
    }
}