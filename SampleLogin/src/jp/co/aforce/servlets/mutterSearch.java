package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MutterSearchDao;
import tool.Mutter;


@WebServlet("/mutterSearch")
public class mutterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");
		MutterSearchDao dao = new MutterSearchDao();
		List<Mutter> mutterList = new ArrayList<>();
		try {
			mutterList = dao.Search(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("mutterList", mutterList);
		request.getRequestDispatcher("jsp/loginOk.jsp").forward(request, response);
	}

}
