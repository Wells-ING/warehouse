package cn.wellswang.entity;

public class Goods {
	private String goodsSku;
	private String goodsName;
	private Integer goodsNumberEachBox;
	private Integer goodsBoxNumber;
	private Double goodsEachPrice;
	private Double goodsEachWeight;
	private String goodsMaterial;
	private Double boxLength;
	private Double boxWidth;
	private Double boxHeight;
	private String goodsBarCode;

	public Goods() {
		
	}
	public Goods(String goodsSku, String goodsName, Integer goodsNumberEachBox, Integer goodsBoxNumber,
			Double goodsEachPrice, Double goodsEachWeight, String goodsMaterial, Double boxLength,
			Double boxWidth, Double boxHeight, String goodsBarCode) {
		super();
		this.goodsSku = goodsSku;
		this.goodsName = goodsName;
		this.goodsNumberEachBox = goodsNumberEachBox;
		this.goodsBoxNumber = goodsBoxNumber;
		this.goodsEachPrice = goodsEachPrice;
		this.goodsEachWeight = goodsEachWeight;
		this.goodsMaterial = goodsMaterial;
		this.boxLength = boxLength;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.goodsBarCode = goodsBarCode;
	}

	public String getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(String goodsSku) {
		this.goodsSku = goodsSku;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNumberEachBox() {
		return goodsNumberEachBox;
	}

	public void setGoodsNumberEachBox(Integer goodsNumberEachBox) {
		this.goodsNumberEachBox = goodsNumberEachBox;
	}

	public Integer getGoodsBoxNumber() {
		return goodsBoxNumber;
	}

	public void setGoodsBoxNumber(Integer goodsBoxNumber) {
		this.goodsBoxNumber = goodsBoxNumber;
	}

	public Double getGoodsEachPrice() {
		return goodsEachPrice;
	}

	public void setGoodsEachPrice(Double goodsEachPrice) {
		this.goodsEachPrice = goodsEachPrice;
	}

	public Double getGoodsEachWeight() {
		return goodsEachWeight;
	}

	public void setGoodsEachWeight(Double goodsEachWeight) {
		this.goodsEachWeight = goodsEachWeight;
	}

	public String getGoodsMaterial() {
		return goodsMaterial;
	}

	public void setGoodsMaterial(String goodsMaterial) {
		this.goodsMaterial = goodsMaterial;
	}

	public Double getBoxLength() {
		return boxLength;
	}

	public void setBoxLength(Double boxLength) {
		this.boxLength = boxLength;
	}

	public Double getBoxWidth() {
		return boxWidth;
	}

	public void setBoxWidth(Double boxWidth) {
		this.boxWidth = boxWidth;
	}

	public Double getBoxHeight() {
		return boxHeight;
	}

	public void setBoxHeight(Double boxHeight) {
		this.boxHeight = boxHeight;
	}

	public String getGoodsBarCode() {
		return goodsBarCode;
	}

	public void setGoodsBarCode(String goodsBarCode) {
		this.goodsBarCode = goodsBarCode;
	}
}
