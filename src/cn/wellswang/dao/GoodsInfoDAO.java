package cn.wellswang.dao;

import cn.wellswang.entity.Goods;

import java.util.ArrayList;

public interface GoodsInfoDAO {
	// 增
	public int insertGoodsInfo(Goods newGoods);
	// 删
	public int deleteGoodsInfo(Goods deleteGoods);
	// 改
	public int updateGoodsInfo(Goods newGoods);
	// 查询某个商品
	public Goods getGoodsById(String goods_sku);
	// 查询所有商品
	public ArrayList<Goods> getAll();
	// 根据商品sku查询商品名称
	public String getGoodsName(String goods_sku);
	// 判断商品是否存在
	public boolean isExit(String goodsSku);
	// 修改商品的数量
	public int updateGoodsNumber(String goodsSku, Integer goodsNumber);
	// 品名模糊查询
	public ArrayList<Goods> likeSelectGoods(String likeStr);

    Integer getGoodsBoxNumber(String goodsSku);

    Integer modifyGoodsBoxNumber(String goodsSku, Integer newGoodsBoxNumber);

    Integer deleteGoodsInfoByGoodsSku(String goodsSku);
}
