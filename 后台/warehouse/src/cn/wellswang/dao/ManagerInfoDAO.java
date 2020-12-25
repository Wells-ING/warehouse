package cn.wellswang.dao;

import java.util.ArrayList;

import cn.wellswang.entity.Manager;

public interface ManagerInfoDAO {
	// 增
	public int insertManagerInfo(Manager newManager);
	// 删
	public int deleteManagerInfo(Manager deleteManager);
	// 改
	public int updateManagerInfo(Manager oldManager, Manager newManager);
	// 查
	public Manager getManagerById(Integer manager_id);
	public ArrayList<Manager> getAll();
	// 登陆
	public boolean login(Integer man_type, Integer man_id, String man_password);
}
