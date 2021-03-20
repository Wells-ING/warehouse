package cn.wellswang.servlet;

import cn.wellswang.service.DeleteBadService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBad")
public class DeleteBadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer badId = Integer.parseInt(req.getParameter("badId"));

        Integer count = DeleteBadService.deleteBadByBadId(badId);

        JSONObject deleteOrdermsg = new JSONObject();
        if(count > 0) {
            deleteOrdermsg.put("isSuccess", true);
            deleteOrdermsg.put("successMsg", "删除成功");
        } else {
            deleteOrdermsg.put("isSuccess", false);
            deleteOrdermsg.put("errorMsg", "删除失败");
        }
        resp.getWriter().append(deleteOrdermsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
