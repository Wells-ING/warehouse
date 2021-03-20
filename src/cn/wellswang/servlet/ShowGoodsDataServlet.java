package cn.wellswang.servlet;

import cn.wellswang.entity.GoodsPage;
import cn.wellswang.service.ShowGoodsDataService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showGoodsData")
public class ShowGoodsDataServlet extends HttpServlet {
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

        GoodsPage goodsPages = ShowGoodsDataService.getGoodsPagesByGoodsSku(goodsSku);

        JSONObject goodsPagesJson = JSONObject.fromObject(goodsPages);
        resp.getWriter().append(goodsPagesJson.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
