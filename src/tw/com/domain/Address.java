package tw.com.domain;

/**
 * ShopAddress entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private String id;
	private User user;//多對一，從對象
	private String accept;
	private String zip;
	private String phoneNum;
	private String city;
	private String area;
	private String address;
	private String isdefault;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String id, User user, String phoneNum, String city, String area, String address,
			String isdefault) {
		this.id = id;
		this.user = user;
		this.phoneNum = phoneNum;
		this.city = city;
		this.area = area;
		this.address = address;
		this.isdefault = isdefault;
	}

	/** full constructor */
	public Address(String id, User user, String accept, String zip, String phoneNum, String city,
			String area, String address, String isdefault) {
		this.id = id;
		this.user = user;
		this.accept = accept;
		this.zip = zip;
		this.phoneNum = phoneNum;
		this.city = city;
		this.area = area;
		this.address = address;
		this.isdefault = isdefault;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccept() {
		return this.accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", user=" + user + ", accept=" + accept + ", zip=" + zip + ", phoneNum=" + phoneNum
				+ ", city=" + city + ", area=" + area + ", address=" + address + ", isdefault=" + isdefault + "]";
	}

	
}