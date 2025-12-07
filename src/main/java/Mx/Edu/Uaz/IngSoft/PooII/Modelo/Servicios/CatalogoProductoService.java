/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios;

import java.util.List;
import java.util.Optional;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoProducto;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Producto;
/**
 *
 * @author khota
 */
public class CatalogoProductoService {
    private final IDaoProducto productoDao;

    public CatalogoProductoService(IDaoProducto productoDao) {
        this.productoDao = productoDao;
    }

    public List<Producto> listarProductos() {
        return productoDao.findAll();
    }

    public Optional<Producto> buscarProductoPorId(Long id) {
        return productoDao.findById(id);
    }

    public Producto crearProducto(Producto dto) {
        productoDao.save(dto);
        return dto;
    }

    public Producto actualizarProducto(Producto dto) {
        productoDao.update(dto);
        return dto;
    }
}