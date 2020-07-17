package tw.com.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * ShopCategory entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Integer goodsNum;
	private Set<Goods> goods = new HashSet(0);// 一對多，主對象
	// Constructors

	/** default constructor */
	public Category() {
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

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", goodsNum=" + goodsNum + "]";
	}

}