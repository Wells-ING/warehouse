package cn.wellswang.entity;

public class Record {
	private Integer recordId;
	private Integer manId;
	private Integer orderId;
	private String goodsSku;
	private Integer supplierId;
	private Integer goodsNumber;
	private Integer recordType;
	private String recordTime;
	public Record() {
		
	}
	
	public Record(Integer recordId, Integer manId, String goodsSku, Integer supplierId, Integer goodsNumber,
			Integer recordType, String recordTime) {
		super();
		this.recordId = recordId;
		this.manId = manId;
		this.goodsSku = goodsSku;
		this.supplierId = supplierId;
		this.goodsNumber = goodsNumber;
		this.recordType = recordType;
		this.recordTime = recordTime;
	}
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getManId() {
		return manId;
	}

	public void setManId(Integer manId) {
		this.manId = manId;
	}

	public String getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(String goodsSku) {
		this.goodsSku = goodsSku;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
}
