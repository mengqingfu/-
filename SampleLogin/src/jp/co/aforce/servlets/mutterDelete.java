package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MutterDeleteDao;

/**
 * Servlet implementation class mutterDelete
 */
@WebServlet("/mutterDelete")
public class mutterDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		MutterDeleteDao dao = new MutterDeleteDao();
		boolean deleteOk = false;
		try {
			deleteOk = dao.Delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(deleteOk) {
			request.setAttribute("errorMsg", "削除出来ました");
		}else {
			request.setAttribute("errorMsg", "削除出来ません");
		}
		request.getRequestDispatcher("jsp/loginOk.jsp").forward(request, response);
	}

}
