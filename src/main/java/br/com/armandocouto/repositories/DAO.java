package br.com.armandocouto.repositories;

import java.util.List;

public interface DAO<T> {

    public void create(T entity);

    public void edit(T entity);

    public void remove(T entity);

    public List<T> findAll();
}
