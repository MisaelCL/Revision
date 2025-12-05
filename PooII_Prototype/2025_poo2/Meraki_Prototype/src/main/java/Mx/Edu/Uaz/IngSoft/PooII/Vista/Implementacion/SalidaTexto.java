/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Vista.Interfaces.ISalida;
/**
 *
 * @author khota
 */
public class SalidaTexto implements ISalida {

    @Override
    public void mostrarString(String cadena) {
        System.out.println(cadena);
    }
//complementar
    @Override
    public void mostrsrNumero(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarString(String cadena, boolean nuevaLinea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
