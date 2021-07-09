package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.LoginDao;
import tool.User;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの文字コード指定と取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// Userインスタンス（ユーザー情報）の生成
		User user = new User(id, pass);
		LoginDao dao = new LoginDao();
		User isLogin = null;
		try {
			isLogin = dao.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (isLogin != null) {
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", isLogin);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/loginOk.jsp");
			dispatcher.forward(request, response);
		} else {

			request.setAttribute("loginUser", "IDもしくはパスワードが違います");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}

	}

}
