package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.BoardVO;




@WebServlet("/BoardListCtrl.do")
public class BoardListCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetpost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetpost(request, response);
	}
	
	protected void doGetpost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String logid = (String)session.getAttribute("logid");
		if(logid == null) response.sendRedirect("login.jsp");
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList = dao.getBoardList();
		
		// 바인딩
		request.setAttribute("boardList", boardList);
		// 포워딩
		RequestDispatcher dis = request.getRequestDispatcher("BoardList.jsp");
		dis.forward(request, response);
	}

}
