package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="Member")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column private long id;
	
	@Column(length=30,nullable=true)
	private String name;
	
	@Column(length=40,nullable=true)
	private String password;
	
	@Column(length=13,nullable=true)
	private String phone;
	
	@Column(length=80,nullable=true)
	private String address;

}
