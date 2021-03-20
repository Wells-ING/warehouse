package cn.wellswang.servlet;

import cn.wellswang.service.ModifyBadService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyBad")
public class ModifyBadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        Integer badId = Integer.parseInt(req.getParameter("badId"));
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        Integer badBoxNumber = Integer.parseInt(req.getParameter("badBoxNumber"));
        String badDecoration = req.getParameter("badDecoration");
        String managerName = req.getParameter("managerName");

        JSONObject modifyBadMsg = new JSONObject();
        Integer badBoxNumberInFact = ModifyBadService.getBadBoxNumberById(badId);
        // 可以展现订单的箱数做参考
        Integer boxNumberOfOrder = ModifyBadService.getBoxNumberOfOrderByOrderId(orderId);
        Integer managerId = ModifyBadService.isExitOfManagerName(managerName);

        if(badBoxNumber > boxNumberOfOrder) {
            modifyBadMsg.put("isModifySuccess", false);
            modifyBadMsg.put("isTrueBoxNumber", false);
            modifyBadMsg.put("falseBoxNumberMsg", "不合格箱数超过该订单箱数");
        } else if(badBoxNumber < 0) {
            modifyBadMsg.put("isModifySuccess", false);
            modifyBadMsg.put("isTrueBoxNumber", false);
            modifyBadMsg.put("falseBoxNumberMsg", "箱数小于0");
        } else {
            modifyBadMsg.put("isTrueBoxNumber", true);
            if(managerId != null) {
                modifyBadMsg.put("isExitOfManager", true);
                Integer count = ModifyBadService.modifyBadById(badId, badBoxNumber, badDecoration, managerName);
                ModifyBadService.modifyGoodsBoxNumber(orderId, badBoxNumberInFact, badBoxNumber);
                if(count > 0) {
                    modifyBadMsg.put("isModifySuccess", true);
                    modifyBadMsg.put("successMsg", "修改成功");
                } else {
                    modifyBadMsg.put("isModifySuccess", false);
                }
            } else {
                modifyBadMsg.put("falseManagerMsg", "不存在该管理员");
                modifyBadMsg.put("isExitOfManager", false);
            }
        }

        resp.getWriter().append(modifyBadMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
