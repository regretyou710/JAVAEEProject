package tw.com.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * ShopUser entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String ID;
	private String name;
	private String password;
	private String phoneNum;
	private float money;
	private String avatar;
	private String regTime;
	private String role;
	private Set addresses = new HashSet(0);// 一對多，主對象

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String ID, String name, String password, String phoneNum, String regTime, String role) {
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.phoneNum = phoneNum;
		this.regTime = regTime;
		this.role = role;
	}

	/** full constructor */
	public User(String ID, String name, String password, String phoneNum, Float money, String avatar, String regTime,
			String role, Set addresses) {
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.phoneNum = phoneNum;
		this.money = money;
		this.avatar = avatar;
		this.regTime = regTime;
		this.role = role;
		this.addresses = addresses;
	}

	// Property accessors

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public float getMoney() {
		return this.money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRegTime() {
		return this.regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", password=" + password + ", phoneNum=" + phoneNum + ", money="
				+ money + ", avatar=" + avatar + ", regTime=" + regTime + ", role=" + role + ", addresses=" + addresses
				+ "]";
	}

}