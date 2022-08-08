package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.MemberBean;
import Dao.MemberDao;
public class AddMemberController extends HttpServlet {
	  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String firstName = request.getParameter("firstName");
			Long contact = Long.parseLong(request.getParameter("contact"));
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			
			MemberBean memberBean = new MemberBean();
			MemberDao memberDao = new MemberDao();
			
			memberBean.setFirstName(firstName);
			memberBean.setContact(contact);
			memberBean.setAge(age);
			memberBean.setGender(gender);
			
			memberDao.insertMember(memberBean);
			
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}

	}
