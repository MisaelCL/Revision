/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Vista.Interfaces.ISalida;
import javax.swing.JOptionPane;

/**
 *
 * @author khota
 */
public class SalidaGrafica implements ISalida{

    @Override
    public void mostrarString(String cadena) {
        JOptionPane.showMessageDialog(null, cadena);
    }

    @Override
    public void mostrsrNumero(String numero) {
        mostrarString(""+numero);
    }

    @Override
    public void mostrarString(String cadena, boolean nuevaLinea) {
        mostrarString(cadena);
    }
    
}
