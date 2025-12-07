/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;

import java.util.List;


/**
 *
 * @author khota
 */
public interface IControladorCliente {
    void guardarCliente(Cliente c);

    void actualizarCliente(Cliente c);

    void eliminarCliente(long id);

    void buscarCliente(long id);

    List<Cliente> listarClientes();
}