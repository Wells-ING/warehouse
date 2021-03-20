package cn.wellswang.servlet;

import cn.wellswang.service.DeleteGoodsService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGoods")
public class DeleteGoodsServlet extends HttpServlet {
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

        Integer goodsBoxNumber = DeleteGoodsService.getGoodsBoxNumberByGoodsSku(goodsSku);
        JSONObject deleteGoodsmsg = new JSONObject();
        if(goodsBoxNumber > 0) {
            deleteGoodsmsg.put("isSuccess", false);
            deleteGoodsmsg.put("errorMsg", "删除失败，该商品库存中仍有货品");
        } else {
            Integer count = DeleteGoodsService.deleteGoodsByGoodsSku(goodsSku);
            if (count > 0) {
                deleteGoodsmsg.put("isSuccess", true);
                deleteGoodsmsg.put("successMsg", "删除成功");
            }
        }
        resp.getWriter().append(deleteGoodsmsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
