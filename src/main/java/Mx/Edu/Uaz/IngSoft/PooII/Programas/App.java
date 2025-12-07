/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Programas;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Implementaciones.ControladorProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion.ProductoDAO;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion.GUI_Producto;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion.GUI_MenuPrincipal;

import javax.swing.*;
/**
 *
 * @author khota
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI_MenuPrincipal menu = new GUI_MenuPrincipal();
            menu.setVisible(true);
        });
    }
}