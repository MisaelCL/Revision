
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccion;

/**
 *
 * @author khota
 */
public class ControladorProducto implements IControlador {
    private final IInteraccion ventana;
    private final IDaoProducto dao;

    public ControladorProducto(IInteraccion v, IDaoProducto d) {
        this.ventana = v;
        this.dao = d;
        this.ventana.setController(this);
    }

    @Override
    public void guardarProducto(Producto producto) {
        if (producto != null) {
            dao.save(producto);
        }
    }

    @Override
    public void listarProductos() {
        ventana.mostrar_Productos(dao.findAll());
    }

    @Override
    public void eliminarProducto(long identificador) {
        dao.findById(identificador).ifPresent(dao::delete);
    }

    @Override
    public void mostrarProducto(long identificador) {
        dao.findById(identificador)
                .ifPresentOrElse(ventana::mostrar_Producto, () -> ventana.mostrar_Producto(null));
    }

    @Override
    public void actualizarProducto(Producto producto) {
        if (producto != null) {
            dao.update(producto);
        }
    }
}