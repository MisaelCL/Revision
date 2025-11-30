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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 *
 * @author khota
 * @param <T>
 */
public class BaseDAO<T extends IEntidad> implements IBaseDAO<T> {

     private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("persistenciaMeraki");

    protected final Class<T> clazz;
    protected final Logger log;

    public BaseDAO(Class<T> clazz) {
        this.clazz = clazz;
        this.log = Logger.getLogger(clazz.getName());
    }

    @Override
    public void save(T entity) {
        if (entity == null) {
            log.warning(Constantes.CAD_WRNG_ENTIDAD_NULA);
            return;
        }
        executeInTransaction(em -> {
            em.persist(entity);
        }, Constantes.CAD_WRNG_ENTIDAD_NO_GUARDADA);
    }

    private void executeInTransaction(Consumer<EntityManager> action, String errorMessage) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            log.severe(errorMessage + e.getMessage());
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Optional<T> findById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            T entidad = em.find(clazz, id);
            return Optional.ofNullable(entidad);
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(clazz);
            cq.select(cq.from(clazz));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T entity) {
        if (entity == null) {
            log.warning(Constantes.CAD_WRNG_ENTIDAD_NULA);
            return;
        }
        executeInTransaction(em -> em.merge(entity), Constantes.CAD_ERR_UPDATE);
    }

    @Override
    public void delete(T entity) {
        if (entity == null) {
            log.warning(Constantes.CAD_WRNG_ENTIDAD_NULA);
            return;
        }
        executeInTransaction(em -> {
            T attached = em.contains(entity) ? entity : em.merge(entity);
            em.remove(attached);
        }, Constantes.CAD_ERR_DELETE);
    }
    
    @Override
    public void deleteById(long id) {
        findById(id).ifPresent(this::delete);
    }
}