package br.com.armandocouto.repositories.impl;

import br.com.armandocouto.models.Member;
import br.com.armandocouto.repositories.MemberDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Member> findAll() {
        Query query = getEntityManager().createQuery("SELECT m FROM Member m");

        if (!query.getResultList().isEmpty()) {
            return query.getResultList();
        } else {
            return null;
        }
    }
}
