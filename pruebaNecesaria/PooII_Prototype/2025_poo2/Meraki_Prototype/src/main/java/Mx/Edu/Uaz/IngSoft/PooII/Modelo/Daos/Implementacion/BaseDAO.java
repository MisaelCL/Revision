/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Implementacion;

import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Daos.Interfaz.IBaseDAO;
import Mx.Edu.Uaz.IngSoft.PooII.Modelo.Entidades.IEntidad;
import Mx.Edu.Uaz.IngSoft.PooII.Utiles.Constantes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author khota
 * @param <T>
 */
public class BaseDAO<T extends IEntidad> implements IBaseDAO<T> {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("persistenciaMeraki");

    protected final EntityManager em;
    protected final Class<T> clazz;
    protected final Logger log;

    public BaseDAO(Class<T> clazz) {
        this.clazz = clazz;
        this.log = Logger.getLogger(clazz.getName());
        this.em = emf.createEntityManager();
    }

    @Override
    public void save(T entity) {
        if (entity == null) {
            log.warning(Constantes.CAD_WRNG_ENTIDAD_NULA);
            return;
        }
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.severe(Constantes.CAD_WRNG_ENTIDAD_NO_GUARDADA + e.getMessage());
        }
    }

    @Override
    public Optional<T> findById(long id) {
        T entidad = em.find(clazz, id);
        return Optional.ofNullable(entidad);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(clazz);
        cq.select(cq.from(clazz));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void update(T entity) {
        if (entity == null) {
            log.warning(Constantes.CAD_WRNG_ENTIDAD_NULA);
            return;
        }
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.severe(Constantes.CAD_ERR_UPDATE + e.getMessage());
        }
    }

    @Override
    public void delete(T entity) {
        if (entity == null) {
            log.warning(Constantes.CAD_WRNG_ENTIDAD_NULA);
            return;
        }
        try {
            em.getTransaction().begin();
            T attached = em.contains(entity) ? entity : em.merge(entity);
            em.remove(attached);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.severe(Constantes.CAD_ERR_DELETE + e.getMessage());
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id).ifPresent(this::delete);
    }
}