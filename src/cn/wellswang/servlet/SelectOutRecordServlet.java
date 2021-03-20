package cn.wellswang.servlet;

import cn.wellswang.entity.OutRecordPage;
import cn.wellswang.service.OutRecordService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectOutRecord")
public class SelectOutRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 获取request携带的参数
        String keyWords = request.getParameter("keyWords");

        // 获取符合条件的出库记录
        // 1. 获取当前用户id
        Integer currentUserId = LoginServlet.staticManId;
        // 2. 查询符合条件的出库记录，并返回
        ArrayList<OutRecordPage> outRecordPages = OutRecordService.selectOutRecordByoutManagerLike(currentUserId, keyWords);
        // 3. 将出库记录返回值前端
        JSONArray json = JSONArray.fromObject(outRecordPages);
        String jsonStr = json.toString();
        //返回数据
        response.getWriter().append(jsonStr);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
