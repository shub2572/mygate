package Dao;



	import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.HouseBean;
	import Util.DbConnection;

	public class HouseDao {

		public void insertHouseData(HouseBean houseBean) {
			
			try(
					Connection con = DbConnection.getConnection();
					PreparedStatement pstmt = con.prepareStatement("insert into house (housedetail,userid) values(?,?)");){
				
				pstmt.setString(1, houseBean.getHouseDetails());
				pstmt.setInt(2, houseBean.getUserId());
				
				int record = pstmt.executeUpdate();
				System.out.println(record + " House Record inserted");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("SMW in HouseDao::insertHouseData()");
			}
		}

		
	}

