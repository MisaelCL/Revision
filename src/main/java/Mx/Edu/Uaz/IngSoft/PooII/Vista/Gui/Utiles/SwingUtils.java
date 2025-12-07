/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Vista.Gui.Utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author khota
 */
public class SwingUtils {
    
    
    public static List<JLabel> crearEtiquetas(String[] textosEtiquetas){
        List<JLabel> salida = new ArrayList<>();
        for(String unaEtiqueta:textosEtiquetas){
            JLabel laEtiqueta = new JLabel(unaEtiqueta);
            salida.add(laEtiqueta);
        }
        return salida;
    }
    
    public static List<JLabel> crearEtiquetas(List<String> textosEtiquetas){
        String[] textos;
        textos = new String[textosEtiquetas.size()];
        for(int i=0;i<textos.length;i++){
            
            textos[i]=textosEtiquetas.get(i);
        }
        
        return crearEtiquetas(textos);
    }
    
    
    
    
    public static List<JButton> crearBotones(String[] textosBotones){
        List<JButton> salida = new ArrayList<>();
        for(int i=0;i<textosBotones.length;i++){
            JButton boton = new JButton(textosBotones[i]);
            salida.add(boton);
        }
        return salida;
    }
    
    
}
