package Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.HouseBean;
import Dao.HouseDao;

public class HouseDetailController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String houseDetail = request.getParameter("houseDetail");
		HttpSession session = request.getSession();	
		int userId = (int)session.getAttribute("userId");System.out.println("userId  :  "+userId);
		
		HouseDao houseDao = new HouseDao();
		HouseBean houseBean = new HouseBean();
		
		houseBean.setHouseDetails(houseDetail);
		houseBean.setUserId(userId);
		
		houseDao.insertHouseData(houseBean);
		
		request.setAttribute("successMsg", "House Added Successfully");
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

}