/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFrasco;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Frasco;
/**
 *
 * @author khota
 */
public class FrascoDao extends BaseDAO<Frasco> implements IDaoFrasco {

    public FrascoDao() {
        super(Frasco.class);
    }
}
