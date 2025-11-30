/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;


/**
 *
 * @author khota
 */
public interface IControlador {
    void mostrarFlorero(long identificador);
    void guardarFlorero(Florero florero);
    void listarFlorero();
    void eliminarFlorero(long identificador);
}