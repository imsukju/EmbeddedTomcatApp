package com.MyWepOne.service;

import org.springframework.stereotype.Service;

import com.MyWepOne.entity.Bank;

import jakarta.persistence.*;

@Service
public class BankService {

	public void addBank(Bank bank,EntityManagerFactory emf)
	{

		EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try
		{
			tx.begin();
			em.persist(bank);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			em.close();
		}
	}
}
