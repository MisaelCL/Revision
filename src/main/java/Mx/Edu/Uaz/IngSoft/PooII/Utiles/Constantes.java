/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Utiles;

/**
 *
 * @author khota
 */
public class Constantes {
    
    // Codigos de error
    public static final int ERR_CARGA_DRIVER = 100;
    public static final int ERR_CREAR_SENTENCIA = 101;
    public static final int ERR_GUARDAR_REGISTRO = 102;
    public static final int ERR_BAD_ID = 103;
    public static final int ERR_FIND_BY_ID = 104;
    public static final int ERR_FIND_ALL = 105;
    public static final int ERR_ENTIDAD_NULA = 106;
    public static final int ERR_UPDATE = 107;
    public static final int ERR_DELETE = 108;
    // Codigos de advertencia
    public static final int WRNG_ENTIDAD_NO_ACTUALIZADA = 201;
    public static final int WRNG_ENTIDAD_NO_BORRADA = 202;
    
    // Informacion de configuracion
    public static final String CAD_JDBC = "org.sqlite.JDBC";
    public static final String CAD_URL_CONNECTION = "jdbc:sqlite:";
    
    // Mensajes de error
    public static final String CAD_ERR_CARGA_DRIVER = "No se pudo cargar el driver";
    public static final String CAD_ERR_CREAR_SENTENCIA = "No se pudo crear la sentencia";
    public static final String CAD_ERR_INSERT = "No se pudo ejecutar el insert";
    public static final String CAD_ERR_BAD_ID = "El id no puede ser negativo";
    public static final String CAD_ERR_FIND_BY_ID = "No se localizó el registro por su ID";
    public static final String CAD_ERR_FIND_ALL = "No se pudieron obtener todos los registros";
    public static final String CAD_ERR_ENTIDAD_NULA = "La entidad no puede ser nula";
    public static final String CAD_ERR_UPDATE = "La entidad no se pudo actualizar";
    public static final String CAD_ERR_DELETE = "La entidad no se pudo borrar";
    
    public static final String CAD_WRNG_ENTIDAD_NO_ACTUALIZADA = "La entidad no se actualizó";
    public static final String CAD_WRNG_ENTIDAD_NO_BORRADA = "La entidad no se borró";
    public static final String CAD_WRNG_ENTIDAD_NO_GUARDADA = "La entidad no se guardó";
    public static final String CAD_WRNG_ENTIDAD_NULA = "La entidad es nula";

    
    
    
}
