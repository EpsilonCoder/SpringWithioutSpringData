package com.epsilon.com.dao;

import java.util.List;

import com.epsilon.com.entities.Produit;

//La creation d'une interface generique . 


public interface EntityRepository<T> {
	
	public Produit save(T p);
	public List<T> findAll();
	public List<T> findByDesignation(String mc);
	public T findOne(Long id);
	public T update(T id);
	public void supprimer(Long id);
	

}
