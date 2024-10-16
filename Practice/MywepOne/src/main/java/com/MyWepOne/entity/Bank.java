package com.MyWepOne.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long bankid;
	
    @ManyToOne
    @JoinColumn(name = "REAL_ID")
	private Users users;
	private Long money = 0L;
	
	private String bankName;
	private String bankAccount;
	
//	@Embedded
//	BankDetail bankdetail;
	
	public void addmoney(Long ammount)
	{
		this.money = this.money += ammount;
	}
	
	public void subtractionMoney(Long ammount)
	{
		this.money = this.money -= ammount;
	}

}
