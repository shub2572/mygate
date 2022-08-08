package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

public class DeleteUserController extends HttpServlet {
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserDao userDao = new UserDao();
		if(userDao.deleteUser(userId)) {	
			request.setAttribute("successMsg", "User Deleted Successfully");
		}
		else {
			request.setAttribute("errorMsg", "Some error Occured in userDao");
		}
		request.getRequestDispatcher("ListUserController").forward(request, response);
		
	}

}
