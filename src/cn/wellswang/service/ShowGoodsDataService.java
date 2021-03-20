package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.GoodsPage;

public class ShowGoodsDataService {
    public static GoodsPage getGoodsPagesByGoodsSku(String goodsSku) {
        GoodsPage goodsPage = new GoodsPage();

        GoodsInfoDAO g = new GoodsInfoDAOImpl();

        Goods goods = g.getGoodsById(goodsSku);
        goodsPage.setGoodsSku(goods.getGoodsSku());
        goodsPage.setGoodsName(goods.getGoodsName());
        goodsPage.setGoodsNumberEachBox(goods.getGoodsNumberEachBox());
        goodsPage.setGoodsBoxNumber(goods.getGoodsBoxNumber());
        goodsPage.setGoodsSumNumber(goods.getGoodsNumberEachBox() * goods.getGoodsBoxNumber());
        goodsPage.setGoodsEachPrice(goods.getGoodsEachPrice());
        goodsPage.setGoodsSumPrice(goods.getGoodsEachPrice()
                * goods.getGoodsNumberEachBox() * goods.getGoodsBoxNumber());
        goodsPage.setGoodsEachWeight(goods.getGoodsEachWeight());
        goodsPage.setGoodsSumWeight(goods.getGoodsEachWeight()
                * goods.getGoodsNumberEachBox() * goods.getGoodsBoxNumber());
        goodsPage.setBoxLength(goods.getBoxLength());
        goodsPage.setBoxWidth(goods.getBoxWidth());
        goodsPage.setBoxHeight(goods.getBoxHeight());
        goodsPage.setGoodsEachVolume(goods.getBoxLength()
                * goods.getBoxWidth() * goods.getBoxHeight() / 1000000);
        goodsPage.setGoodsSumVolume(goods.getBoxLength()
                * goods.getBoxWidth() * goods.getBoxHeight() / 1000000
                * goods.getGoodsNumberEachBox());
        goodsPage.setGoodsMaterial(goods.getGoodsMaterial());
        goodsPage.setGoodsBarCode(goods.getGoodsBarCode());

        return goodsPage;
    }
}
