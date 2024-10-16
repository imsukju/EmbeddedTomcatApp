package com.MyWepOne.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.MyWepOne.entity.Bank;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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
	
	public List<Bank> findByBankName(EntityManager em,String bankName)
	{
	    String jpql = "SELECT b FROM Bank b WHERE b.bankName = :bankName";
	    TypedQuery<Bank> query = em.createQuery(jpql, Bank.class);
	    query.setParameter("bankName", bankName);
	    
	    // 결과 리스트 반환
	    return query.getResultList();
	}
	
	public Bank findByBankAccountWithBankId(List<Bank> banks, String bankAccount)
	{
		Bank bank = null;
		for(Bank b : banks)
		{
			if(b.getBankAccount().equals(bankAccount))
			{
				bank = b;
			}
		}
		return bank;

	}
	
	
	public void addmoney(Bank bank, Long ammount)
	{


		bank.setMoney(bank.getMoney()+ammount); 
	}
	
	public void subtractionMoney(Bank bank, Long ammount)
	{

		bank.setMoney(bank.getMoney()-ammount); 

	}
	
	
	

}
