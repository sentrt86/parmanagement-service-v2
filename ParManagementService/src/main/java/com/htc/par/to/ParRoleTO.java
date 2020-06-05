package com.htc.par.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParRoleTO {
	
	private Integer roleId;
	
	@NotNull
	@NotEmpty(message="Role name is mandatory")
	@Size(min=2, max=30)
	private String roleName;
	private Boolean roleActive;
	
	public ParRoleTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParRoleTO(Integer roleId,
			@NotNull @NotEmpty(message = "Role name is mandatory") @Size(min = 2, max = 30) String roleName,
			Boolean roleActive) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleActive = roleActive;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getRoleActive() {
		return roleActive;
	}

	public void setRoleActive(Boolean roleActive) {
		this.roleActive = roleActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleActive == null) ? 0 : roleActive.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		ParRoleTO other = (ParRoleTO) obj;
		if (roleActive == null) {
			if (other.roleActive != null)
				return false;
		} else if (!roleActive.equals(other.roleActive))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParRoleTO [roleId=" + roleId + ", roleName=" + roleName + ", roleActive=" + roleActive + "]";
	}
	
	


}
