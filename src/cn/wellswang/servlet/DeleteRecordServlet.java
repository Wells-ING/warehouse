package cn.wellswang.servlet;

import cn.wellswang.service.DeleteRecordService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteRecord")
public class DeleteRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer recordId = Integer.parseInt(req.getParameter("recordId"));

        Integer count = DeleteRecordService.deleteReocrdByRecordId(recordId);

        JSONObject deleteRecordMsg = new JSONObject();
        if(count > 0) {
            deleteRecordMsg.put("isSuccess", true);
            deleteRecordMsg.put("successMsg", "删除成功");
        } else {
            deleteRecordMsg.put("isSuccess", false);
            deleteRecordMsg.put("errorMsg", "删除失败");
        }
        resp.getWriter().append(deleteRecordMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
