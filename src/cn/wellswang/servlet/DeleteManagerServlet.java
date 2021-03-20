package cn.wellswang.servlet;

import cn.wellswang.service.DeleteManagerService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteManager")
public class DeleteManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer managerId = Integer.parseInt(req.getParameter("managerId"));

        Integer count = DeleteManagerService.deleteManagerById(managerId);

        JSONObject deleteManagerMsg = new JSONObject();
        if(count > 0) {
            deleteManagerMsg.put("isSuccess", true);
            deleteManagerMsg.put("successMsg", "删除成功");
        } else {
            deleteManagerMsg.put("isSuccess", false);
            deleteManagerMsg.put("errorMsg", "删除失败");
        }
        resp.getWriter().append(deleteManagerMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
