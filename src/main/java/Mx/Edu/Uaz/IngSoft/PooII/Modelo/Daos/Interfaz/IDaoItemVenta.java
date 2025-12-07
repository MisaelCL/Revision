/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.ItemVenta;

import java.util.List;

/**
 *
 * @author khota
 */
public interface IDaoItemVenta extends IBaseDAO<ItemVenta> {
    List<ItemVenta> findByVenta(long idVenta);
}
