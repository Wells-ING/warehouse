package cn.wellswang.entity;

import java.sql.Date;

public class Order {
	private Integer order_id;
	private Integer man_id;
	private Integer supplier_id;
	private String goods_sku;
	private Integer order_boxNumber;
	private Double order_freight;
	private Double order_deposit;
	private Date order_time;
	private Integer order_status;
	public Order() {
		
	}
	public Order(Integer order_id, Integer man_id, Integer supplier_id, String goods_sku, Integer order_boxNumber,
			Double order_freight, Double order_deposit, Date order_time, Integer order_status) {
		super();
		this.order_id = order_id;
		this.man_id = man_id;
		this.supplier_id = supplier_id;
		this.goods_sku = goods_sku;
		this.order_boxNumber = order_boxNumber;
		this.order_freight = order_freight;
		this.order_deposit = order_deposit;
		this.order_time = order_time;
		this.order_status = order_status;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getMan_id() {
		return man_id;
	}
	public void setMan_id(Integer man_id) {
		this.man_id = man_id;
	}
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getGoods_sku() {
		return goods_sku;
	}
	public void setGoods_sku(String goods_sku) {
		this.goods_sku = goods_sku;
	}
	public Integer getOrder_boxNumber() {
		return order_boxNumber;
	}
	public void setOrder_boxNumber(Integer order_boxNumber) {
		this.order_boxNumber = order_boxNumber;
	}
	public Double getOrder_freight() {
		return order_freight;
	}
	public void setOrder_freight(Double order_freight) {
		this.order_freight = order_freight;
	}
	public Double getOrder_deposit() {
		return order_deposit;
	}
	public void setOrder_deposit(Double order_deposit) {
		this.order_deposit = order_deposit;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	
}
