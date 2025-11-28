/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFlorero;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;

/**
 *
 * @author khota
 */
public class FloreroDAO extends BaseDAO<Florero> implements IDaoFlorero {

    public FloreroDAO() {
        super(Florero.class);
    }
}