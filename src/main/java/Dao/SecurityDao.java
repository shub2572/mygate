package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.SecurityBean;
import Util.DbConnection;

public class SecurityDao {

	public void insertsecurity(SecurityBean securityBean) {
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into security (firstname,lastname,contact,password) values (?,?,?,?)");
				
				)
		{
			 
			pstmt.setString(1, securityBean.getFirstName());
			pstmt.setString(2, securityBean.getLastName());
			pstmt.setString(3, securityBean.getContact());
			pstmt.setString(4, securityBean.getPassword());
			int record = pstmt.executeUpdate();
			System.out.println(record + "record inserted");
		}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("SMW in security Dao :: insert security");
	}

	}
}

