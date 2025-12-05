/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Interfaces.Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Utiles.SwingUtils;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Paneles.PanelProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Paneles.BotonesPanel;

/**
 *
 * @author khota
 */
public class VentaAltaProducto extends JFrame{
    
    protected PanelProducto PnlFlorero;
    protected BotonesPanel PnlBotones;
    
    
    public VentaAltaProducto (String TituloVentana){
        super("Alta de producto Florero");
        setSize(300,300);
        
        PnlFlorero = new PanelProducto();
        PnlBotones = new BotonesPanel("si", "no", "mañana");
        
        this.add(PnlFlorero,BorderLayout.CENTER );
        this.add(PnlBotones,BorderLayout.PAGE_END );
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public VentaAltaProducto(){
        this("Ventana de alta de almentos");
    }
    
}
