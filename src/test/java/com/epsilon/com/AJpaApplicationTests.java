package com.epsilon.com;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.epsilon.com.dao.EntityRepository;
import com.epsilon.com.entities.Produit;


@SpringBootApplication

class AJpaApplicationTests {
	
    public static void main(String[] args) {
    	ApplicationContext ctx=SpringApplication.run(AJpaApplication.class, args);
    	EntityRepository<Produit> produitDao=ctx.getBean(EntityRepository.class);
    	produitDao.save(new Produit("Epsilon", 13.000, 7));
    	produitDao.save(new Produit("Sonhibou", 14.000, 7));
    	produitDao.save(new Produit("Jack", 15.000, 7));
    	
    	
    	List<Produit> produits=produitDao.findByDesignation("%E%");
    	for(Produit p:produits) {
    		System.out.println(p.toString());
    		
    	}
    }
	

}
