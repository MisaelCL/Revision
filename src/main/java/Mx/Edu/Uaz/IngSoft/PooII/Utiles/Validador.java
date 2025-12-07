/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Utiles;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;
/**
 *
 * @author khota
 */
public final class Validador {

    private static final Pattern PATRON_TELEFONO = Pattern.compile("^\\+?\\d{7,15}$");
    private static final Pattern PATRON_EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private Validador() {
    }

    public static Optional<String> validarProducto(Producto producto) {
        if (producto == null) {
            return Optional.of(Mensajes.get("producto.invalido"));
        }
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            return Optional.of(Mensajes.get("validacion.producto.nombre"));
        }
        if (producto.getPrecio() <= 0) {
            return Optional.of(Mensajes.get("validacion.producto.precio"));
        }
        if (producto.getExistencia() < 0) {
            return Optional.of(Mensajes.get("validacion.producto.existencia"));
        }
        return Optional.empty();
    }

    public static Optional<String> validarCliente(Cliente cliente) {
        if (cliente == null) {
            return Optional.of(Mensajes.get("error.campo_vacio", "Cliente"));
        }
        if (cliente.getNombre() == null || cliente.getNombre().isBlank()) {
            return Optional.of(Mensajes.get("validacion.cliente.nombre"));
        }
        if (cliente.getTelefono() != null && !cliente.getTelefono().isBlank()
                && !PATRON_TELEFONO.matcher(cliente.getTelefono()).matches()) {
            return Optional.of(Mensajes.get("validacion.cliente.telefono"));
        }
        if (cliente.getEmail() != null && !cliente.getEmail().isBlank()
                && !PATRON_EMAIL.matcher(cliente.getEmail()).matches()) {
            return Optional.of(Mensajes.get("validacion.cliente.email"));
        }
        return Optional.empty();
    }

    public static Optional<String> validarVenta(Venta venta) {
        if (venta == null) {
            return Optional.of(Mensajes.get("error.campo_vacio", "Venta"));
        }
        if (venta.getCliente() == null) {
            return Optional.of(Mensajes.get("validacion.venta.cliente"));
        }
        List<ItemVenta> items = venta.getItems();
        if (items == null || items.isEmpty()) {
            return Optional.of(Mensajes.get("validacion.venta.items"));
        }
        boolean cantidadInvalida = items.stream().anyMatch(i -> i == null || i.getCantidad() <= 0);
        if (cantidadInvalida) {
            return Optional.of(Mensajes.get("error.venta.cantidad_invalida"));
        }
        return Optional.empty();
    }
}