package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserBean;
import Dao.UserDao;

public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		request.setAttribute("email", email);
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email, password);

		RequestDispatcher rd = null;

		if (user == null) {
			request.setAttribute("errorMsg", "Invalid Credentials");
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getFirstName());

			request.setAttribute("successLogin", "Login Successfully");
			System.out.println(user.getStatus());
			if (user.getStatus().equals("pending")) {

				rd = request.getRequestDispatcher("Login.jsp");

			}System.out.println(user.getRole());
			if (user.getRole().equals("admin")) {

				rd = request.getRequestDispatcher("Admin.jsp");

			} else {

		rd = request.getRequestDispatcher("Home.jsp");
				
			}
		}

		rd.forward(request, response);
	}

}