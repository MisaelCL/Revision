
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
    public void guardarFlorero(Florero florero) {
        dao.save(florero);
    }
    @Override
    public void listarFlorero() {
        ventana.mostrarP_Floreros(dao.findAll());
    }

    public void eliminarFlorero(long identificador) {
        dao.deleteById(identificador);
    }

    @Override
    public void mostrarFlorero(long identificador) {
        dao.findById(identificador).ifPresent(ventana::mostrarP_Florero);
    }

}