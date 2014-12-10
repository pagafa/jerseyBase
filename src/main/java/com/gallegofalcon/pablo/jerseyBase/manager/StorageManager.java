package com.gallegofalcon.pablo.jerseyBase.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gallegofalcon.pablo.jerseyBase.entity.User;

@Repository
public class StorageManager {
	private static final Logger logger = LoggerFactory.getLogger(StorageManager.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addUser(final User user) {
		TypedQuery<User> q = em.createNamedQuery("User.findByName", User.class);
		q.setMaxResults(1).setParameter("name", user.getName());
		List<User> list = q.getResultList();
		if (list.isEmpty()) {
			em.persist(user);
			em.flush();
		}
	}

	@Transactional(readOnly = true)
	public List<User> listUsers() {
		TypedQuery<User> q = em.createNamedQuery("User.all", User.class);
		List<User> list = q.getResultList();
		return list;
	}
}
