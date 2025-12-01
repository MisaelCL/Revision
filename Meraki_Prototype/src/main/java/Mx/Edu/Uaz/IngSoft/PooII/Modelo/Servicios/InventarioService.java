/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios;

import java.util.List;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFlorero;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFrasco;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoVela;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Frasco;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Vela;

/**
 *
 * @author khota
 */
public class InventarioService {

    private final IDaoFlorero floreroDao;
    private final IDaoFrasco frascoDao;
    private final IDaoVela velaDao;

    public InventarioService(IDaoFlorero floreroDao,
                             IDaoFrasco frascoDao,
                             IDaoVela velaDao) {
        this.floreroDao = floreroDao;
        this.frascoDao = frascoDao;
        this.velaDao = velaDao;
    }
    
    public void registrarEntradaProducto(Long idProducto, int cantidad, String motivo) {
        throw new UnsupportedOperationException(
                "Implementar registrarEntradaProducto cuando definas cómo guardar existencias.");
    }
    
    public void registrarSalidaProducto(Long idProducto, int cantidad, String motivo) {
        throw new UnsupportedOperationException(
                "Implementar registrarSalidaProducto cuando definas existencias.");
    }
    
    public int obtenerExistenciaActual(Long idProducto) {
        throw new UnsupportedOperationException(
                "Implementar obtenerExistenciaActual cuando existan campos de existencia.");
    }

    public List<Object> alertasDeStockBajo() {
        // devuleve lista de productos con stock bajo
        throw new UnsupportedOperationException(
                "Implementar alertasDeStockBajo cuando tengas modelo de inventario.");
    }
}
