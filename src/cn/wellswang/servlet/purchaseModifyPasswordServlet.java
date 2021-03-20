package cn.wellswang.servlet;

import cn.wellswang.service.purchaseModifyPasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/purchaseModifyPassword")
public class purchaseModifyPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        // 获取request参数
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        // 检验密码的合法性
        if("".equals(oldPassword) || "".equals(newPassword) || "".equals(confirmPassword)
            || !newPassword.equals(confirmPassword)) {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('密码修改失败，原密码、新密码、确认密码可能为空或新密码和确认密码不一致')</script>");
            writer.print("<script>window.location.href='/warehouse/html/purchase/infoManagement.html'</script>");
            return;
        }

        // 获取需要修改密码的用户id
        Integer currentManager = LoginServlet.staticManId;
        // 检验原密码的正确性
        if(!purchaseModifyPasswordService.isTruePassword(currentManager, oldPassword)) {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('密码修改失败，原密码错误')</script>");
            writer.print("<script>window.location.href='/warehouse/html/purchase/infoManagement.html'</script>");
            return;
        }
        // 修改密码
        purchaseModifyPasswordService.purchaseModifyPassword(currentManager, newPassword);
        // 跳转界面
        PrintWriter writer = resp.getWriter();
        writer.print("<script>alert('密码修改成功')</script>");
        writer.print("<script>window.location.href='/warehouse/html/purchase/infoManagement.html'</script>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
