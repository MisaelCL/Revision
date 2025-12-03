/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Paneles;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


/**
 *
 * @author khota
 */
public class PanelFlorero extends JPanel{
    public PanelFlorero(){
        setLayout (new BoxLayout(this, BoxLayout.PAGE_AXIS));
        EtiquetaDeTextoPanel r1,r2,r3;
        r1 = new EtiquetaDeTextoPanel("Color v2");
        r2 = new EtiquetaDeTextoPanel("Largo v2");
        r3 = new EtiquetaDeTextoPanel("Material v2");
        
        this.add(r1);
        this.add(r2);
        this.add(r3);
        
    }
    

}
