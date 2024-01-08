package org.jsp.OneToMany2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.OneToMany2.dto.Merchant;
import org.jsp.OneToMany2.dto.Product;

public class ProductDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Product Saveproduct(int id, Product p) {
		Merchant m = manager.find(Merchant.class, id);
		if (m != null) {
			m.getProducts().add(p);
			p.setMerchant(m);
			EntityTransaction trans = manager.getTransaction();
			manager.persist(p);
			trans.begin();
			trans.commit();
			return p;
		}
		return null;
	}

	public Product UpdateProduct(Product p) {
		Product P = manager.find(Product.class, p.getId());
		if (P != null) {
			P.setName(p.getName());
			P.setBrand(p.getBrand());
			P.setCategory(p.getCategory());
			P.setCost(p.getCost());
			P.setDescription(p.getDescription());
			P.setURL(p.getURL());
			EntityTransaction trans = manager.getTransaction();
			trans.begin();
			trans.commit();
			return P;
		}
		return null;
	}

	public List<Product> FindByMerchantId(int id) {
		Query q = manager.createQuery("select m.products from Merchant m where m.Id=?1");
		q.setParameter(1, id);
		return q.getResultList();
	}

	public Product FindBybrand(String Brand) {
		Query q = manager.createQuery("select p from Product p where p.Brand=?1");
		q.setParameter(1, Brand);
		try {
			return (Product) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public Product FindByCategory(String category) {
		Query q = manager.createQuery("select p from Product p where p.Category=?1");
		q.setParameter(1, category);
		try {
			return (Product) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
