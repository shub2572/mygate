package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.UserBean;
import Util.DbConnection;

public class UserDao {

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				System.out.println("rs.getString(role)"+rs.getString("role"));
			}
		} catch (Exception e) {
			System.out.println("SMW in Login :: DAO");
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	public void insertUser(UserBean userBean) {
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into users (firstname, lastname, email, password, gender,contact,role,status) values(?,?,?,?,?,?,'user','pending') ")){
			
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getContact());
		
			int records = pstmt.executeUpdate();
			System.out.println("inserUser() :: records  -:" + records);
			
		}catch(Exception e) {
			System.out.println("SMW in UserDao ::inserUser()");
			e.printStackTrace();
		}
	}



	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();// select readonly ==>query

			while (rs.next() == true) { // 1st row 2nd row
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String status = rs.getString("status");

				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setStatus(status);
				users.add(user);
				
				
			}
			// go to line num -> 63

			// user1
			// user2

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}

		return users;
	}



	public ArrayList<UserBean> getAllPendingReq() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();// select readonly ==>query

			while (rs.next() == true) { // 1st row 2nd row
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String status = rs.getString("status");

				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setStatus(status);
				users.add(user);
				
				
			}
			// go to line num -> 63

			// user1
			// user2

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}
		return users;
	}



	public boolean approveUser(int userId) {
		
		
		boolean flag=false;
		try(
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set status='Approved' where userid = ?");){
			pstmt.setInt(1, userId);
			int approved = pstmt.executeUpdate();
			System.out.println("Status Approved");
			if(approved==1){
				flag = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean declineUser(int userId) {
		boolean flag=false;
		try(
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set status='Declined' where userid = ?");){
			pstmt.setInt(1, userId);
			int approved = pstmt.executeUpdate();
			System.out.println("Status Approved");
			if(approved==1){
				flag = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}



	public boolean deleteUser(int userId) {
		boolean flag=false;
		try(
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from house where userid = ?");
			PreparedStatement pstmt2 = con.prepareStatement("delete from users where userid = ?");){
			
			pstmt.setInt(1, userId);
			pstmt2.setInt(1, userId);
			int deleteRow = pstmt.executeUpdate();
			int deleteRows = pstmt2.executeUpdate();
			if(deleteRow==1 && deleteRows==1){
				flag = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}



	public UserBean getUserByUserId(int userId) {
		UserBean user = null;
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where userid = ?");
				)
		{
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setGender(rs.getString("gender"));
				user.setPassword(rs.getString("password"));
				user.setContact(rs.getString("contact"));
				user.setUserId(rs.getInt("userid"));
			}
		}
		catch(Exception e){
			e.printStackTrace();			
		}		return null;
	}
	
}
