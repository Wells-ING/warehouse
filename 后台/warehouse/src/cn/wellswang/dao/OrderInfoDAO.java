package cn.wellswang.dao;

import java.util.ArrayList;

import cn.wellswang.entity.Order;

public interface OrderInfoDAO {
	// 增
	public int insertOrderInfo(Order newOrder);
	// 删
	public int deleteOrderInfo(Order deleteOrder);
	// 查
	public Order getOrderById(Integer order_id);
	public ArrayList<Order> getAll();
}
