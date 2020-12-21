package cn.wellswang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Integer man_type = Integer.parseInt(request.getParameter("man_type"));
		Integer man_id = Integer.parseInt(request.getParameter("man_id"));
		String man_pwd = request.getParameter("man_pwd");
		ManagerInfoDAOImpl m = new ManagerInfoDAOImpl();
		PrintWriter out = response.getWriter();
		boolean flag = m.login(man_type, man_id, man_pwd);
		String url = "http://localhost:8080/warehouse/";
		if(flag) {
			out.print("<script type='text/javascript'>alert('登陆成功!')</script>");
			
			if(man_type == 1) {
//				request.getRequestDispatcher("/homepage_root.html").forward(request, response);
				url += "homepage_root.html";
			} else if(man_type == 2) {
//				request.getRequestDispatcher("/homepage_purchase.html").forward(request, response);
				url += "homepage_purchase.html";
			} else if(man_type == 3) {
//				request.getRequestDispatcher("/homepage_out.html").forward(request, response);
				url += "homepage_out.html";
			}
			out.print("<script type='text/javascript'>location.href='" + url + "'</script>");
			out.flush();
			out.close();
		} else {
			out.print("<script type='text/javascript'>alert('登陆失败，请重新登陆!')</script>");
			out.print("<script type='text/javascript'>location.href='http://localhost:8080/warehouse/login.html'</script>");
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
