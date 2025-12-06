/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Paneles;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Utiles.SwingUtils;

/**
 *
 * @author khota
 */
public class BotonesPanel extends JPanel{
    
    public BotonesPanel(String ... textoBotones){
        List<JButton>Botones;
        Botones = SwingUtils.crearBotones(textoBotones);
        for(JButton unBoton:Botones){
            this.add(unBoton);
        }
    }
}
