package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.MemberBean;
import Util.DbConnection;

public class MemberDao {

	public ArrayList<MemberBean> getAllMemberByUserId(int userId) {
		ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		MemberBean member = null;
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from house inner join member on house.houseid=member.houseid where userid=?");
				)
		{
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getInt("memberid"));
				member.setFirstName(rs.getString("firstname"));
				member.setGender(rs.getString("gender"));
				member.setContact(rs.getLong("contact"));
				member.setAge(rs.getInt("age"));
				member.setHouseId(rs.getInt("houseid"));
				members.add(member);
			}
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		
		return null;
	}

	public void insertMember(MemberBean memberBean) {
		

		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into member (firstname,contact,age,gender,houseid) values (?,?,?,?,?)");
				
				) {
			pstmt.setString(1, memberBean.getFirstName());
			pstmt.setLong(2, (long) memberBean.getContact());
			pstmt.setInt(3, memberBean.getAge());
			pstmt.setString(4, memberBean.getGender());
			pstmt.setInt(5, memberBean.getHouseId());
			
			int record = pstmt.executeUpdate();
			System.out.println(record + " Record inserted");
		}catch(Exception e){
			System.out.println("SMW in UserDao::insertMember()");
			e.printStackTrace();
		}
	}
}


