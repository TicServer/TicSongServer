package DTO;

import java.io.Serializable;

public class FriendView implements Serializable {
	
	private String userId;
	private String name;
	private int exp;
	private int userLevel;
	
	public FriendView() {
		// TODO Auto-generated constructor stub
	}

	public FriendView(String userId, String name, int exp, int userLevel) {
		super();
		this.userId = userId;
		this.name = name;
		this.exp = exp;
		this.userLevel = userLevel;
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

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "FriendView [userId=" + userId + ", name=" + name + ", exp="
				+ exp + ", userLevel=" + userLevel + "]";
	}
}
