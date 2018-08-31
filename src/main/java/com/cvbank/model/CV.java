package com.cvbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CV {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private int profile_id;//1 profile many CV

	@Column(name = "language_list", length = 255)
	private String language_list;

	@Column(name = "general_description", length = 255)
	private String general_description;

	@Column(name = "self_description", length = 255)
	private String self_description;

	@Column(name = "position", length = 255)
	private String position;

	@Column(name = "email", length = 255)
	private String email;

	@Column(name = "phone", length = 255)
	private String phone;

	@Column(name = "residence", length = 255)
	private String residence;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "salary")
	private int salary;

	@Column(name = "linkedin", length = 255)
	private String linkedin;

	@OneToMany(mappedBy="cv"/*, fetch = FetchType.LAZY*/)
	private List<CVactivity> cvActivity;
}






