package com.cvbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int appUserId;
	private String username;
	private String userType;
	private String languages;
	private String residence;
	private String linkedin;
	private String phone;
	private String lastName;
	private String firstName;
	private String email;
	private Date birthday;
	private String companyName;
	private String password;
	private String website;
	private String country;
	private String cityTown;
	private String street;
	private String houseBuilding;
	private String postcode;
	private String position;
}





