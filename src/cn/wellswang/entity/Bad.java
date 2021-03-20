package cn.wellswang.entity;

public class Bad {
	private Integer badId;
	private Integer orderId;
	private Integer manId;
	private Integer badBoxNumber;
	private String badDecoration;

	public Bad() {
		
	}

	public Bad(Integer badId, Integer orderId, Integer manId, Integer badBoxNumber, String badDecoration) {
		super();
		this.badId = badId;
		this.orderId = orderId;
		this.manId = manId;
		this.badBoxNumber = badBoxNumber;
		this.badDecoration = badDecoration;
	}

	public Integer getBadId() {
		return badId;
	}

	public void setBadId(Integer badId) {
		this.badId = badId;
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

	public Integer getBadBoxNumber() {
		return badBoxNumber;
	}

	public void setBadBoxNumber(Integer badBoxNumber) {
		this.badBoxNumber = badBoxNumber;
	}

	public String getBadDecoration() {
		return badDecoration;
	}

	public void setBadDecoration(String badDecoration) {
		this.badDecoration = badDecoration;
	}
}
