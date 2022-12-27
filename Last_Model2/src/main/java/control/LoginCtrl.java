package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import vo.UserVO;


@WebServlet("/loginCtrl")
public class LoginCtrl extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = new UserDAO();
		
		UserVO user = dao.getUser(id, pw);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("logid", user.getId());
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
