/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccion;

import java.util.List;

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
        if (producto == null) {
            ventana.mostrarMensaje("Producto inválido.");
            return;
        }

        if (producto.getId() != null) {
            ventana.mostrarMensaje("Para un nuevo producto, deje el ID vacío.");
            return;
        }

        dao.save(producto);
        ventana.mostrarMensaje("Producto registrado correctamente.");
        listarProductos();
    }

    @Override
    public void listarProductos() {
        List<Producto> productos = dao.findAll();
        ventana.mostrarProductos(productos);
    }

    @Override
    public void eliminarProducto(long identificador) {
        dao.findById(identificador).ifPresentOrElse(producto -> {
            dao.deleteById(identificador);
            ventana.mostrarMensaje("Producto eliminado.");
            listarProductos();
        }, () -> ventana.mostrarMensaje("No se encontró un producto con ese ID."));
    }

    @Override
    public void buscarProducto(long identificador) {
        dao.findById(identificador)
                .ifPresentOrElse(ventana::mostrarProducto, () -> ventana.mostrarMensaje("No se encontró un producto con ese ID."));
    }

    @Override
    public void actualizarProducto(Producto producto) {
        if (producto == null || producto.getId() == null) {
            ventana.mostrarMensaje("Debe seleccionar un producto existente para actualizar.");
            return;
        }

        dao.findById(producto.getId()).ifPresentOrElse(p -> {
            dao.update(producto);
            ventana.mostrarMensaje("Producto actualizado.");
            listarProductos();
        }, () -> ventana.mostrarMensaje("No se encontró un producto con ese ID."));
    }
}