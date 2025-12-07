/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccion;
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Mensajes;
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Validador;

import java.util.List;
import java.util.Optional;

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
        Optional<String> error = Validador.validarProducto(producto);
        if (error.isPresent()) {
            ventana.mostrarMensaje(error.get());
            return;
        }

        if (producto != null && producto.getId() != null) {
            ventana.mostrarMensaje(Mensajes.get("producto.id.no_permitido"));
            return;
        }

        dao.save(producto);
        ventana.mostrarMensaje(Mensajes.get("producto.guardado"));
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
            ventana.mostrarMensaje(Mensajes.get("producto.eliminado"));
            listarProductos();
        }, () -> ventana.mostrarMensaje(Mensajes.get("producto.no_encontrado")));
    }
    
    @Override
    public void buscarProducto(long identificador) {
        dao.findById(identificador)
                .ifPresentOrElse(ventana::mostrarProducto, () -> ventana.mostrarMensaje(Mensajes.get("producto.no_encontrado")));
    }

    @Override
    public void actualizarProducto(Producto producto) {
        Optional<String> error = Validador.validarProducto(producto);
        if (error.isPresent()) {
            ventana.mostrarMensaje(error.get());
            return;
        }
        if (producto.getId() == null) {
            ventana.mostrarMensaje(Mensajes.get("error.campo_vacio", "ID"));
            return;
        }

        dao.findById(producto.getId()).ifPresentOrElse(p -> {
            dao.update(producto);
            ventana.mostrarMensaje(Mensajes.get("producto.actualizado"));
            listarProductos();
        }, () -> ventana.mostrarMensaje(Mensajes.get("producto.no_encontrado")));
    }
}