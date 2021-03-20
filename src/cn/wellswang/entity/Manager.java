package cn.wellswang.entity;

public class Manager {
	private Integer manId;
	private String manName;
	private String manPassword;
	private Integer manType;
	public Manager() {
		
	}
	public Manager(Integer manId, String manName, String manPassword, Integer manType) {
		super();
		this.manId = manId;
		this.manName = manName;
		this.manPassword = manPassword;
		this.manType = manType;
	}

	public Integer getManId() {
		return manId;
	}

	public void setManId(Integer manId) {
		this.manId = manId;
	}

	public String getManName() {
		return manName;
	}

	public void setManName(String manName) {
		this.manName = manName;
	}

	public String getManPassword() {
		return manPassword;
	}

	public void setManPassword(String manPassword) {
		this.manPassword = manPassword;
	}

	public Integer getManType() {
		return manType;
	}

	public void setManType(Integer manType) {
		this.manType = manType;
	}
}
