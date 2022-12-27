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




@WebServlet("/UpdateBoardCtrl")
public class UpdateBoardCtrl extends HttpServlet {

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
		
		// 폼 데이터
		request.setCharacterEncoding("utf-8"); // 한글처리
		int num = Integer.parseInt(request.getParameter("seq")); // hidden으로 넘겨준 값
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(num);
		vo.setTitle(title);
		vo.setContent(content);
		
		// DAO 클래스 사용
		BoardDAO bdao = new BoardDAO();
		int cnt = bdao.updateBoard(vo);
		
		if(cnt !=0 ) response.sendRedirect("BoardListCtrl.do");
		
		
		
	}
}
