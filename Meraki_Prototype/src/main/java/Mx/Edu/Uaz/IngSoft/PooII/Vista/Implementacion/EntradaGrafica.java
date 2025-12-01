/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Vista.Interfaces.IEntrada;
import javax.swing.JOptionPane;

/**
 *
 * @author khota
 */
public class EntradaGrafica implements IEntrada{

    @Override
    public String leerString() {
        return JOptionPane.showInputDialog("");
    }

    @Override
    public String leerString(String texto) {
        return JOptionPane.showInputDialog(texto);
    }

    @Override
    public String leerString(String texto, String porDefecto) {
        String salida;
        salida = leerString(texto);
        if(salida.isBlank()){
            return porDefecto;
        }else{
            return salida;
        }
    }

    @Override
    public int leerEntero() {
        return leerEntero("");
    }

    @Override
    public int leerEntero(String texto) {
        String entrada;
        entrada = leerString(texto);
        int salida;
        try{
            salida = Integer.parseInt(entrada);
        }catch(NumberFormatException e){
            salida = -1;
        }
        return salida;
    }
    
    //Complementar

    @Override
    public int leerEntero(int porDefecto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int leerEntero(int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int leerEntero(String peticion, int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
