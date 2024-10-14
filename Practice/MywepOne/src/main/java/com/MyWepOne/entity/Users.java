package com.MyWepOne.entity;

import java.io.File;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long RealID;
	
	private String UserId;

	private String UserPasswd;
	
	private String UserName;
	
	private String BankAccount;
	

}
