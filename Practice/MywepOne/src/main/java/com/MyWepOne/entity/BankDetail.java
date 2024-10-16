package com.MyWepOne.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BankDetail {
	
	private String bankName;
	private String bankAccount;

}
