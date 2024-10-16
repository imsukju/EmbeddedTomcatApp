package com.MyWepOne.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public Bank serchingBankService(Long bankid)
	{
		EntityManager em = RootContoller.emf.createEntityManager();
		Bank bank = bankdao.findByBankid(bankid, em);

		return bank;
	
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
	// 송금을 하는 최종 서비스 
	//파라미터는 : 보내는계좌,받는사람의 은행이름, 받는사람의 계좌번호, 송금금액 
 	public void transferService(Long frombankID, String bankname,String bankaccount,Long amount)
	{
		EntityManager em = RootContoller.emf.createEntityManager();
		EntityTransaction etr = em.getTransaction();
		Bank bank = this.serchingBankService(frombankID); // 보내는 사람의 id 로 Dao 클래스를 활용해서 bank를 받음
		List<Bank> banks = new ArrayList<>();
		try
		{
			etr.begin();
			if(bank != null)
			{
				bank.addmoney(-amount);
				bankdao.subtractionMoney(bank, amount,em);
				
				
				banks = bankdao.findByBankName(em, bankname);
				Bank temp  = bankdao.findByBankAccountWithBankId(banks, bankaccount);
				bankdao.addmoney(bank, amount,em);
				
			}

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
