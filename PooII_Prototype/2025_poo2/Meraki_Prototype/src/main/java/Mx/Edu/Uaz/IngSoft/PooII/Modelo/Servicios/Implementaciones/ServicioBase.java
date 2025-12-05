/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IBaseDAO;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.IEntidad;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios.Interfaz.IServicioBase;

/**
 *
 * @author khota
 */
public class ServicioBase <T extends IEntidad, U extends IBaseDAO<T>>implements IServicioBase<T> {
    
    protected final U dao;
    
    public ServicioBase(U dao) {
        this.dao = dao;
    }

    @Override
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    public Optional<T> findById(long id) {
        return dao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
    
}
