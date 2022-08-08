package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

public class ApproveUserController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userid"));
		UserDao userDao = new UserDao();
		if(userDao.approveUser(userId)) {	
			request.setAttribute("successDoneMsg", "Users Status Updated");
			request.getRequestDispatcher("PendingRequestController").forward(request, response);

		}
		else {
			request.setAttribute("errorDoneMsg", "Some error occured Try again later");
		}
		request.getRequestDispatcher("PendingRequestController").forward(request, response); 
	}
}