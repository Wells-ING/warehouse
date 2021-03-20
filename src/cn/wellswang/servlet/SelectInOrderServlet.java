package cn.wellswang.servlet;

import cn.wellswang.entity.OrderPage;
import cn.wellswang.service.SelectInOrderService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectInOrder")
public class SelectInOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String keyWords = request.getParameter("keyWords");
        Integer currentManagerId = LoginServlet.staticManId;

        ArrayList<OrderPage> orderPages = SelectInOrderService.getOrdersByLikeAndCurrentManagerId(currentManagerId, keyWords);

        JSONArray orderPageInfo = JSONArray.fromObject(orderPages);
        response.getWriter().append(orderPageInfo.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
