package cn.wellswang.servlet;

import cn.wellswang.entity.Goods;
import cn.wellswang.service.ModifyGoodsService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyGoods")
public class ModifyGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        String goodsSku = req.getParameter("goodsSku");
        String goodsName = req.getParameter("goodsName");
        Integer goodsNumberEachBox = Integer.parseInt(req.getParameter("goodsNumberEachBox"));
        Double goodsEachPrice = Double.parseDouble(req.getParameter("goodsEachPrice"));
        Double boxLength = Double.parseDouble(req.getParameter("boxLength"));
        Double box_width = Double.parseDouble(req.getParameter("boxWidth"));
        Double box_height = Double.parseDouble(req.getParameter("boxHeight"));
        Double goodsEachWeight = Double.parseDouble(req.getParameter("goodsEachWeight"));
        String goodsMaterial = req.getParameter("goodsMaterial");
        String goodsBarCode = req.getParameter("goodsBarCode");

        Goods newGoods = new Goods();
        newGoods.setGoodsSku(goodsSku);
        newGoods.setGoodsName(goodsName);
        newGoods.setGoodsNumberEachBox(goodsNumberEachBox);
        newGoods.setGoodsEachPrice(goodsEachPrice);
        newGoods.setGoodsBoxNumber(0);
        newGoods.setBoxWidth(box_width);
        newGoods.setBoxLength(boxLength);
        newGoods.setBoxHeight(box_height);
        newGoods.setGoodsEachWeight(goodsEachWeight);
        newGoods.setGoodsBarCode(goodsBarCode);
        newGoods.setGoodsMaterial(goodsMaterial);

        JSONObject modifyGoodsMsg = new JSONObject();

        Integer count = ModifyGoodsService.modifyGoods(newGoods);
        if(count > 0) {
            modifyGoodsMsg.put("isModifySuccess" , true);
            modifyGoodsMsg.put("successMsg", "修改成功");
        } else {
            modifyGoodsMsg.put("isModifySuccess", false);
            modifyGoodsMsg.put("errorMsg", "修改失败");
        }
        resp.getWriter().append(modifyGoodsMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
