package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.SecurityBean;
import Dao.SecurityDao;
public class AddSecurityController extends HttpServlet {
	  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String contact = request.getParameter("contact");
			String password = request.getParameter("password");

		
			
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			
			SecurityBean securityBean = new SecurityBean();
			SecurityDao securityDao = new SecurityDao();
			
			securityBean.setFirstName(firstName);
			securityBean.setLastName(lastName);
			securityBean.setContact(contact);
			securityBean.setPassword(password);
			
			securityDao.insertsecurity(securityBean);
			
			request.getRequestDispatcher("AdminPanel.jsp").forward(request, response);
		}

	}
