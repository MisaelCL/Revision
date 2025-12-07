/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Utiles;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * @author khota
 */
public final class Mensajes {

    private static final String BASE_PATH = "messages/";
    private static final String[] ARCHIVOS = {
            "mensajes.properties",
            "errores.properties",
            "validaciones.properties"
    };

    private static final Properties PROPIEDADES = new Properties();

    static {
        for (String archivo : ARCHIVOS) {
            cargarArchivo(BASE_PATH + archivo);
        }
    }

    private Mensajes() {
    }

    private static void cargarArchivo(String ruta) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ruta)) {
            if (Objects.nonNull(is)) {
                PROPIEDADES.load(new InputStreamReader(is, StandardCharsets.UTF_8));
            }
        } catch (IOException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static String get(String clave, Object... params) {
        String patron = PROPIEDADES.getProperty(clave, clave);
        return MessageFormat.format(patron, params);
    }
}