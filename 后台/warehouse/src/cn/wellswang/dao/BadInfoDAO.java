package cn.wellswang.dao;

import java.util.ArrayList;

import cn.wellswang.entity.Bad;

public interface BadInfoDAO {
	// 增
	public int insertBadInfo(Bad newBad);
	// 删
	public int deleteBadInfo(Bad deleteBad);
	// 改
	public int updateBadInfo(Bad oldBad, Bad newBad);
	// 查
	public Bad getBadById(Integer bad_id);
	public ArrayList<Bad> getAll();
	
}
