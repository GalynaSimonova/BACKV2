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
public class CV {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int profile_id;//1 profile many CV
	private String language_list;
	private String general_description;
	private String self_description;
	private String position;
	private String email;
	private String phone;
	private String residence;
	private Date birthday;
	private int salary;
	private String linkedin;


}





