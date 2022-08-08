package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MemberBean;
import Dao.MemberDao;

public class ListMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberBean> members = memberDao.getAllMemberByUserId(userId);
		request.setAttribute("members", members);
		System.out.println(members);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListMember.jsp");
		rd.forward(request, response);
	}

}
