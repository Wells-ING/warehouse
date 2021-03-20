package cn.wellswang.servlet;

import cn.wellswang.service.ModifySupplierService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifySupplier")
public class ModifySupplierServlet extends HttpServlet {
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
        String supplierName = req.getParameter("supplierName");

        JSONObject modifySupplierMsg = new JSONObject();
        Integer count = ModifySupplierService.modifySupplier(supplierId, supplierName);
        if(count > 0) {
            modifySupplierMsg.put("isModifySuccess", true);
            modifySupplierMsg.put("successMsg", "修改成功");
        } else {
            modifySupplierMsg.put("isModifySuccess", false);
            modifySupplierMsg.put("errorMsg", "修改失败");
        }

        resp.getWriter().append(modifySupplierMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
