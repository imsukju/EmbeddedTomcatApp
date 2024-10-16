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
	private Long money;
	
	private String bankName;
	private String bankAccount;

}
