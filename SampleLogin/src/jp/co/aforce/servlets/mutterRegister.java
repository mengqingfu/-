package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.MutterRegisterDao;
import tool.Mutter;
import tool.User;


@WebServlet("/mutterRegister")
public class mutterRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コード指定と取得
				request.setCharacterEncoding("UTF-8");
				String data = request.getParameter("data");
				String hour = request.getParameter("hour");
				  // セッションスコープに保存されたユーザー情報を取得
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("loginUser");
				String id = loginUser.getId();
				Mutter mutter = new Mutter(id,data,hour);
				MutterRegisterDao dao = new MutterRegisterDao();
				boolean isOk = false;
				 try {
					 isOk= dao.Register(mutter);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				if (isOk) {
						request.setAttribute("register", "予約成功しました");
				} else {
					request.setAttribute("register", "予約失敗しました");
				}
				
				request.getRequestDispatcher("jsp/loginOk.jsp").forward(request, response);
				
	}

}
