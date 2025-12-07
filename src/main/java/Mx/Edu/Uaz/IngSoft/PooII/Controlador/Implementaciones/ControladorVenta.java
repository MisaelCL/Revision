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
        venta.getItems().forEach(i -> i.setVenta(venta));
        venta.recalcularTotal();
        ventaDAO.save(venta);
        vista.mostrarMensaje("Venta guardada correctamente.");
        vista.mostrarVenta(venta);
        cargarCatalogos();
    }

    @Override
    public void cancelarVenta(long idVenta) {
        ventaDAO.findById(idVenta).ifPresentOrElse(v -> {
            v.setCancelada(true);
            ventaDAO.update(v);
            vista.mostrarMensaje("Venta cancelada.");
            listarVentas();
        }, () -> vista.mostrarMensaje("No se encontró la venta indicada."));
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
        if (Objects.isNull(inicio) || Objects.isNull(fin)) {
            vista.mostrarMensaje("Indique fechas válidas.");
            return List.of();
        }
        List<Venta> ventas = ventaDAO.findByRangoFechas(inicio, fin);
        vista.mostrarVentas(ventas);
        return ventas;
    }

    public List<ItemVenta> listarItemsPorVenta(long idVenta) {
        List<ItemVenta> items = itemVentaDAO.findByVenta(idVenta);
        Venta venta = ventaDAO.findById(idVenta).orElse(null);
        if (venta != null) {
            vista.mostrarVenta(venta);
        }
        return items;
    }
}