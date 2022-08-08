package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MemberBean;
import Dao.MemberDao;

public class NewMemberController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String firstName = request.getParameter("firstName");
			long contact = Long.parseLong(request.getParameter("contact"));
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			int houseId = Integer.parseInt(request.getParameter("houseId"));
			
			MemberBean memberBean = new MemberBean();
			memberBean.setFirstName(firstName);
			memberBean.setContact(contact);
			memberBean.setAge(age);
			memberBean.setGender(gender);
			memberBean.setHouseId(houseId);
			
			MemberDao memberDao = new MemberDao();
			memberDao.insertMember(memberBean);
			
			
		}
		catch(Exception e) {
			request.setAttribute("errorHouseId", "Please Provide the House Number First from Add House Number Section");
		}
		request.setAttribute("memberAdded", "Member Added Successfully");
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

}
