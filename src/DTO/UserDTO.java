package DTO;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private String userId;
	private String name;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + "]";
	}
}
