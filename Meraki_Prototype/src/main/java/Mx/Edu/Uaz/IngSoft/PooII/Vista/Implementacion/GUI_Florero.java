/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Implementacion;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import Mx.Edu.Uaz.IngSoft.PooII.Controlador.Interfaces.IControlador;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.IInteraccion;
 /**
 *
 * @author khota
 */
public class GUI_Florero extends JFrame implements IInteraccion{
    
    JTextArea areaSalida;
    JButton botonSalir;
    
    IControlador controller;
    
    
    public void setController(IControlador c){
        controller = c;
    }
    
    public GUI_Florero(){
        super("Gui alimento");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        areaSalida = new JTextArea(40,30);
        botonSalir = new JButton("Salir");
        
        botonSalir.addActionListener(
          ae -> System.exit(0)
        );
        
        add(areaSalida,BorderLayout.CENTER);
        add(botonSalir,BorderLayout.PAGE_END);
                 
        
        
        
        
        setVisible(true);
        
    }

    @Override
    public void mostrarP_Florero(Florero P_Florero) {
         StringBuilder sb = new StringBuilder();
        sb.append("Color =").append(P_Florero.getColor())
                .append("\n")
                .append("Tamaño = ")
                .append(P_Florero.getLargo())
                .append("\n")
                .append("Material= ")
                .append(P_Florero.getMaterial())
                .append("\n");
     
        areaSalida.setText(sb.toString());
    }
    
//modificar y complementar
    @Override
    public Florero obtenerFlorero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarP_Floreros(List<Florero> productosFlorero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
