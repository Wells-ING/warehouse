package cn.wellswang.servlet;

import cn.wellswang.entity.Bad;
import cn.wellswang.service.CheckOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckGoods")
public class CheckOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 参数
        Integer orderId = Integer.parseInt(request.getParameter("order_id"));
        Integer badBoxNumber = Integer.parseInt(request.getParameter("bad_boxNumber"));
        String badDecoration = request.getParameter("badDecoration");
        Integer userId = LoginServlet.staticManId;
        // 验货单信息
        Bad newBad = new Bad();
        newBad.setOrderId(orderId);
        newBad.setManId(userId);
        newBad.setBadBoxNumber(badBoxNumber);
        newBad.setBadDecoration(badDecoration);
        if(CheckOrderService.getOrderById(orderId).getOrderStatus() == 0) {
            // 保存验货单
            CheckOrderService.saveBads(newBad);
            // 改变订单参数
            CheckOrderService.modifyOrder(orderId, 2);
            PrintWriter writer = response.getWriter();
            writer.print("<script>alert('新增成功')</script>");
            writer.print("<script>window.location.href='/warehouse/html/purchase/badsManagement.html'</script>");
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("<script>alert('新增失败')</script>");
            writer.print("<script>window.location.href='/warehouse/html/purchase/badsManagement.html'</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
