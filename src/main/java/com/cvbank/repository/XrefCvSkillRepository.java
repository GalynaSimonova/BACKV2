package com.cvbank.repository;

import com.cvbank.model.Skill;
import com.cvbank.model.XrefCvSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XrefCvSkillRepository extends JpaRepository<XrefCvSkill, Long> {

}
