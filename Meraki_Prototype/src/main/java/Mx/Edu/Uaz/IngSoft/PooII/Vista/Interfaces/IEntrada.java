/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Interfaces;

/**
 *
 * @author khota
 */
public interface IEntrada {
    
    String leerString();
    String leerString(String texto);
    String leerString(String texto, String porDefecto);
    int leerEntero();
    int leerEntero(String texto);
    int leerEntero(int porDefecto);
    int leerEntero(int min, int max);
    int leerEntero(String peticion,int min, int max);
    
}
