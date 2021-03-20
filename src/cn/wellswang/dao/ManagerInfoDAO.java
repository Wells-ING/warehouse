package cn.wellswang.dao;

import cn.wellswang.entity.Manager;

import java.util.ArrayList;

public interface ManagerInfoDAO {
	// 增
	public int insertManagerInfo(Manager newManager);
	// 删
	public int deleteManagerInfo(Manager deleteManager);
	// 改
	public int updateManagerInfo(Manager oldManager, Manager newManager);
	// 查询某个商品
	public Manager getManagerById(Integer manager_id);
	// 查询所有商品
	public ArrayList<Manager> getAll();
	// 登陆
	public boolean login(Integer man_type, Integer man_id, String man_password);
	// 获取当前用户姓名
	public String getCurrentuserName(Integer man_id);
    boolean modifyPassword(Integer managerId, String oldPassword, String newPassword);
    boolean modifyPassword(Integer managerId, String newPassword);

	boolean isTruePassword(Integer currentManager, String oldPassword);

    Integer getManagerIdByName(String managerName);

    ArrayList<Manager> getManagerByLike(String keyWords);

	Integer deleteManagerById(Integer managerId);

    Integer modifyManagerById(Integer manId, String manName, String manPassword, Integer manType);
}
