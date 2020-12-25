package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.entity.Manager;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.Supplier;
import cn.wellswang.utils.DBUtils;

public class OrderInfoDAOImpl implements OrderInfoDAO {

	@Override
	public int insertOrderInfo(Order newOrder) {
		Integer order_id = newOrder.getOrder_id();
		Integer man_id = newOrder.getMan_id();
		Integer supplier_id = newOrder.getSupplier_id();
		String goods_sku = newOrder.getGoods_sku();
		Integer order_boxNumber = newOrder.getOrder_boxNumber();
		Double order_freight = newOrder.getOrder_freight();
		Double order_deposit = newOrder.getOrder_deposit();
		Date order_time = newOrder.getOrder_time();
		Integer order_status = newOrder.getOrder_status();
		String insertSQL = "INSET INTO orders(order_id, man_id, supplier_id, goods_sku, order_boxNumber, "
				+ "order_freight, order_deposit, order_time, order_status) "
				+ "VALUES("
				+ order_id + ","
				+ man_id + ","
				+ supplier_id + ",'"
				+ goods_sku + "',"
				+ order_boxNumber + ","
				+ order_freight + ","
				+ order_deposit + ","
				+ order_time + ","
				+ order_status
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
		String deleteSQL = "DELETE FROM orders WHERE order_id = " + deleteOrder.getOrder_id();
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
	public Order getOrderById(Integer order_id) {
		String selectSQL = "SELECT * FROM orders WHERE order_id = " + order_id;
		Order order = new Order();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				order.setOrder_id(rs.getInt("order_id"));
				order.setMan_id(rs.getInt("man_id"));
				order.setSupplier_id(rs.getInt("supplier_id"));
				order.setGoods_sku(rs.getString("goods_sku"));
				order.setOrder_boxNumber(rs.getInt("order_boxNumber"));
				order.setOrder_freight(rs.getDouble("order_freight"));
				order.setOrder_deposit(rs.getDouble("order_deposit"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setOrder_status(rs.getInt("order_status"));
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
				currentOrder.setOrder_id(rs.getInt("order_id"));
				currentOrder.setMan_id(rs.getInt("man_id"));
				currentOrder.setSupplier_id(rs.getInt("supplier_id"));
				currentOrder.setGoods_sku(rs.getString("goods_sku"));
				currentOrder.setOrder_boxNumber(rs.getInt("order_boxNumber"));
				currentOrder.setOrder_freight(rs.getDouble("order_freight"));
				currentOrder.setOrder_deposit(rs.getDouble("order_deposit"));
				currentOrder.setOrder_time(rs.getDate("order_time"));
				currentOrder.setOrder_status(rs.getInt("order_status"));
				orders.add(currentOrder);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return orders;
	}

}
