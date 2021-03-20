package cn.wellswang.servlet;

import cn.wellswang.service.DeleteOrderService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
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

        Integer orderStatus = DeleteOrderService.getOrderStatusById(orderId);
        JSONObject deleteOrderMsg = new JSONObject();
        if(orderStatus == 0) {
            Integer count = DeleteOrderService.deleteOrderById(orderId);
            if(count > 0) {
                deleteOrderMsg.put("isSuccess", true);
                deleteOrderMsg.put("successMsg", "删除成功");
            } else {
                deleteOrderMsg.put("isSuccess", false);
                deleteOrderMsg.put("errorMsg", "删除失败");
            }
        } else {
            deleteOrderMsg.put("isSuccess", false);
            deleteOrderMsg.put("errorMsg", "删除失败, 该订单已经验货或入库");
        }

        resp.getWriter().append(deleteOrderMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
