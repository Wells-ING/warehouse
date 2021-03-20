package cn.wellswang.dao;

import cn.wellswang.entity.Order;

import java.util.ArrayList;

public interface OrderInfoDAO {
	// 增
	public int insertOrderInfo(Order newOrder);
	// 删
	public int deleteOrderInfo(Order deleteOrder);
	// 查询某个订单
	public Order getOrderById(Integer order_id);
	// 查询所有订单
	public ArrayList<Order> getAll();
	// 获取订单，根据商品sku
	public ArrayList<Order> getOrdersByGoodsSku(String goodsSku);

    ArrayList<Order> getOrderByGoodsSkuAndCurrentManagerId(Integer currentManagerId, String goodsSku);

    ArrayList<Order> getAllByCurrentManagerId(Integer currentManagerId);

    void modifyOrderState(Integer orderId, Integer state);

    Integer getBoxNumberByOrderId(Integer orderId);

    Integer deleteOrderById(Integer orderId);

	Integer modifyOrderById(Integer orderId, Double orderFreight, Double orderDeposit, String orderTime, Integer supplierId);
}
