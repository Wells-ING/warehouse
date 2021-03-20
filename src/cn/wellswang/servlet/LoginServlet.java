package cn.wellswang.servlet;

import cn.wellswang.service.LoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static JSONArray loginManagerMsg = new JSONArray();
	public static int staticManId = 0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		Integer manType = Integer.parseInt(request.getParameter("manType"));
		Integer manId = Integer.parseInt(request.getParameter("manId"));

		String manPwd = request.getParameter("manPwd");

		JSONObject loginMsg = new JSONObject();
		JSONObject currentMangerMsg = new JSONObject();
		String url = "";
		Boolean flagOfisLogin = false;

		JSONArray loginManagerMsg = LoginServlet.loginManagerMsg;
		for(int i = 0; i < loginManagerMsg.size(); i++) {
			JSONObject eachLoginManagerMsg = loginManagerMsg.getJSONObject(i);
			if(manId == eachLoginManagerMsg.get("manId")) {
				if(Boolean.parseBoolean(eachLoginManagerMsg.get("isLogin").toString())) {
					flagOfisLogin = true;
				}
			}
		}
		if(!flagOfisLogin) {
			boolean flag = LoginService.login(manType, manId, manPwd);
			if(flag) {
				loginMsg.put("isLogin", true);
				if(manType == 1) {
					url = "./root";
//					request.getSession().setAttribute("rootManagerId", manId);
				} else if(manType == 2) {
					url = "./purchase";
//					request.getSession().setAttribute("purchaseManagerId", manId);
				} else if(manType == 3) {
					url = "./out";
//					request.getSession().setAttribute("outManagerId", manId);
				}
				url += "/homepage.html";
				staticManId = manId;
				loginMsg.put("successMsg", "登陆成功");

				currentMangerMsg.put("manType", manType);
				currentMangerMsg.put("manId", manId);
				currentMangerMsg.put("isLogin", true);

				LoginServlet.loginManagerMsg.add(currentMangerMsg);

//				request.getSession().setAttribute("loginManagerMsg", LoginServlet.loginManagerMsg);
			} else {
				loginMsg.put("isLogin", false);
				url = "./login.html";
				loginMsg.put("errorMsg", "登陆失败，请检查用户类型、用户ID或密码是否存在错误");
			}
			loginMsg.put("nextPage", url);
		} else {
			loginMsg.put("isLogin", false);
			loginMsg.put("errorMsg", "登陆失败，该用户已在别处登录");
			url = "./login.html";
			loginMsg.put("nextPage", url);
		}
		response.getWriter().append(loginMsg.toString());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
