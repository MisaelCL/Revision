/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControladorCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;

import java.util.List;

/**
 *
 * @author khota
 */
public interface IInteraccionCliente {
    Cliente obtenerCliente();

    void mostrarCliente(Cliente c);

    void mostrarClientes(List<Cliente> clientes);

    void mostrarMensaje(String msg);

    void setController(IControladorCliente controlador);
}