package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.BoardVO;


@WebServlet("/addBoardCtrl.do")
public class AddBoardCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String logid = (String)session.getAttribute("logid");
		if(logid == null) response.sendRedirect("login.jsp");
		
		// 폼 데이터 받기
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");
		
		// dao 전달해줄 vo 담기
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setNickname(nickname);
		vo.setContent(content);
		
		// dao 글쓰기
		BoardDAO dao = new BoardDAO();
		int cnt = dao.addBoard(vo);
		
		if(cnt != 0) response.sendRedirect("BoardListCtrl.do");
	}

}
