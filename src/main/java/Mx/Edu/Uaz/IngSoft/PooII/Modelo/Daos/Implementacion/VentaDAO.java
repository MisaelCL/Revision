/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Venta;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

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
}