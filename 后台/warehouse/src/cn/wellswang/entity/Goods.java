package cn.wellswang.entity;

public class Goods {
	private String goods_sku;
	private String goods_name;
	private Integer goods_numberEachBox;
	private Integer goods_boxNumber;
	private Double goods_eachPrice;
	private Double goods_eachWeight;
	private String goods_material;
	private Double goods_length;
	private Double goods_width;
	private Double goods_height;
	private String goods_barCode;
	public Goods() {
		
	}
	public Goods(String goods_sku, String goods_name, Integer goods_numberEachBox, Integer goods_boxNumber,
			Double goods_eachPrice, Double goods_eachWeight, String goods_material, Double goods_length,
			Double goods_width, Double goods_height, String goods_barCode) {
		super();
		this.goods_sku = goods_sku;
		this.goods_name = goods_name;
		this.goods_numberEachBox = goods_numberEachBox;
		this.goods_boxNumber = goods_boxNumber;
		this.goods_eachPrice = goods_eachPrice;
		this.goods_eachWeight = goods_eachWeight;
		this.goods_material = goods_material;
		this.goods_length = goods_length;
		this.goods_width = goods_width;
		this.goods_height = goods_height;
		this.goods_barCode = goods_barCode;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public void setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Integer getGoods_numberEachBox() {
		return goods_numberEachBox;
	}
	public void setGoods_numberEachBox(Integer goods_numberEachBox) {
		this.goods_numberEachBox = goods_numberEachBox;
	}
	public Integer getGoods_boxNumber() {
		return goods_boxNumber;
	}
	public void setGoods_boxNumber(Integer goods_boxNumber) {
		this.goods_boxNumber = goods_boxNumber;
	}
	public Double getGoods_eachPrice() {
		return goods_eachPrice;
	}
	public void setGoods_eachPrice(Double goods_eachPrice) {
		this.goods_eachPrice = goods_eachPrice;
	}
	public Double getGoods_eachWeight() {
		return goods_eachWeight;
	}
	public void setGoods_eachWeight(Double goods_eachWeight) {
		this.goods_eachWeight = goods_eachWeight;
	}
	public String getGoods_material() {
		return goods_material;
	}
	public void setGoods_material(String goods_material) {
		this.goods_material = goods_material;
	}
	public Double getGoods_length() {
		return goods_length;
	}
	public void setGoods_length(Double goods_length) {
		this.goods_length = goods_length;
	}
	public Double getGoods_width() {
		return goods_width;
	}
	public void setGoods_width(Double goods_width) {
		this.goods_width = goods_width;
	}
	public Double getGoods_height() {
		return goods_height;
	}
	public void setGoods_height(Double goods_height) {
		this.goods_height = goods_height;
	}
	public String getGoods_barCode() {
		return goods_barCode;
	}
	public void setGoods_barCode(String goods_barCode) {
		this.goods_barCode = goods_barCode;
	}
	
}
