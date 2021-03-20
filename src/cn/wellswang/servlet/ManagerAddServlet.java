package cn.wellswang.servlet;


import cn.wellswang.entity.Manager;
import cn.wellswang.service.ManagerAddService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/managerAdd")
public class ManagerAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String manName = request.getParameter("manName");
        String manPwd = request.getParameter("manPwd");
        Integer manType = Integer.parseInt(request.getParameter("manType"));

        Manager newManager = new Manager();
        newManager.setManType(manType);
        newManager.setManName(manName);
        newManager.setManPassword(manPwd);

        Integer count = ManagerAddService.managerAdd(newManager);
        JSONObject managerAddMsg = new JSONObject();
        if(count > 0) {
            managerAddMsg.put("isSuccess", true);
            managerAddMsg.put("successMsg", "新增成功");
        } else {
            managerAddMsg.put("isSuccess", false);
            managerAddMsg.put("errorMsg", "新增失败");
        }
        response.getWriter().append(managerAddMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
