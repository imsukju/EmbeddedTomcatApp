package com.MyWepOne.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	@Column(name="REAL_ID")
	private Long realID;
	
	@Column(name = "USER_ID", unique = true)
	private String userId;

	private String userPasswd;
	
	private String userName;
	
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Bank> banks = new ArrayList<>();
	

	

}
