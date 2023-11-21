package com.cg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.cg.entity.Cart;
import com.cg.util.JPAUtil;
import com.cg.entity.Items;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Test {

	public static void main(String[] args) {
		
		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		
		/*Items item1=new Items("t-shirt1",8);
		Items item2=new Items("formalshirt1",2);
		
		Set<Items>items=new HashSet<Items>();
		items.add(item1);
		items.add(item2);*/
		
		Items items1=new Items("t-shirt1",8);
		Items items2=new Items("formalshirt1",2);
		
		Set<Items>item=new HashSet<Items>();
		item.add(items1);
		item.add(items2);
		
	
		//entitymanager.persist(item);
		
		Cart cart=new Cart();
		cart.setName("dmart");
		cart.setItems(item);
		
		entitymanager.persist(cart);
		entitytransaction.commit();
		entitymanager.close();
	}

}
