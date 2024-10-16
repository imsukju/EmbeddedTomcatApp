package com.MyWepOne.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.MyWepOne.entity.Bank;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Repository
@Qualifier("bankDao")
public class BankDao {
	public void addBank()
	{
		
	}
	
	public Bank findByBankid(Long bankid,EntityManager em)
	{


		Bank bank = em.find(Bank.class, bankid);
		if(bank != null)
		{
			return bank;
		}
		
		return null;

		
	}
	

}
