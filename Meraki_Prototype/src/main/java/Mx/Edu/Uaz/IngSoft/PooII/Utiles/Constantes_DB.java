/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Utiles;

/**
 *
 * @author khota
 */
public class Constantes_DB {
    
    public static final String BD_NAME=("Mercancia.db");
    
    
     //Constantes de vela
    public static final String FIND_VELA_ID= "SELECT IdProducto, Color, Largo, Tipo FROM Vela WHERE IdProducto= ?";
    public static final String FIND_aLL_VELA="SELECT IdProducto, Color, Largo, Tipo FROM Vela";
    public static final String UDAPTE_VELA = "UDAPTE Vela SET Color=?, Largo=?, Tipo=?  WHERE IdProoducto";
    public static final String DELATE_VELA_BY_ID= "DELATE FROM Vela WHERE IdProducto=?";
    public static final String INSERT_VELA="""
                                           insert into Vela (Color,Largo,Tipo,)
                                           values ( ?, ?, ?)
                                          """;
    
    //Constantes de florero
    public static final String FIND_FLORERO_BY_ID = 
            "SELECT IdFlorero, Color, Largo, Material FROM Florero WHERE IdFlorero=?";
    public static final String FIND_ALL_fLORERO = "SELECT IdFlorero, Color, Largo, Material FROM Florero";
    public static final String INSERT_FLORERO = """
                                                    insert into Florero (Color, Largo, Material)
                                                    values ( ?, ?, ?)
                                                """;
    public static final String UPDATE_FLORERO = "UPDATE Florero SET Color = ?, Largo = ?, Material = ? WHERE IdFlorero";
    public static final String DELATE_FLORERO_BY_ID = "DELATE FROM Florero WHERE IdFlorero = ?";
    
    
    //Constantes de Frasco
    public static final String FIND_FRASCO_BY_ID = 
            "SELECT IdFrasco, Color, Largo, Tipo FROM Frasco WHERE IdFrasco=?";
    public static final String FIND_ALL_fRASCO = "SELECT IdFrasco, Color, Largo, Tipo FROM Frasco";
    public static final String INSERT_FRASCO = """
                                                    insert into Frasco (Color, Largo, Tipo)
                                                    values ( ?, ?, ?)
                                                """;
    public static final String UPDATE_FRASCO = "UPDATE Frasco SET Color = ?, Largo = ?, Tipo = ? WHERE IdFrasco";
    public static final String DELATE_FRASCO_BY_ID = "DELATE FROM Frasco WHERE IdFrasco = ?";
    
}
