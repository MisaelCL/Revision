/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;


import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFlorero;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccion;
/**
 *
 * @author khota
 */
public class ControladorFlorero implements IControlador {
    IInteraccion ventana; 
    IDaoFlorero dao;
    
    public ControladorFlorero(IInteraccion v, IDaoFlorero d){
        ventana = v;
        dao = d;
    }
    @Override
    public void mostrarFlorero(int identificador) {
        Florero a = dao.findById(identificador).get();
        ventana.mostrarP_Florero(a);
    }
    
}
