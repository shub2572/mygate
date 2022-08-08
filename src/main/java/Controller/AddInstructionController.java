package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  Bean.InstructionBean;
import Dao.InstructionDao;
public class AddInstructionController extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String name = request.getParameter("name");
		 String type = request.getParameter("type");
		 String description = request.getParameter("description");
		 String time = request.getParameter("time");
		 
		 HttpSession session = request.getSession();
		 int userId = (int) session.getAttribute("userId");
		 
		 InstructionBean instructionBean =new InstructionBean();
		 InstructionDao instructionDao = new InstructionDao();
		 
		 instructionBean.setName(name);
		 instructionBean.setType(type);
		 instructionBean.setDescription(description);
		 instructionBean.setTime(time);
		 
		 instructionDao.insertInstruction(instructionBean);
		 
		 request.getRequestDispatcher("Home.jsp").forward(request, response);
		
		 
		
	}

}
