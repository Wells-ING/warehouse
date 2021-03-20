package cn.wellswang.dao.impl;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.entity.Goods;
import cn.wellswang.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GoodsInfoDAOImpl implements GoodsInfoDAO {

	@Override
	public int insertGoodsInfo(Goods newGoods) {
		String goodsSku = newGoods.getGoodsSku();
		String goodsName = newGoods.getGoodsName();
		Integer goodsNumberEachBox = newGoods.getGoodsNumberEachBox();
		Integer goodsBoxNumber = newGoods.getGoodsBoxNumber();
		Double goodsEachPrice = newGoods.getGoodsEachPrice();
		Double goodsEachWeight = newGoods.getGoodsEachWeight();
		String goodsMaterial = newGoods.getGoodsMaterial();
		Double boxLength = newGoods.getBoxLength();
		Double boxWidth = newGoods.getBoxWidth();
		Double boxHeight = newGoods.getBoxHeight();
		String goodsBarCode = newGoods.getGoodsBarCode();
		String insertSQL = "INSERT INTO goods(goods_sku, goods_name, goods_numberEachBox, goods_boxNumber, goods_eachPrice, "
				+ "goods_eachWeight, goods_material, box_length, box_width, box_height, goods_barCode) "
				+ "VALUES('"
				+ goodsSku + "','"
				+ goodsName + "',"
				+ goodsNumberEachBox + ","
				+ goodsBoxNumber +","
				+ goodsEachPrice + ","
				+ goodsEachWeight + ",'"
				+ goodsMaterial + "',"
				+ boxLength + ","
				+ boxWidth + ","
				+ boxHeight + ",'"
				+ goodsBarCode + "'"
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
		String deleteSQL = "DELETE FROM goods WHERE goods_sku = '" + deleteGoods.getGoodsSku() + "'";
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
	public int updateGoodsInfo(Goods newGoods) {
		String goodsSku = newGoods.getGoodsSku();
		String goodsName = newGoods.getGoodsName();
		Integer goodsNumberEachBox = newGoods.getGoodsNumberEachBox();
		Integer goodsBoxNumber = newGoods.getGoodsBoxNumber();
		Double goodsEachPrice = newGoods.getGoodsEachPrice();
		Double goodsEachWeight = newGoods.getGoodsEachWeight();
		String goodsMaterial = newGoods.getGoodsMaterial();
		Double boxLength = newGoods.getBoxLength();
		Double boxWidth = newGoods.getBoxWidth();
		Double boxHeight = newGoods.getBoxHeight();
		String goodsBarCode = newGoods.getGoodsBarCode();
		String updateSQL = "UPDATE goods SET "
							+ "goods_name = '" + goodsName + "',"
							+ "goods_numberEachBox = " + goodsNumberEachBox + ","
							+ "goods_boxNumber = " + goodsBoxNumber + ","
							+ "goods_eachPrice = " + goodsEachPrice + ","
							+ "goods_eachWeight = " + goodsEachWeight + ","
							+ "goods_material = '" + goodsMaterial + "',"
							+ "box_length = " + boxLength + ","
							+ "box_width = " + boxWidth + ","
							+ "box_height = " + boxHeight + ","
							+ "goods_barCode = '" + goodsBarCode + "'"
							+ " WHERE goods_sku = '" + goodsSku + "'";
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
	public Goods getGoodsById(String goods_sku) {
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
				goods.setGoodsSku(rs.getString("goods_sku"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsNumberEachBox(rs.getInt("goods_numberEachBox"));
				goods.setGoodsBoxNumber(rs.getInt("goods_boxNumber"));
				goods.setGoodsEachPrice(rs.getDouble("goods_eachPrice"));
				goods.setGoodsEachWeight(rs.getDouble("goods_eachWeight"));
				goods.setGoodsMaterial(rs.getString("goods_material"));
				goods.setBoxLength(rs.getDouble("box_length"));
				goods.setBoxWidth(rs.getDouble("box_width"));
				goods.setBoxHeight(rs.getDouble("box_height"));
				goods.setGoodsBarCode(rs.getString("goods_barCode"));
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
				currentGoods.setGoodsSku(rs.getString("goods_sku"));
				currentGoods.setGoodsName(rs.getString("goods_name"));
				currentGoods.setGoodsNumberEachBox(rs.getInt("goods_numberEachBox"));
				currentGoods.setGoodsBoxNumber(rs.getInt("goods_boxNumber"));
				currentGoods.setGoodsEachPrice(rs.getDouble("goods_eachPrice"));
				currentGoods.setGoodsEachWeight(rs.getDouble("goods_eachWeight"));
				currentGoods.setGoodsMaterial(rs.getString("goods_material"));
				currentGoods.setBoxLength(rs.getDouble("box_length"));
				currentGoods.setBoxWidth(rs.getDouble("box_width"));
				currentGoods.setBoxHeight(rs.getDouble("box_height"));
				currentGoods.setGoodsBarCode(rs.getString("goods_barCode"));
				goods.add(currentGoods);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return goods;
	}

	@Override
	public String getGoodsName(String goods_sku) {
		String selectSQL = "SELECT * FROM goods WHERE goods_sku = '" + goods_sku + "'";
		String goodsName = "";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			goodsName = rs.getString("goods_name");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return goodsName;
	}

	@Override
	public boolean isExit(String goodsSku) {
		String selectSQL = "SELECT count(*) FROM goods WHERE goods_sku = '" + goodsSku + "'";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int updateGoodsNumber(String goodsSku, Integer goodsNumber) {
		String updateSQL = "UPDATE goods SET "
				+ "goods_boxNumber = '" + goodsNumber + "'"
				+ " WHERE goods_sku = '" + goodsSku + "'";
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
	public ArrayList<Goods> likeSelectGoods(String likeStr) {
		String selectSQL = "SELECT * FROM goods WHERE goods_name like '%" + likeStr + "%'";
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
				currentGoods.setGoodsSku(rs.getString("goods_sku"));
				currentGoods.setGoodsName(rs.getString("goods_name"));
				currentGoods.setGoodsNumberEachBox(rs.getInt("goods_numberEachBox"));
				currentGoods.setGoodsBoxNumber(rs.getInt("goods_boxNumber"));
				currentGoods.setGoodsEachPrice(rs.getDouble("goods_eachPrice"));
				currentGoods.setGoodsEachWeight(rs.getDouble("goods_eachWeight"));
				currentGoods.setGoodsMaterial(rs.getString("goods_material"));
				currentGoods.setBoxLength(rs.getDouble("box_length"));
				currentGoods.setBoxWidth(rs.getDouble("box_width"));
				currentGoods.setBoxHeight(rs.getDouble("box_height"));
				currentGoods.setGoodsBarCode(rs.getString("goods_barCode"));
				goods.add(currentGoods);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return goods;
	}

	@Override
	public Integer getGoodsBoxNumber(String goodsSku) {
		String selectSQL = "SELECT * FROM goods WHERE goods_sku = '" + goodsSku + "'";
		Integer goodsBoxNumber = 0;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			goodsBoxNumber = rs.getInt("goods_boxNumber");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return goodsBoxNumber;
	}

	@Override
	public Integer modifyGoodsBoxNumber(String goodsSku, Integer newGoodsBoxNumber) {
		String updateSQL = "UPDATE goods SET "
				+ "goods_boxNumber = " + newGoodsBoxNumber
				+ " WHERE goods_sku = '" + goodsSku + "'";
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
	public Integer deleteGoodsInfoByGoodsSku(String goodsSku) {
		String deleteSQL = "DELETE FROM goods WHERE goods_sku = '" + goodsSku + "'";
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
}
