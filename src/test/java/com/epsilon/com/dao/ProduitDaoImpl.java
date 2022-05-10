package com.epsilon.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.epsilon.com.entities.Produit;

@Repository("dao")
@Transactional
public class ProduitDaoImpl implements EntityRepository<Produit> {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Produit save(Produit p) {
		em.persist(p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> findAll() {
		Query req=em.createQuery("select p from Produit p");	
		return req.getResultList();
	}

	@Override
	public List<Produit> findByDesignation(String mc) {
		Query req=em.createQuery("select p from Produit p where designation like :x");
		req.setParameter("x", mc);
		return req.getResultList();
	}

	@Override
	public Produit findOne(Long id) {
	   Produit p=em.find(Produit.class, id);
		return p;
	}

	@Override
	public Produit update(Produit p) {
		em.merge(p);
		return p;
	}

	@Override
	public void supprimer(Long id) {
		 Produit p=em.find(Produit.class, id);
		 em.remove(p);
		
	}

}
