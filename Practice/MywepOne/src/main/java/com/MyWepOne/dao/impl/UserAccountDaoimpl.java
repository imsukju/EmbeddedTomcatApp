package com.MyWepOne.dao.impl;

import jakarta.persistence.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.MyWepOne.dao.UserAccountDao;
import com.MyWepOne.entity.Bank;
import com.MyWepOne.entity.Users;


@Repository
@Qualifier("userAccountDaoImpl")
public class UserAccountDaoimpl implements UserAccountDao{


	@Override
	public void createAccount(Users user) {

		
		
	}
	
	
    public Users findByUserId(String userId, EntityManagerFactory emf) {
        // JPQL 쿼리를 사용하여 userId로 사용자를 조회
    	EntityManager em = emf.createEntityManager();
    	
        String jpql = "SELECT u FROM Users u WHERE u.userId = :userId";
        TypedQuery<Users> query = em.createQuery(jpql, Users.class);
        query.setParameter("userId", userId);

        Users user = null;
        try {
            user = query.getSingleResult();  // 한 명의 사용자 반환
        } catch (NoResultException  e) {
        	return null;

        }

        return user;
    }
    
    @Override
    public List<Bank> getAllbanks(Users user)
    {
    	return user.getBanks();
    }


}
