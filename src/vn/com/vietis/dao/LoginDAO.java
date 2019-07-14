package vn.com.vietis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vn.com.vietis.pojo.LoginInfo;
import vn.com.vietis.util.DBUtil;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "select * from login_info where USER_NAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userDetails.getUserName());
			ps.setString(2, userDetails.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				validStatus = true;
			}
			DBUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return validStatus;
	}
}
