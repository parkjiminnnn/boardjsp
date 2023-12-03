package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class chatDAO {
	private Connection conn;
	private ResultSet rs;
	
	
	public chatDAO() {	
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	
	public int getNext() {
		String SQL = "SELECT chatroomID FROM chatroom ORDER BY chatroomID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1; //泥� 踰덉㎏ 寃뚯떆臾쇱씤 寃쎌슦
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//�뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
	public int write(String chattitle, String userID) {
	    String SQL = "INSERT INTO chatroom (chattitle, userID) VALUES (?,?)";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, chattitle);
	        pstmt.setString(2, userID);
	        
	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    return generatedKeys.getInt(1);  // 새로 생성된 chatroomID 반환
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	
	public ArrayList<Chat> getList(int pageNumber){
		String SQL = "SELECT * FROM chatroom WHERE chatroomID<? ORDER BY chatroomID DESC LIMIT 10";
		ArrayList<Chat> list = new ArrayList<Chat>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Chat chat = new Chat();
				chat.setChatroomID(rs.getInt(1));
				chat.setChattitle(rs.getString(2));
				
				list.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}


	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM chatroom WHERE chatroomID < ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1) * 10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Chat getChatroom(int chatroomID) {
		String SQL = "SELECT * FROM chatroom WHERE chatroomID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, chatroomID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Chat chat = new Chat();
				chat.setChatroomID(rs.getInt(1));
				chat.setChattitle(rs.getString(2));
				chat.setChatAvailable(rs.getInt(3));
				return chat;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int update(int chatroomID, String chattitle) {
		String SQL = "UPDATE chatroom SET chattitle = ? WHERE chatroomID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, chattitle);
			pstmt.setInt(2, chatroomID);
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//�뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
	
	public int delete(int chatroomID) {
		String SQL = "UPDATE chatroom SET WHERE chatroomID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, chatroomID);
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
