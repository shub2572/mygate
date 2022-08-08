package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.InstructionBean;
import Util.DbConnection;

public class InstructionDao {

	public void insertInstruction(InstructionBean instructionBean) {
		
		try (
		Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into instruction (name,type,description,time) values (?,?,?,?)");
				
				){
			       pstmt.setString(1, instructionBean.getName());
			       pstmt.setString(2, instructionBean.getType());
			       pstmt.setString(3, instructionBean.getDescription());
			       pstmt.setString(4, instructionBean.getTime());
			       
			       int record = pstmt.executeUpdate();
			       System.out.println(record + "record inserted");
			       

			
		}catch(Exception e) {
			System.out.println("SMW in Dao :: insertInstruction");
			e.printStackTrace();
		}
		
	}

}
