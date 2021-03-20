package cn.wellswang.servlet;

import cn.wellswang.entity.Goods;
import cn.wellswang.service.OrderGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsData")
public class GetGoodsDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String goodsSku = request.getParameter("goodsSku");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        Goods returnGoods = OrderGoodsService.getGoodsByGoodsSku(goodsSku);

        String outInfoMsg="";
        if(returnGoods.getGoodsSku() != null) {
            outInfoMsg="{"
                    + "\"goodsName\" : \"" + returnGoods.getGoodsName() + "\", "
                    + "\"goodsNumberEachBox\" : " + returnGoods.getGoodsNumberEachBox()+ ", "
                    + "\"goodsEachPrice\" : " + returnGoods.getGoodsEachPrice() + ", "
                    + "\"goodsEachWeight\" : " + returnGoods.getGoodsEachWeight() + ", "
                    + "\"boxLength\" : " + returnGoods.getBoxLength() + ", "
                    + "\"boxWidth\" : " + returnGoods.getBoxWidth() + ", "
                    + "\"boxHeight\" : " + returnGoods.getBoxHeight() + ", "
                    + "\"goodsMaterial\" : \"" + returnGoods.getGoodsMaterial() + "\", "
                    + "\"goodsBarCode\" : \"" + returnGoods.getGoodsBarCode() + "\", "
                    + "\"goodsBoxNumber\" : " + returnGoods.getGoodsBoxNumber()
                    + "}";
        } else {
            outInfoMsg = "{}";
        }
        response.getWriter().append(outInfoMsg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
