package likey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class LikeyDAO {
	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public int like(String userID, String evaluationID, String userIP) {
		String SQL = "INSERT INTO likey VALUES(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, evaluationID);
			pstmt.setString(3, userIP);
			return pstmt.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			try {if(conn!= null)conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt != null)pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs != null)rs.close();}catch(Exception e) {e.printStackTrace();}
			}
		return -1;
	}
}
