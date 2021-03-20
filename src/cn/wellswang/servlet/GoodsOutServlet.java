package cn.wellswang.servlet;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.entity.Record;
import cn.wellswang.service.GoodsOutService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsOut")
public class GoodsOutServlet extends HttpServlet {
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

        Integer userId = LoginServlet.staticManId;

        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        Integer goodsNumber = g.getGoodsById(goodsSku).getGoodsBoxNumber();

        Integer outGoodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
        String recordTime = request.getParameter("recordTime");

        Record newRecord = new Record();
        newRecord.setManId(userId);
        newRecord.setGoodsSku(goodsSku);
        newRecord.setGoodsNumber(outGoodsNumber);
        newRecord.setRecordType(0);
        newRecord.setRecordTime(recordTime);
        GoodsOutService.saveRecord(newRecord);
        Integer count = GoodsOutService.updateGoodsNumber(goodsSku, goodsNumber - outGoodsNumber);

        JSONObject outInfoMsg = new JSONObject();
        if(count > 0) {
            outInfoMsg.put("isSuccess", true);
            outInfoMsg.put("successMsg", "出库成功");
        } else {
            outInfoMsg.put("isSuccess", false);
            outInfoMsg.put("successMsg", "出库失败");
        }
        response.getWriter().append(outInfoMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
