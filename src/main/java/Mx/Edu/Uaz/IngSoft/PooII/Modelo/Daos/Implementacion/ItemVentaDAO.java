/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoItemVenta;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author khota
 */
public class ItemVentaDAO extends BaseDAO<ItemVenta> implements IDaoItemVenta {

    public ItemVentaDAO() {
        super(ItemVenta.class);
    }

    @Override
    public List<ItemVenta> findByVenta(long idVenta) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT i FROM ItemVenta i WHERE i.venta.idVenta = :idVenta", ItemVenta.class)
                    .setParameter("idVenta", idVenta)
                    .getResultList();
        } catch (Exception e) {
            log.severe("No se pudieron obtener items por venta: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }
}