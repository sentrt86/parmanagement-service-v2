package com.htc.par.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SkillTO {
	
	private Integer skillId;
	
	@NotNull
	@NotEmpty(message="Skill name is mandatory")
	@Size(min=2, max=30)
	private String skillName;
	private Boolean skillActive;
	public SkillTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkillTO(Integer skillId,
			@NotNull @NotEmpty(message = "Skill name is mandatory") @Size(min = 2, max = 30) String skillName,
			Boolean skillActive) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillActive = skillActive;
	}
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Boolean getSkillActive() {
		return skillActive;
	}
	public void setSkillActive(Boolean skillActive) {
		this.skillActive = skillActive;
	}
	@Override
	public String toString() {
		return "SkillTO [skillId=" + skillId + ", skillName=" + skillName + ", skillActive=" + skillActive + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillActive == null) ? 0 : skillActive.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillTO other = (SkillTO) obj;
		if (skillActive == null) {
			if (other.skillActive != null)
				return false;
		} else if (!skillActive.equals(other.skillActive))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}
	
	
	

}
