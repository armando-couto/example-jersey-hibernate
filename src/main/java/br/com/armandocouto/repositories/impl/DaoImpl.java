package br.com.armandocouto.repositories.impl;

import br.com.armandocouto.repositories.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public abstract class DaoImpl<T> implements DAO<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("etgas");
    private Class clazz;

    protected DaoImpl(Class clazz) {
        this.clazz = clazz;
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
        Query query = getEntityManager().createQuery("from " + clazz.getName() + " x ");
        List<T> resultList = query.getResultList();
        return resultList;
    }
}
