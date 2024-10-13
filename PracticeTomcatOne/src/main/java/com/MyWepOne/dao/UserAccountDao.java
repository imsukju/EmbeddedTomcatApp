package com.MyWepOne.dao;

import com.MyWepOne.entity.Users;

import jakarta.persistence.EntityManagerFactory;

public interface UserAccountDao 
{

	void createAccount(Users user);
	Users findByUserId(String userId, EntityManagerFactory emf);
}
