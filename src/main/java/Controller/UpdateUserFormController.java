package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import Dao.UserDao;

public class UpdateUserFormController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		UserDao userDao = new UserDao();
		UserBean user = userDao.getUserByUserId(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
	}
}

