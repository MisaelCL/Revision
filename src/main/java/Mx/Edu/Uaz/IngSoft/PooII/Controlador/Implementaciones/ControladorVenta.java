/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControladorVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccionVenta;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author khota
 */
public class ControladorVenta implements IControladorVenta {

    private final IInteraccionVenta vista;
    private final IDaoVenta ventaDAO;
    private final IDaoItemVenta itemVentaDAO;
    private final IDaoCliente clienteDAO;
    private final IDaoProducto productoDAO;

    public ControladorVenta(IInteraccionVenta vista, IDaoVenta ventaDAO, IDaoItemVenta itemVentaDAO,
                            IDaoCliente clienteDAO, IDaoProducto productoDAO) {
        this.vista = vista;
        this.ventaDAO = ventaDAO;
        this.itemVentaDAO = itemVentaDAO;
        this.clienteDAO = clienteDAO;
        this.productoDAO = productoDAO;
        this.vista.setController(this);
        cargarCatalogos();
    }

    private void cargarCatalogos() {
        vista.mostrarClientes(clienteDAO.findAll());
        vista.mostrarProductos(productoDAO.findAll());
    }

    @Override
    public void guardarVenta(Venta venta) {
        if (venta == null || venta.getCliente() == null || venta.getItems().isEmpty()) {
            vista.mostrarMensaje("Capture un cliente y al menos un producto para guardar la venta.");
            return;
        }
        crearVenta(venta.getCliente(), venta.getItems());
    }

    @Override
    public void crearVenta(Cliente cliente, List<ItemVenta> items) {
        if (cliente == null || items == null || items.isEmpty()) {
            vista.mostrarMensaje("Seleccione un cliente y agregue productos para la venta.");
            return;
        }
        try {
            ventaDAO.crearVenta(cliente, items).ifPresentOrElse(v -> {
                vista.mostrarMensaje("Venta guardada correctamente.");
                vista.mostrarVenta(v);
                cargarCatalogos();
            }, () -> vista.mostrarMensaje("No se pudo crear la venta. Revise el inventario."));
        } catch (RuntimeException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    @Override
    public void cancelarVenta(long idVenta) {
        if (idVenta <= 0) {
            vista.mostrarMensaje("Ingrese un ID de venta válido.");
            return;
        }
        boolean eliminada = ventaDAO.eliminarVentaYRestaurarInventario(idVenta);
        if (eliminada) {
            vista.mostrarMensaje("Venta cancelada/eliminada correctamente.");
            limpiarVentaActual();
            cargarCatalogos();
        } else {
            vista.mostrarMensaje("No se encontró la venta indicada.");
        }
    }

    @Override
    public List<Venta> listarVentas() {
        List<Venta> ventas = ventaDAO.findAll();
        vista.mostrarVentas(ventas);
        return ventas;
    }

    @Override
    public List<Venta> listarPorCliente(long idCliente) {
        List<Venta> ventas = ventaDAO.findByCliente(idCliente);
        vista.mostrarVentas(ventas);
        return ventas;
    }

    @Override
    public List<Venta> listarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        List<Venta> ventas = ventaDAO.findByRangoFechas(inicio, fin);
        vista.mostrarVentas(ventas);
        return ventas;
    }

    @Override
    public void buscarVenta(long idVenta) {
        ventaDAO.findById(idVenta)
                .ifPresentOrElse(vista::mostrarVenta, () -> vista.mostrarMensaje("No se encontró la venta indicada."));
    }

    @Override
    public void limpiarVentaActual() {
        vista.limpiarFormularioVenta();
    }
}