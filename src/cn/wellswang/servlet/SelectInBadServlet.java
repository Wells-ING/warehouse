package cn.wellswang.servlet;

import cn.wellswang.entity.BadPage;
import cn.wellswang.service.SelectInBadService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectInBad")
public class SelectInBadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String keyWords = request.getParameter("keyWords");
        Integer currentManagerId = LoginServlet.staticManId;
        ArrayList<BadPage> badPages = SelectInBadService.getBadPageResultByLikeAndCurrentManagerId(currentManagerId, keyWords);
        JSONArray json = JSONArray.fromObject(badPages);
        String jsonStr = json.toString();
        //返回数据
        response.getWriter().append(jsonStr);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
