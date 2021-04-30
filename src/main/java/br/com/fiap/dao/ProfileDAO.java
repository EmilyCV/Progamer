package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Profile;
import br.com.fiap.util.JPAUtil;

public class ProfileDAO {

	public void save(Profile profile) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(profile);
		manager.getTransaction().commit();
		manager.close();

	}

	public List<Profile> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();
        String jpsql = "SELECT p FROM Profile p";
        List<Profile> q = manager.createQuery(jpsql, Profile.class).getResultList();
        return q;
	}
}
