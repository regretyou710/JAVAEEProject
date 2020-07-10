package tw.com.domain;

import java.io.Serializable;
import java.util.Date;

//entity
public class User implements Serializable {
	private String ID;
	private String name;
	private String password;
	private String phoneNum;
	private Float money;
	private String avatar;
	private Date regTime;
	private String role;

	public User() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", password=" + password + ", phoneNum=" + phoneNum + ", money="
				+ money + ", avatar=" + avatar + ", regTime=" + regTime + ", role=" + role + "]";
	}

}
