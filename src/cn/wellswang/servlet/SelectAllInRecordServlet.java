package cn.wellswang.servlet;

import cn.wellswang.entity.RecordPage;
import cn.wellswang.service.SelectAllInRecordService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAllInRecord")
public class SelectAllInRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        // 1. 获取当前用户id
        Integer currentUserId = LoginServlet.staticManId;
        // 2. 查询符合条件的出库记录，并返回
        ArrayList<RecordPage> recordPages = SelectAllInRecordService.selectAllInRecordByManagerLike(currentUserId);
        // 3. 将出库记录返回值前端
        JSONArray json = JSONArray.fromObject(recordPages);
        String jsonStr = json.toString();
        //返回数据
        resp.getWriter().append(jsonStr);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
