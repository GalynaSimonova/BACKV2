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
	private Long id;
	private int cv_id;//1 CV many CV activity
	private String activity_type;
	private String position;
	private String description;
	private int year_start;
	private int year_end;

}





