package cn.wellswang.entity;

public class Order {
	private Integer orderId;
	private Integer manId;
	private Integer supplierId;
	private String goodsSku;
	private Integer orderBoxNumber;
	private Double orderFreight;
	private Double orderDeposit;
	private String orderTime;
	private Integer orderStatus;
	public Order() {
		
	}
	public Order(Integer orderId, Integer manId, Integer supplierId, String goodsSku, Integer orderBoxNumber,
			Double orderFreight, Double orderDeposit, String orderTime, Integer orderStatus) {
		super();
		this.orderId = orderId;
		this.manId = manId;
		this.supplierId = supplierId;
		this.goodsSku = goodsSku;
		this.orderBoxNumber = orderBoxNumber;
		this.orderFreight = orderFreight;
		this.orderDeposit = orderDeposit;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getManId() {
		return manId;
	}

	public void setManId(Integer manId) {
		this.manId = manId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(String goodsSku) {
		this.goodsSku = goodsSku;
	}

	public Integer getOrderBoxNumber() {
		return orderBoxNumber;
	}

	public void setOrderBoxNumber(Integer orderBoxNumber) {
		this.orderBoxNumber = orderBoxNumber;
	}

	public Double getOrderFreight() {
		return orderFreight;
	}

	public void setOrderFreight(Double orderFreight) {
		this.orderFreight = orderFreight;
	}

	public Double getOrderDeposit() {
		return orderDeposit;
	}

	public void setOrderDeposit(Double orderDeposit) {
		this.orderDeposit = orderDeposit;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
}
