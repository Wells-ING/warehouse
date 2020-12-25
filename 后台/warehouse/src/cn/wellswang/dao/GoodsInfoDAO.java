package cn.wellswang.dao;

import java.util.ArrayList;

import cn.wellswang.entity.Goods;

public interface GoodsInfoDAO {
	// 增
	public int insertGoodsInfo(Goods newGoods);
	// 删
	public int deleteGoodsInfo(Goods deleteGoods);
	// 改
	public int updateGoodsInfo(Goods oldGoods, Goods newGoods);
	// 查
	public Goods getBadById(String goods_sku);
	public ArrayList<Goods> getAll();
	
}
