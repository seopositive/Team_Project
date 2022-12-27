package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCConnection;
import vo.UserVO;

public class UserDAO {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	
		public UserVO getUser(String id, String pw) {
			UserVO user = null;
			
			try {
				// DB접속
				conn = JDBCConnection.getConnection();
				
				String sql = "select * from test_user where id= ? and password = ?";
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, id);
				stmt.setString(2, pw);
				
				rs = stmt.executeQuery();
				
				if(rs.next()) {	
					user = new UserVO();
					user.setId(rs.getString("id"));
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(rs, stmt, conn);
			}
			
			return user;
		}
		
		
		public void insertJoin(UserVO user) {
			
			try {
				// DB접속
				conn = JDBCConnection.getConnection();
				
				String sql = "insert into test_user(id, password, name) values(?,?,?)";
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, user.getId());
				stmt.setString(2, user.getPassword());
				stmt.setString(3, user.getName());
				
				stmt.executeUpdate();
				
				System.out.println("유저 DB삽입 완료!");

				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(stmt, conn);
			}
			
		}



}
