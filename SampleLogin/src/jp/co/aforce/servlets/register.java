package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.RegisterDao;
import tool.User;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの文字コード指定と取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
	
		if (!id.equals("") && !pass.equals("")) {
			// Userインスタンス（ユーザー情報）の生成
			User user = new User(id, pass);
			RegisterDao dao = new RegisterDao();
			boolean registerOk = false;
			try {
				registerOk = dao.register(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (registerOk) {
				request.setAttribute("register", "Register成功しました");
			} else {
				request.setAttribute("register", "IDすでに存在している");
			}
		} else {
			request.setAttribute("register", "IDまたPASSを入力してください");
		}
		request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
	}

}
