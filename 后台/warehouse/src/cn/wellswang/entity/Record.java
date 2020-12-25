package cn.wellswang.entity;

import java.sql.Date;

public class Record {
	private Integer record_id;
	private Integer man_id;
	private String goods_sku;
	private Integer supplier_id;
	private Integer goods_number;
	private Integer record_type;
	private Date record_time;
	public Record() {
		
	}
	
	public Record(Integer record_id, Integer man_id, String goods_sku, Integer supplier_id, Integer goods_number,
			Integer record_type, Date record_time) {
		super();
		this.record_id = record_id;
		this.man_id = man_id;
		this.goods_sku = goods_sku;
		this.supplier_id = supplier_id;
		this.goods_number = goods_number;
		this.record_type = record_type;
		this.record_time = record_time;
	}

	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getMan_id() {
		return man_id;
	}
	public void setMan_id(Integer man_id) {
		this.man_id = man_id;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public void setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
	}
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Integer getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}
	public Integer getRecord_type() {
		return record_type;
	}
	public void setRecord_type(Integer record_type) {
		this.record_type = record_type;
	}
	public Date getRecord_time() {
		return record_time;
	}
	public void setRecord_time(Date record_time) {
		this.record_time = record_time;
	}
	
}
