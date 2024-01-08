package org.jsp.OneToMany2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.OneToMany2.dto.Merchant;

public class MerchantDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Merchant SaveMerchant(Merchant M) {
		EntityTransaction trans = manager.getTransaction();
		manager.persist(M);
		trans.begin();
		trans.commit();
		return M;
	}

	public Merchant updateMerchant(Merchant m) {
		Merchant M = manager.find(Merchant.class, m.getId());
		if (M != null) {
			M.setName(m.getName());
			M.setPhone(m.getPhone());
			M.setEmail(m.getEmail());
			M.setGst(m.getGst());
			M.setPassword(m.getPassword());
			EntityTransaction trans = manager.getTransaction();
			trans.begin();
			trans.commit();
			return M;
		}

		return null;
	}

	public Merchant findMerchantByid(int id) {
		return manager.find(Merchant.class, id);
	}

	public Merchant veriftByPhone(long Phone, String password) {
		Query q = manager.createQuery("select m from Merchant m where m.Phone=?1 and m.Password=?2");
		q.setParameter(1, Phone);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant veriftByEmail(String Email, String password) {
		Query q = manager.createQuery("select m from Merchant m where m.Email=?1 and m.Password=?2");
		q.setParameter(1, Email);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
