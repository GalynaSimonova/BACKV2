package com.cvbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class CVactivity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	//private Long cv_id;//1 CV many CV activity
	@Column(name = "activity_type", length = 255)
	private String activity_type;

	@Column(name = "position", length = 255)
	private String position;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "year_start")
	private int year_start;

	@Column(name = "year_end")
	private int year_end;

	@ManyToOne/*(fetch = FetchType.LAZY, optional = false)*/
	@JoinColumn(name="cv_id")
	private CV cv;

}





