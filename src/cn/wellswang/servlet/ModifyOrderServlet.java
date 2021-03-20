package cn.wellswang.servlet;

import cn.wellswang.service.ModifyOrderService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyOrder")
public class ModifyOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        Double orderFreight = Double.parseDouble(req.getParameter("orderFreight"));
        Double orderDeposit = Double.parseDouble(req.getParameter("orderDeposit"));
        String supplierName = req.getParameter("supplierName");
        String orderTime = req.getParameter("orderTime");

        JSONObject modifyOrderMsg = new JSONObject();

        Integer supplierId = ModifyOrderService.isExitOfSupplierName(supplierName);
        if(supplierId != null) {
            Integer count = ModifyOrderService.modifyOrderById(orderId, orderFreight, orderDeposit, orderTime, supplierId);
            if(count > 0) {
                modifyOrderMsg.put("isModifySuccess", true);
                modifyOrderMsg.put("successMsg", "修改成功");
            } else {
                modifyOrderMsg.put("isModifySuccess", false);
                modifyOrderMsg.put("successMsg", "修改失败");
            }
        } else {
            modifyOrderMsg.put("falseManagerMsg", "不存在该供应商");
            modifyOrderMsg.put("isExitOfManager", false);
        }
        resp.getWriter().append(modifyOrderMsg.toString());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
