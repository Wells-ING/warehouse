package cn.wellswang.servlet;

import cn.wellswang.service.DeleteSupplierService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSupplier")
public class DeleteSupplierServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer supplierId = Integer.parseInt(req.getParameter("supplierId"));

        Integer count = DeleteSupplierService.deleteSupplierById(supplierId);

        JSONObject deleteSuppliermsg = new JSONObject();
        if(count > 0) {
            deleteSuppliermsg.put("isSuccess", true);
            deleteSuppliermsg.put("successMsg", "删除成功");
        } else {
            deleteSuppliermsg.put("isSuccess", false);
            deleteSuppliermsg.put("errorMsg", "删除失败");
        }
        resp.getWriter().append(deleteSuppliermsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
