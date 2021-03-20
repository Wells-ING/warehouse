package cn.wellswang.dao;

import cn.wellswang.entity.Bad;

import java.util.ArrayList;

public interface BadInfoDAO {
	// 增
	public int insertBadInfo(Bad newBad);
	// 删
	public int deleteBadInfo(Bad deleteBad);
	// 改
	public int updateBadInfo(Bad oldBad, Bad newBad);
	// 查询某退货单
	public Bad getBadById(Integer bad_id);
	// 查询所有退货单
	public ArrayList<Bad> getAll();
	// 根据订单查询退货单
	public Bad getBadByOrder(Integer orderId);

    ArrayList<Bad> getAllByCurrentManagerId(Integer currentManagerId);

	Bad getBadByOrderAndCurrentManagerId(Integer currentManagerId, Integer orderId);

    Integer deleteBadByBadId(Integer badId);

    Integer getBadBoxNumberById(Integer badId);

	Integer mofiyBadById(Integer badId, Integer badBoxNumber, String badDecoration, Integer managerId);
}
