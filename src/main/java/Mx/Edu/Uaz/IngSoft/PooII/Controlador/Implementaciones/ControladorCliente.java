/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControladorCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccionCliente;

import java.util.List;

/**
 *
 * @author khota
 */
public class ControladorCliente implements IControladorCliente {

    private final IInteraccionCliente vista;
    private final IDaoCliente dao;

    public ControladorCliente(IInteraccionCliente vista, IDaoCliente dao) {
        this.vista = vista;
        this.dao = dao;
        this.vista.setController(this);
    }

    @Override
    public void guardarCliente(Cliente c) {
        if (c != null) {
            dao.save(c);
            vista.mostrarMensaje("Cliente guardado correctamente.");
            listarClientes();
        }
    }

    @Override
    public void actualizarCliente(Cliente c) {
        if (c != null && c.getId() != null) {
            dao.findById(c.getId()).ifPresentOrElse(cliente -> {
                dao.update(c);
                vista.mostrarMensaje("Cliente actualizado.");
                listarClientes();
            }, () -> vista.mostrarMensaje("No se encontró el cliente indicado."));
        } else {
            vista.mostrarMensaje("Indique un cliente válido para actualizar.");
        }
    }

    @Override
    public void eliminarCliente(long id) {
        dao.findById(id).ifPresentOrElse(cliente -> {
            dao.delete(cliente);
            vista.mostrarMensaje("Cliente eliminado.");
            listarClientes();
        }, () -> vista.mostrarMensaje("No se encontró el cliente indicado."));
    }

    @Override
    public void buscarCliente(long id) {
        dao.findById(id).ifPresentOrElse(vista::mostrarCliente,
                () -> vista.mostrarMensaje("No se encontró el cliente indicado."));
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = dao.findAll();
        vista.mostrarClientes(clientes);
        return clientes;
    }
}