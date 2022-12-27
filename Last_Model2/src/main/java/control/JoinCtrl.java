package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import vo.UserVO;


@WebServlet("/JoinCtrl.do")
public class JoinCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 폼 파라메터 값 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String name = request.getParameter("name");
		
		UserVO user = new UserVO();
		
		user.setId(id);
		user.setPassword(pw);
		user.setName(name);
		
		
		if(pw.equals(pw2)) {
			
			
			UserDAO dao = new UserDAO();
			dao.insertJoin(user);
			response.sendRedirect("index.jsp");			
			
		} else {			
			
			response.sendRedirect("join.jsp");
		}
		
		

	}

}
