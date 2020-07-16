package tw.com.domain;

/**
 * ShopCategory entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Integer goodsNum;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Category(String id, String name, Integer goodsNum) {
		this.id = id;
		this.name = name;
		this.goodsNum = goodsNum;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {		
		this.name = name;
	}

	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {		
		this.goodsNum = goodsNum;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", goodsNum=" + goodsNum + "]";
	}

}