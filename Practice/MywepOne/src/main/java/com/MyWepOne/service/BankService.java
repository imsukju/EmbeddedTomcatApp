package com.MyWepOne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.MyWepOne.controller.RootContoller;
import com.MyWepOne.dao.BankDao;
import com.MyWepOne.entity.Bank;

import jakarta.persistence.*;

@Service
public class BankService {
	@Autowired
	@Qualifier("bankDao")
	BankDao bankdao ;
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
	
	public void depositService(Long bankid,Long amount)
	{
		EntityManager em = RootContoller.emf.createEntityManager();
		EntityTransaction etr = em.getTransaction();
		try
		{
			etr.begin();
			Bank bank = bankdao.findByBankid(bankid, em);
			bank.setMoney(amount);
			em.flush();
			etr.commit();
			
			
		}
		catch(Exception e)
		{
			etr.rollback();
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
	
	}
}
