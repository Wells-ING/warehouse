package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wellswang.entity.Bad;
import cn.wellswang.entity.Goods;
import cn.wellswang.utils.DBUtils;
import cn.wellswang.dao.GoodsInfoDAO;

public class GoodsInfoDAOImpl implements GoodsInfoDAO {

	@Override
	public int insertGoodsInfo(Goods newGoods) {
		String goods_sku = newGoods.getGoods_sku();
		String goods_name = newGoods.getGoods_name();
		Integer goods_numberEachBox = newGoods.getGoods_numberEachBox();
		Integer goods_boxNumber = newGoods.getGoods_boxNumber();
		Double goods_eachPrice = newGoods.getGoods_eachPrice();
		Double goods_eachWeight = newGoods.getGoods_eachWeight();
		String goods_material = newGoods.getGoods_material();
		Double goods_length = newGoods.getGoods_length();
		Double goods_width = newGoods.getGoods_width();
		Double goods_height = newGoods.getGoods_height();
		String goods_barCode = newGoods.getGoods_barCode();
		String insertSQL = "INSET INTO goods(goods_sku, goods_name, goods_numberEachBox, goods_boxNumber, goods_eachPrice, "
				+ "goods_eachWeight, goods_material, goods_length, goods_width, goods_height, goods_barCode) "
				+ "VALUES('"
				+ goods_sku + "','"
				+ goods_name + "',"
				+ goods_numberEachBox + ","
				+ goods_boxNumber +","
				+ goods_eachPrice + ","
				+ goods_eachWeight + ",'"
				+ goods_material + "',"
				+ goods_length + ","
				+ goods_width + ","
				+ goods_height + ",'"
				+ goods_barCode + "'"
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
	public int deleteGoodsInfo(Goods deleteGoods) {
		String deleteSQL = "DELETE FROM goods WHERE goods_sku = '" + deleteGoods.getGoods_sku() + "'";
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
	public int updateGoodsInfo(Goods oldGoods, Goods newGoods) {
		String goods_sku = oldGoods.getGoods_sku();
		String goods_name = newGoods.getGoods_name();
		Integer goods_numberEachBox = newGoods.getGoods_numberEachBox();
		Integer goods_boxNumber = newGoods.getGoods_boxNumber();
		Double goods_eachPrice = newGoods.getGoods_eachPrice();
		Double goods_eachWeight = newGoods.getGoods_eachWeight();
		String goods_material = newGoods.getGoods_material();
		Double goods_length = newGoods.getGoods_length();
		Double goods_width = newGoods.getGoods_width();
		Double goods_height = newGoods.getGoods_height();
		String goods_barCode = newGoods.getGoods_barCode();
		String updateSQL = "UPDATE bads SET " 
							+ "goods_name = '" + goods_name + "',"
							+ "goods_numberEachBox = " + goods_numberEachBox + ","
							+ "goods_boxNumber = " + goods_boxNumber + ","
							+ "goods_eachPrice = " + goods_eachPrice + ","
							+ "goods_eachWeight = " + goods_eachWeight + ","
							+ "goods_material = '" + goods_material + "',"
							+ "goods_length = " + goods_length + ","
							+ "goods_width = " + goods_width + ","
							+ "goods_height = " + goods_height + ","
							+ "goods_barCode = '" + goods_barCode + "'"
							+ " WHERE goods_sku = '" + goods_sku + "'";
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

	@Override
	public Goods getBadById(String goods_sku) {
		String selectSQL = "SELECT * FROM goods WHERE goods_sku = '" + goods_sku + "'";
		Goods goods = new Goods();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				goods.setGoods_sku(rs.getString("goods_sku"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_numberEachBox(rs.getInt("goods_numberEachBox"));
				goods.setGoods_boxNumber(rs.getInt("goods_boxNumber"));
				goods.setGoods_eachPrice(rs.getDouble("goods_eachPrice"));
				goods.setGoods_eachWeight(rs.getDouble("goods_eachWeight"));
				goods.setGoods_material(rs.getString("goods_material"));
				goods.setGoods_length(rs.getDouble("goods_length"));
				goods.setGoods_width(rs.getDouble("goods_width"));
				goods.setGoods_height(rs.getDouble("goods_height"));
				goods.setGoods_barCode(rs.getString("goods_barCode"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return goods;
	}

	@Override
	public ArrayList<Goods> getAll() {
		String selectSQL = "SELECT * FROM goods";
		ArrayList<Goods> goods = new ArrayList<Goods>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Goods currentGoods = new Goods();
				currentGoods.setGoods_sku(rs.getString("goods_sku"));
				currentGoods.setGoods_name(rs.getString("goods_name"));
				currentGoods.setGoods_numberEachBox(rs.getInt("goods_numberEachBox"));
				currentGoods.setGoods_boxNumber(rs.getInt("goods_boxNumber"));
				currentGoods.setGoods_eachPrice(rs.getDouble("goods_eachPrice"));
				currentGoods.setGoods_eachWeight(rs.getDouble("goods_eachWeight"));
				currentGoods.setGoods_material(rs.getString("goods_material"));
				currentGoods.setGoods_length(rs.getDouble("goods_length"));
				currentGoods.setGoods_width(rs.getDouble("goods_width"));
				currentGoods.setGoods_height(rs.getDouble("goods_height"));
				currentGoods.setGoods_barCode(rs.getString("goods_barCode"));
				goods.add(currentGoods);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return goods;
	}

}
