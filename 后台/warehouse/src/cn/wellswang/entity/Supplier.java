package cn.wellswang.entity;

public class Supplier {
	private Integer supplier_id;
	private String supplier_name;
	public Supplier() {
		
	}
	
	public Supplier(Integer supplier_id, String supplier_name) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
	}

	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	
}
