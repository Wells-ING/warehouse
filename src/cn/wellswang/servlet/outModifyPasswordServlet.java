package cn.wellswang.servlet;

import cn.wellswang.service.purchaseModifyPasswordService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/outModifyPassword")
public class outModifyPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");


        Integer managerId = LoginServlet.staticManId;

        JSONObject outModifyPasswordMsg = new JSONObject();

        Boolean nullFlag = false;
        Boolean passwordIsRightFlag = false;
        if("".equals(oldPassword) || "".equals(newPassword) || "".equals(confirmPassword)
                || !newPassword.equals(confirmPassword)) {
            outModifyPasswordMsg.put("successMsg", false);
            outModifyPasswordMsg.put("errorMsg", "修改失败，新密码、确认密码不可为空或新密码和确认密码不一致");
            nullFlag = true;
        }

        if(!purchaseModifyPasswordService.isTruePassword(managerId, oldPassword)) {
            outModifyPasswordMsg.put("successMsg", false);
            outModifyPasswordMsg.put("errorMsg", "修改失败，原密码错误");
            passwordIsRightFlag = true;

        }
        if(!nullFlag && !passwordIsRightFlag) {
            Boolean flag = purchaseModifyPasswordService.purchaseModifyPassword(managerId, newPassword);
            if(flag) {
                outModifyPasswordMsg.put("successMsg", true);
                outModifyPasswordMsg.put("errorMsg", "修改成功");
            } else {
                outModifyPasswordMsg.put("successMsg", true);
                outModifyPasswordMsg.put("errorMsg", "修改失败");
            }
        }
        response.getWriter().append(outModifyPasswordMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
