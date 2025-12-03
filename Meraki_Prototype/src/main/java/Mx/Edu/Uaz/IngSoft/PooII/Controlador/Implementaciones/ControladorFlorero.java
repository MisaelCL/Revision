
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
    private final IInteraccion ventana;
    private final IDaoFlorero dao;

    public ControladorFlorero(IInteraccion v, IDaoFlorero d) {
        this.ventana = v;
        this.dao = d;
        this.ventana.setController(this);
    }

    @Override
    public void guardarFlorero(Florero florero) {
        if (florero != null) {
            dao.save(florero);
        }
    }

    @Override
    public void listarFlorero() {
        ventana.mostrarP_Floreros(dao.findAll());
    }

    @Override
    public void eliminarFlorero(long identificador) {
        dao.findById(identificador).ifPresent(dao::delete);
    }

    @Override
    public void mostrarFlorero(long identificador) {
        dao.findById(identificador)
                .ifPresentOrElse(ventana::mostrarP_Florero, () -> ventana.mostrarP_Florero(null));
    }

    @Override
    public void actualizarFlorero(Florero florero) {
        if (florero != null) {
            dao.update(florero);
        }
    }
}