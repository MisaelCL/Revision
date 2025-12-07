/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControladorCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccionCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Mensajes;
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Validador;

import java.util.List;
import java.util.Optional;


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
        Optional<String> error = Validador.validarCliente(c);
        if (error.isPresent()) {
            vista.mostrarMensaje(error.get());
            return;
        }
        dao.save(c);
        vista.mostrarMensaje(Mensajes.get("cliente.guardado"));
        listarClientes();
    }

    public void actualizarCliente(Cliente c) {
        Optional<String> error = Validador.validarCliente(c);
        if (error.isPresent()) {
            vista.mostrarMensaje(error.get());
            return;
        }
        if (c.getId() != null) {
            dao.findById(c.getId()).ifPresentOrElse(cliente -> {
                dao.update(c);
                vista.mostrarMensaje(Mensajes.get("cliente.actualizado"));
                listarClientes();
            }, () -> vista.mostrarMensaje(Mensajes.get("cliente.no_encontrado")));
        } else {
            vista.mostrarMensaje(Mensajes.get("cliente.id.invalido"));
        }
    }

    @Override
    public void eliminarCliente(long id) {
        dao.findById(id).ifPresentOrElse(cliente -> {
            dao.delete(cliente);
            vista.mostrarMensaje(Mensajes.get("cliente.eliminado"));
            listarClientes();
        }, () -> vista.mostrarMensaje(Mensajes.get("cliente.no_encontrado")));
    }
        
    @Override
    public void buscarCliente(long id) {
        dao.findById(id).ifPresentOrElse(vista::mostrarCliente,
                () -> vista.mostrarMensaje(Mensajes.get("cliente.no_encontrado")));
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = dao.findAll();
        vista.mostrarClientes(clientes);
        return clientes;
    }
}