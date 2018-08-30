package com.cvbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class XrefCvSkill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int cvId;//1 CV many xrefCVskill
	private int skillGroupId;//many to many
	private int skillId;//many to many

}





