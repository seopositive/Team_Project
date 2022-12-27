package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;


@WebServlet("/OneBoardCtrl.do")
public class OneBoardCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.OneBoradGet(num);
		
		if(vo != null) {
			request.setAttribute("board", vo);
			RequestDispatcher dis = request.getRequestDispatcher("getBoard.jsp");
			dis.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
		
		
		
	
		
		
	}

}
