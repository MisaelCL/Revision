/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Paneles;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author khota
 */
public class EtiquetaDeTextoPanel extends JPanel{
    
    private JLabel etiqueta;
    private JTextField texto;
    public EtiquetaDeTextoPanel(String textoEtiqueta){
        etiqueta = new JLabel(textoEtiqueta);
        texto = new JTextField(20);
        add(etiqueta);
        add(texto);
    }
 
}
