package com.capgemini.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.persistence.EntityManager;

import com.capgemini.Util.Util;
import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;

public class WalletRepoImpl implements WalletRepo {
	

	EntityManager entityManager;
	
	public WalletRepoImpl() {
		
		super();
		entityManager=Util.getEntityManager();
	}
	@Override
	public boolean save(Customer customer) throws ClassNotFoundException, SQLException {
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
			return true ;
	}

	@Override
	public Customer findOne(String mobileno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();
		Customer customer=entityManager.find(Customer.class, mobileno);
		entityManager.getTransaction().commit();
		return customer;	
	}
	
	@Override
	public boolean depositMoney(Customer customer) throws ClassNotFoundException, SQLException
	{
		entityManager.getTransaction().begin();
		Customer cu=entityManager.find(Customer.class, customer.getMobileno());
		cu.setWallet(customer.getWallet());
		entityManager.getTransaction().commit();
		return true;
	}
	@Override
	public boolean withdrawMoney(Customer customer) throws ClassNotFoundException, SQLException
	{
		entityManager.getTransaction().begin();
		Customer customer1=entityManager.find(Customer.class, customer.getMobileno());
		customer1.setWallet(customer.getWallet());
		entityManager.getTransaction().commit();
		return true;
	}

}
