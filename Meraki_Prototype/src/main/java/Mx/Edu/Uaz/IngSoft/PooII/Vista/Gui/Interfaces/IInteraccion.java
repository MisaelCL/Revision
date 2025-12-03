/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces;

import java.util.List;
import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;

/**
 *
 * @author khota
 */
public interface IInteraccion {
    void mostrarP_Florero(Florero P_Florero);
    Florero obtenerFlorero();
    void mostrarP_Floreros(List<Florero>productosFlorero);
    void setController(IControlador c);
    
}
