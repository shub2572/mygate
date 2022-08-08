package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import Dao.UserDao;

public class PendingRequestController extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		ArrayList<UserBean> users = userDao.getAllPendingReq();
		request.setAttribute("users", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("PendingRequest.jsp");
		rd.forward(request, response);
	}

}