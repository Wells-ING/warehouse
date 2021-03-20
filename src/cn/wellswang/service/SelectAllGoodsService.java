package cn.wellswang.service;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.GoodsPage;

import java.util.ArrayList;

public class SelectAllGoodsService {
    public static ArrayList<GoodsPage> getAllGoods() {

        ArrayList<GoodsPage> goodsPages = new ArrayList<GoodsPage>();

        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();

        ArrayList<Goods> goods =  g.getAll();

        for(Goods currentGoods : goods) {
            GoodsPage currentGoodsPage = new GoodsPage();
            currentGoodsPage.setGoodsSku(currentGoods.getGoodsSku());
            currentGoodsPage.setGoodsName(currentGoods.getGoodsName());
            currentGoodsPage.setGoodsNumberEachBox(currentGoods.getGoodsNumberEachBox());
            currentGoodsPage.setGoodsBoxNumber(currentGoods.getGoodsBoxNumber());
            currentGoodsPage.setGoodsSumNumber(currentGoods.getGoodsNumberEachBox() * currentGoods.getGoodsBoxNumber());
            currentGoodsPage.setGoodsEachPrice(currentGoods.getGoodsEachPrice());
            currentGoodsPage.setGoodsSumPrice(currentGoods.getGoodsEachPrice()
                    * currentGoods.getGoodsNumberEachBox() * currentGoods.getGoodsBoxNumber());
            currentGoodsPage.setGoodsEachWeight(currentGoods.getGoodsEachWeight());
            currentGoodsPage.setGoodsSumWeight(currentGoods.getGoodsEachWeight()
                    * currentGoods.getGoodsNumberEachBox() * currentGoods.getGoodsBoxNumber());
            currentGoodsPage.setBoxLength(currentGoods.getBoxLength());
            currentGoodsPage.setBoxWidth(currentGoods.getBoxWidth());
            currentGoodsPage.setBoxHeight(currentGoods.getBoxHeight());
            currentGoodsPage.setGoodsEachVolume(currentGoods.getBoxLength()
                    * currentGoods.getBoxWidth() * currentGoods.getBoxHeight() / 1000000);
            currentGoodsPage.setGoodsSumVolume(currentGoods.getBoxLength()
                    * currentGoods.getBoxWidth() * currentGoods.getBoxHeight() / 1000000
                    * currentGoods.getGoodsNumberEachBox());
            currentGoodsPage.setGoodsMaterial(currentGoods.getGoodsMaterial());
            currentGoodsPage.setGoodsBarCode(currentGoods.getGoodsBarCode());
            goodsPages.add(currentGoodsPage);
        }

        return goodsPages;
    }
}
