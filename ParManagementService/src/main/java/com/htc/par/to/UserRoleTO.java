package com.htc.par.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRoleTO {
	
	
	private Integer userRoleId;
	
	@NotNull
	@NotEmpty(message="User Role name is mandatory")
	@Size(min=2, max=30)
	private String userRoleName;

	public UserRoleTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleTO(Integer userRoleId,
			@NotNull @NotEmpty(message = "User Role name is mandatory") @Size(min = 2, max = 30) String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		result = prime * result + ((userRoleName == null) ? 0 : userRoleName.hashCode());
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
		UserRoleTO other = (UserRoleTO) obj;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		if (userRoleName == null) {
			if (other.userRoleName != null)
				return false;
		} else if (!userRoleName.equals(other.userRoleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRoleTO [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + "]";
	}
	
	
	

}
