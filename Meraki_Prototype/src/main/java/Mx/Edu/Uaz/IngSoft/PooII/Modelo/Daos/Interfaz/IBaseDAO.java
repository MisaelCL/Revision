/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz;

import java.util.List;
import java.util.Optional;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.IEntidad;


/**
 *
 * @author khota
 * @param <T>
 */
public interface IBaseDAO <T extends IEntidad>{
    void save(T entity);
    Optional<T> findById(long id);
    List<T> findAll();
    void update(T entity);
    void delete(T entity);
    void deleteById(long id);
}
