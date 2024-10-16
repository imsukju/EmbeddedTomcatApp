package com.MyWepOne.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("bankDao")
public class BankDao {
	public void addBank()
	{
		
	}

}
