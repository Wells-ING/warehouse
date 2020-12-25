package cn.wellswang.entity;

public class Bad {
	private Integer bad_id;
	private Integer order_id;
	private Integer man_id;
	private Integer bad_boxNumber;
	private String bad_decoration;
	public Bad() {
		
	}
	public Bad(Integer bad_id, Integer order_id, Integer man_id, Integer bad_boxNumber, String bad_decoration) {
		super();
		this.bad_id = bad_id;
		this.order_id = order_id;
		this.man_id = man_id;
		this.bad_boxNumber = bad_boxNumber;
		this.bad_decoration = bad_decoration;
	}
	public Integer getBad_id() {
		return bad_id;
	}
	public void setBad_id(Integer bad_id) {
		this.bad_id = bad_id;
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
	public Integer getBad_boxNumber() {
		return bad_boxNumber;
	}
	public void setBad_boxNumber(Integer bad_boxNumber) {
		this.bad_boxNumber = bad_boxNumber;
	}
	public String getBad_decoration() {
		return bad_decoration;
	}
	public void setBad_decoration(String bad_decoration) {
		this.bad_decoration = bad_decoration;
	}
	
}
