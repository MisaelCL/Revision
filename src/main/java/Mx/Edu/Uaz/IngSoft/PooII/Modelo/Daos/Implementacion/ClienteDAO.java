/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoCliente;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Cliente;


/**
 *
 * @author khota
 */
public class ClienteDAO extends BaseDAO<Cliente> implements IDaoCliente {

    public ClienteDAO() {
        super(Cliente.class);
    }
}