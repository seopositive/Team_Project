package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;


@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 처리
		HttpSession session = request.getSession();
		String logid = (String)session.getAttribute("logid");
		if(logid == null) response.sendRedirect("login.jsp");
		
		// 데이터 처리
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.deleteBoard(num);
		
		if(cnt != 0) response.sendRedirect("BoardListCtrl.do");
	}

}
