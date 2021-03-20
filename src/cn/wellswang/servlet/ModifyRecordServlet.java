package cn.wellswang.servlet;

import cn.wellswang.service.ModifyRecordService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyRecord")
public class ModifyRecordServlet extends HttpServlet {
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
        Integer goodsNumber = Integer.parseInt(req.getParameter("goodsNumber"));
        String recordTime = req.getParameter("recordTime");
        String manName = req.getParameter("manName");
        String goodsSku = req.getParameter("goodsSku");
        Integer recordType = Integer.parseInt(req.getParameter("recordType"));

        JSONObject modifyRecordMsg = new JSONObject();
        Integer recordBoxNumberInFact = ModifyRecordService.getRecordBoxNumberByRecordId(recordId);
        Integer managerId = ModifyRecordService.isExitOfManagerName(manName);
        if(recordType == 1) {
            Integer boxNumberOfOrder = ModifyRecordService.getBoxNumberOfOrderByRecordId(recordId);
            if(goodsNumber > boxNumberOfOrder) {
                modifyRecordMsg.put("isModifySuccess", false);
                modifyRecordMsg.put("isTrueBoxNumber", false);
                modifyRecordMsg.put("falseBoxNumberMsg", "入库箱数超过该订单箱数");
            } else if(goodsNumber < 0) {
                modifyRecordMsg.put("isModifySuccess", false);
                modifyRecordMsg.put("isTrueBoxNumber", false);
                modifyRecordMsg.put("falseBoxNumberMsg", "箱数小于0");
            } else {
                modifyRecordMsg.put("isTrueBoxNumber", true);
                if(managerId != null) {
                    modifyRecordMsg.put("isExitOfManager", true);
                    Integer count = ModifyRecordService.modifyRecordById(recordId, goodsNumber, recordTime, manName);
                    ModifyRecordService.modifyGoodsBoxNumber(recordId, recordBoxNumberInFact, goodsNumber);
                    if(count > 0) {
                        modifyRecordMsg.put("isModifySuccess", true);
                        modifyRecordMsg.put("successMsg", "修改成功");
                    } else {
                        modifyRecordMsg.put("isModifySuccess", false);
                    }
                } else {
                    modifyRecordMsg.put("falseManagerMsg", "不存在该管理员");
                    modifyRecordMsg.put("isExitOfManager", false);
                }
            }
        } else if(recordType == 0){
            Integer boxNumberOfGoods = ModifyRecordService.getBoxNumberOfGoodsByGoodsSku(goodsSku);
            if(goodsNumber > boxNumberOfGoods) {
                modifyRecordMsg.put("isModifySuccess", false);
                modifyRecordMsg.put("isTrueBoxNumber", false);
                modifyRecordMsg.put("falseBoxNumberMsg", "出库箱数超过该商品库存箱数");
            } else if(goodsNumber < 0) {
                modifyRecordMsg.put("isModifySuccess", false);
                modifyRecordMsg.put("isTrueBoxNumber", false);
                modifyRecordMsg.put("falseBoxNumberMsg", "箱数小于0");
            } else {
                modifyRecordMsg.put("isTrueBoxNumber", true);
                if(managerId != null) {
                    modifyRecordMsg.put("isExitOfManager", true);
                    Integer count = ModifyRecordService.modifyRecordById(recordId, goodsNumber, recordTime, manName);
                    ModifyRecordService.modifyGoodsBoxNumber(recordId, goodsNumber, recordBoxNumberInFact);
                    if(count > 0) {
                        modifyRecordMsg.put("isModifySuccess", true);
                        modifyRecordMsg.put("successMsg", "修改成功");
                    } else {
                        modifyRecordMsg.put("isModifySuccess", false);
                    }
                } else {
                    modifyRecordMsg.put("falseManagerMsg", "不存在该管理员");
                    modifyRecordMsg.put("isExitOfManager", false);
                }
            }
        }
        resp.getWriter().append(modifyRecordMsg.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
