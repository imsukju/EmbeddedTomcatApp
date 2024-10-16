package com.MyWepOne.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.MyWepOne.dao.UserAccountDao;
import com.MyWepOne.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;


@Service
public class UserAccountService 
{

	@Autowired
	@Qualifier("userAccountDaoImpl")
	UserAccountDao userAccountDao;
	


	
	public void saveUser(Users user, EntityManagerFactory emf)
	{
	    EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

	    EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try
		{
			tx.begin();
			em.persist(user);
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
	
	public Users checkLogin(String id, String pw, EntityManagerFactory emf)
	{
		
		Users findid = userAccountDao.findByUserId(id, emf);
		
		if(findid !=null)
		{
			if(findid.getUserPasswd().equals(pw))
			{
				return findid;
			}
		}
		
		else
		{
			return null;
		}
		
		return null;

	}
	
	

}
