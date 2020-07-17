package tw.com.domain;

/**
 * ShopGoods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private String id;
	private Category category;// 多對一，從對象
	private String goodsNo;
	private String name;
	private float price1;
	private float price2;
	private Integer stock;
	private String thumbnail;
	private String description;

	// Constructors

	/** default constructor */
	public Goods() {}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getGoodsNo() {
		return this.goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice1() {
		return this.price1;
	}

	public void setPrice1(float price1) {
		this.price1 = price1;
	}

	public float getPrice2() {
		return this.price2;
	}

	public void setPrice2(float price2) {
		this.price2 = price2;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", category=" + category + ", goodsNo=" + goodsNo + ", name=" + name + ", price1="
				+ price1 + ", price2=" + price2 + ", stock=" + stock + ", thumbnail=" + thumbnail + ", description="
				+ description + "]";
	}

}