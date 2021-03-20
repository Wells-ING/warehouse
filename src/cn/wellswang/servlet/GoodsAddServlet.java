package cn.wellswang.servlet;

import cn.wellswang.entity.Goods;
import cn.wellswang.service.GoodsAddService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsAdd")
public class GoodsAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String goodsSku = request.getParameter("goodsSku");
        String goodsName = request.getParameter("goodsName");
        Integer goodsNumberEachBox = Integer.parseInt(request.getParameter("goodsNumberEachBox"));
        Integer goodsBoxNumber = 0;
        Double goodsEachPrice = Double.parseDouble(request.getParameter("goodsEachPrice"));
        Double boxLength = Double.parseDouble(request.getParameter("boxLength"));
        Double box_width = Double.parseDouble(request.getParameter("boxWidth"));
        Double box_height = Double.parseDouble(request.getParameter("boxHeight"));
        Double goodsEachWeight = Double.parseDouble(request.getParameter("goodsEachWeight"));
        String goodsMaterial = request.getParameter("goodsMaterial");
        String goodsBarCode = request.getParameter("goodsBarCode");

        Goods newGoods = new Goods();
        newGoods.setGoodsSku(goodsSku);
        newGoods.setGoodsName(goodsName);
        newGoods.setGoodsNumberEachBox(goodsNumberEachBox);
        newGoods.setGoodsBoxNumber(goodsBoxNumber);
        newGoods.setGoodsEachPrice(goodsEachPrice);
        newGoods.setBoxWidth(box_width);
        newGoods.setBoxLength(boxLength);
        newGoods.setBoxHeight(box_height);
        newGoods.setGoodsEachWeight(goodsEachWeight);
        newGoods.setGoodsBarCode(goodsBarCode);
        newGoods.setGoodsMaterial(goodsMaterial);

        JSONObject goodsAddMsg = new JSONObject();

        Integer count = GoodsAddService.GoodsAdd(newGoods);
        if(count > 0) {
            goodsAddMsg.put("isSuccess", true);
            goodsAddMsg.put("successMsg", "新增成功");
        } else {
            goodsAddMsg.put("isSuccess", false);
            goodsAddMsg.put("errorMsg", "新增失败");
        }
        response.getWriter().append(goodsAddMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
