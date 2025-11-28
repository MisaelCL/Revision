/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Servicios;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFlorero;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoFrasco;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IDaoVela;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Florero;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Frasco;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.Vela;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.IEntidad;
/**
 *
 * @author khota
 */
public class CatalogoProductoService {
    private final IDaoFlorero floreroDao;
    private final IDaoFrasco frascoDao;
    private final IDaoVela velaDao;
    
    public CatalogoProductoService(IDaoFlorero floreroDao,
                                   IDaoFrasco frascoDao,
                                   IDaoVela velaDao) {
        this.floreroDao = floreroDao;
        this.frascoDao = frascoDao;
        this.velaDao = velaDao;
    }
    
    public List<IEntidad> listarProductos() {
        List<IEntidad> resultado = new ArrayList<>();
        resultado.addAll(floreroDao.findAll());
        resultado.addAll(frascoDao.findAll());
        resultado.addAll(velaDao.findAll());
        return resultado;
    }
    
    public Optional<IEntidad> buscarProductoPorId(Long id) {
        Optional<Florero> florero = floreroDao.findById(id);
        if (florero.isPresent()) return Optional.of(florero.get());

        Optional<Frasco> frasco = frascoDao.findById(id);
        if (frasco.isPresent()) return Optional.of(frasco.get());

        Optional<Vela> vela = velaDao.findById(id);
        return vela.map(v -> (IEntidad) v);
    }
    
    public Florero crearProducto(Florero dto) {
        floreroDao.save(dto);
        return dto;
    }
    
    
    
    public Frasco crearProducto(Frasco dto) {
        frascoDao.save(dto);
        return dto;
    }

    public Vela crearProducto(Vela dto) {
        velaDao.save(dto);
        return dto;
    }

    public Florero actualizarProducto(Florero dto) {
        floreroDao.update(dto);
        return dto;
    }
    
    
    public Frasco actualizarProducto(Frasco dto) {
        frascoDao.update(dto);
        return dto;
    }

    public Vela actualizarProducto(Vela dto) {
        velaDao.update(dto);
        return dto;
    }
    
    //___________________________
    public void desactivarProducto(IEntidad entidad) {
        throw new UnsupportedOperationException(
                "aun en proceso");
    }

    public double calcularPrecioConDescuento(IEntidad entidad, double porcentaje) {
        throw new UnsupportedOperationException(
                "Aun en proceso cundo haya precios");
    }
    
}
