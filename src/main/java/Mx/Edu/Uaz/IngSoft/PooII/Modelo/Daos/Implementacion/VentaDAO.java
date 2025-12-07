/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author khota
 */
public class VentaDAO extends BaseDAO<Venta> implements IDaoVenta {

    public VentaDAO() {
        super(Venta.class);
    }

    @Override
    public List<Venta> findByCliente(long idCliente) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Venta v WHERE v.cliente.idCliente = :idCliente", Venta.class)
                    .setParameter("idCliente", idCliente)
                    .getResultList();
        } catch (Exception e) {
            log.severe("No se pudieron obtener ventas por cliente: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Venta> findByRangoFechas(LocalDate inicio, LocalDate fin) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Venta v WHERE v.fecha BETWEEN :inicio AND :fin", Venta.class)
                    .setParameter("inicio", inicio)
                    .setParameter("fin", fin)
                    .getResultList();
        } catch (Exception e) {
            log.severe("No se pudieron obtener ventas por rango de fechas: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Venta> crearVenta(Cliente cliente, List<ItemVenta> items) {
        if (cliente == null || cliente.getId() == null || items == null || items.isEmpty()) {
            log.warning("Datos de venta incompletos.");
            return Optional.empty();
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Cliente clienteGestionado = em.find(Cliente.class, cliente.getId());
            if (clienteGestionado == null) {
                throw new IllegalArgumentException("El cliente indicado no existe.");
            }

            Venta venta = new Venta();
            venta.setCliente(clienteGestionado);
            venta.setFecha(LocalDate.now());
            venta.setItems(new ArrayList<>());

            for (ItemVenta item : items) {
                if (item == null || item.getProducto() == null || item.getCantidad() <= 0) {
                    throw new IllegalArgumentException("Item de venta inválido.");
                }

                Producto producto = em.find(Producto.class, item.getProducto().getId());
                if (producto == null) {
                    throw new IllegalArgumentException("Producto no encontrado para la venta.");
                }

                if (producto.getExistencia() < item.getCantidad()) {
                    throw new IllegalStateException("Existencia insuficiente para el producto: " + producto.getNombre());
                }

                producto.setExistencia(producto.getExistencia() - item.getCantidad());
                em.merge(producto);

                ItemVenta itemPersistente = new ItemVenta();
                itemPersistente.setProducto(producto);
                itemPersistente.setCantidad(item.getCantidad());
                itemPersistente.setPrecioUnitario(item.getPrecioUnitario() > 0
                        ? item.getPrecioUnitario()
                        : producto.getPrecio());
                itemPersistente.setVenta(venta);
                venta.getItems().add(itemPersistente);
            }

            venta.recalcularTotal();
            em.persist(venta);

            tx.commit();
            return Optional.of(venta);
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            String mensaje = e.getMessage() != null ? e.getMessage() : "No se pudo crear la venta.";
            log.severe("No se pudo crear la venta: " + mensaje);
            throw new IllegalStateException(mensaje, e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}