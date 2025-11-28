/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoVela;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Vela;

/**
 *
 * @author khota
 */
public class VelaDAO extends BaseDAO<Vela> implements IDaoVela {

    public VelaDAO() {
        super(Vela.class);
    }
}