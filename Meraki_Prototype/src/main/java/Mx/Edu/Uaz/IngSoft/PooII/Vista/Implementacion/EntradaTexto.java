/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import java.util.Scanner;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Interfaces.IEntrada;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Interfaces.ISalida;
/**
 *
 * @author khota
 */
public class EntradaTexto implements IEntrada {
    
    private Scanner teclado;
    private ISalida pantalla;
    public EntradaTexto(){
        teclado = new Scanner(System.in);
        pantalla = new SalidaTexto();
    }

    @Override
    public String leerString() {
        String nuevoTexto;
        nuevoTexto = teclado.nextLine();
        return nuevoTexto;
    }

    @Override
    public String leerString(String texto) {
        pantalla.mostrarString(texto);
        return leerString();
    }

    @Override
    public String leerString(String texto, String porDefecto) {
        String datoEntrada;
        datoEntrada = leerString(texto);
        if(datoEntrada.isBlank()){
            return porDefecto;
        }else{
            return datoEntrada;
        }
    }

    @Override
    public int leerEntero() {
        String entrada;
        entrada = teclado.nextLine();
        int salida;
        try{
            salida = Integer.parseInt(entrada);
        }catch(NumberFormatException e){
            salida = -1;
        }
        return salida;
    }

    @Override
    public int leerEntero(String texto) {
        pantalla.mostrsrNumero(texto);
        return leerEntero();
    }

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
