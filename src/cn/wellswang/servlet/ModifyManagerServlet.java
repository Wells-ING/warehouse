package cn.wellswang.servlet;

import cn.wellswang.service.ModifyManagerService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/modifyManager")
public class ModifyManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer manId = Integer.parseInt(req.getParameter("manId"));
        String manName = req.getParameter("manName");
        String manPassword = req.getParameter("manPassword");
        Integer manType = Integer.parseInt(req.getParameter("manType"));

        JSONObject modifyManagerMsg = new JSONObject();
        Integer count = ModifyManagerService.modifyManager(manId, manName, manPassword, manType);
        if(count > 0) {
            modifyManagerMsg.put("isModifySuccess", true);
            modifyManagerMsg.put("successMsg", "修改成功");
        } else {
            modifyManagerMsg.put("isModifySuccess", false);
            modifyManagerMsg.put("errorMsg", "修改失败");
        }

        resp.getWriter().append(modifyManagerMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
