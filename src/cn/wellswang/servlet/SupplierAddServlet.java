package cn.wellswang.servlet;

import cn.wellswang.entity.Supplier;
import cn.wellswang.service.SupplierAddService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supplierAdd")
public class SupplierAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String supplierName = request.getParameter("supplierName");
        Supplier newSupplier = new Supplier();
        newSupplier.setSupplierName(supplierName);

        Integer count = SupplierAddService.supplierAdd(newSupplier);
        JSONObject supplierAddMsg = new JSONObject();

        if(count > 0) {
            supplierAddMsg.put("isSuccess", true);
            supplierAddMsg.put("successMsg", "新增成功");
        } else {
            supplierAddMsg.put("isSuccess", false);
            supplierAddMsg.put("successMsg", "新增失败");
        }
        response.getWriter().append(supplierAddMsg.toString());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
