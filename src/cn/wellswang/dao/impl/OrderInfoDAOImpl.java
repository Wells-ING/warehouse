package cn.wellswang.dao.impl;

import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.entity.Order;
import cn.wellswang.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderInfoDAOImpl implements OrderInfoDAO {

	@Override
	public int insertOrderInfo(Order newOrder) {
		Integer orderId = newOrder.getOrderId();
		Integer manId = newOrder.getManId();
		Integer supplierId = newOrder.getSupplierId();
		String goodsSku = newOrder.getGoodsSku();
		Integer orderBoxNumber = newOrder.getOrderBoxNumber();
		Double orderFreight = newOrder.getOrderFreight();
		Double orderDeposit = newOrder.getOrderDeposit();
		String orderTime = newOrder.getOrderTime();
		Integer orderStatus = newOrder.getOrderStatus();
		String insertSQL = "INSERT INTO orders(man_id, supplier_id, goods_sku, order_boxNumber, "
				+ "order_freight, order_deposit, order_time, order_status) "
				+ "VALUES("
				+ manId + ","
				+ supplierId + ",'"
				+ goodsSku + "',"
				+ orderBoxNumber + ","
				+ orderFreight + ","
				+ orderDeposit + ",'"
				+ orderTime + "',"
				+ orderStatus
				+ ")";
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(insertSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}

	@Override
	public int deleteOrderInfo(Order deleteOrder) {
		String deleteSQL = "DELETE FROM orders WHERE order_id = " + deleteOrder.getOrderId();
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(deleteSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}

	@Override
	public Order getOrderById(Integer orderId) {
		String selectSQL = "SELECT * FROM orders WHERE order_id = " + orderId;
		Order order = new Order();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				order.setOrderId(rs.getInt("order_id"));
				order.setManId(rs.getInt("man_id"));
				order.setSupplierId(rs.getInt("supplier_id"));
				order.setGoodsSku(rs.getString("goods_sku"));
				order.setOrderBoxNumber(rs.getInt("order_boxNumber"));
				order.setOrderFreight(rs.getDouble("order_freight"));
				order.setOrderDeposit(rs.getDouble("order_deposit"));
				order.setOrderTime(rs.getString("order_time"));
				order.setOrderStatus(rs.getInt("order_status"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return order;
	}

	@Override
	public ArrayList<Order> getAll() {
		String selectSQL = "SELECT * FROM orders";
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Order currentOrder = new Order();
				currentOrder.setOrderId(rs.getInt("order_id"));
				currentOrder.setManId(rs.getInt("man_id"));
				currentOrder.setSupplierId(rs.getInt("supplier_id"));
				currentOrder.setGoodsSku(rs.getString("goods_sku"));
				currentOrder.setOrderBoxNumber(rs.getInt("order_boxNumber"));
				currentOrder.setOrderFreight(rs.getDouble("order_freight"));
				currentOrder.setOrderDeposit(rs.getDouble("order_deposit"));
				currentOrder.setOrderTime(rs.getString("order_time"));
				currentOrder.setOrderStatus(rs.getInt("order_status"));
				orders.add(currentOrder);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return orders;
	}

	@Override
	public ArrayList<Order> getOrdersByGoodsSku(String goodsSku) {
		String selectSQL = "SELECT * FROM orders WHERE goods_sku like '%" + goodsSku + "%'";
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Order currentOrder = new Order();
				currentOrder.setOrderId(rs.getInt("order_id"));
				currentOrder.setManId(rs.getInt("man_id"));
				currentOrder.setSupplierId(rs.getInt("supplier_id"));
				currentOrder.setGoodsSku(rs.getString("goods_sku"));
				currentOrder.setOrderBoxNumber(rs.getInt("order_boxNumber"));
				currentOrder.setOrderFreight(rs.getDouble("order_freight"));
				currentOrder.setOrderDeposit(rs.getDouble("order_deposit"));
				currentOrder.setOrderTime(rs.getString("order_time"));
				currentOrder.setOrderStatus(rs.getInt("order_status"));
				orders.add(currentOrder);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return orders;
	}

	@Override
	public ArrayList<Order> getOrderByGoodsSkuAndCurrentManagerId(Integer currentManagerId, String goodsSku) {
		String selectSQL = "SELECT * FROM orders WHERE goods_sku like '%" + goodsSku + "%' AND man_id = " + currentManagerId;
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Order currentOrder = new Order();
				currentOrder.setOrderId(rs.getInt("order_id"));
				currentOrder.setManId(rs.getInt("man_id"));
				currentOrder.setSupplierId(rs.getInt("supplier_id"));
				currentOrder.setGoodsSku(rs.getString("goods_sku"));
				currentOrder.setOrderBoxNumber(rs.getInt("order_boxNumber"));
				currentOrder.setOrderFreight(rs.getDouble("order_freight"));
				currentOrder.setOrderDeposit(rs.getDouble("order_deposit"));
				currentOrder.setOrderTime(rs.getString("order_time"));
				currentOrder.setOrderStatus(rs.getInt("order_status"));
				orders.add(currentOrder);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return orders;
	}

	@Override
	public ArrayList<Order> getAllByCurrentManagerId(Integer currentManagerId) {
		String selectSQL = "SELECT * FROM orders WHERE man_id = " + currentManagerId;
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Order currentOrder = new Order();
				currentOrder.setOrderId(rs.getInt("order_id"));
				currentOrder.setManId(rs.getInt("man_id"));
				currentOrder.setSupplierId(rs.getInt("supplier_id"));
				currentOrder.setGoodsSku(rs.getString("goods_sku"));
				currentOrder.setOrderBoxNumber(rs.getInt("order_boxNumber"));
				currentOrder.setOrderFreight(rs.getDouble("order_freight"));
				currentOrder.setOrderDeposit(rs.getDouble("order_deposit"));
				currentOrder.setOrderTime(rs.getString("order_time"));
				currentOrder.setOrderStatus(rs.getInt("order_status"));
				orders.add(currentOrder);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return orders;
	}

	@Override
	public void modifyOrderState(Integer orderId, Integer state) {
		String deleteSQL = "UPDATE orders SET order_status = " + state + " WHERE order_id = " + orderId;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			stm.executeUpdate(deleteSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
	}

	@Override
	public Integer getBoxNumberByOrderId(Integer orderId) {
		String selectSQL = "SELECT * FROM orders WHERE order_id = " + orderId;
		Integer boxNumber = 0;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				boxNumber = rs.getInt("order_boxNumber");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return boxNumber;
	}

	@Override
	public Integer deleteOrderById(Integer orderId) {
		String deleteSQL = "DELETE FROM orders WHERE order_id = " + orderId;
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(deleteSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}

	@Override
	public Integer modifyOrderById(Integer orderId, Double orderFreight, Double orderDeposit, String orderTime, Integer supplierId) {
		String updateSQL = "UPDATE orders SET "
				 + "order_freight = " + orderFreight + ", "
		         + "order_deposit = " + orderDeposit + ", "
				 + "order_time = '" + orderTime + "', "
				 + "supplier_id = '" + supplierId + "'"
				 + "WHERE order_id = " + orderId;
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(updateSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}
}
