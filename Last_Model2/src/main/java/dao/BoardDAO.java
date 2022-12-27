package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCConnection;
import vo.BoardVO;

public class BoardDAO {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		public int addBoard(BoardVO vo) {
			
			int cnt = 0;
			
			try {
				conn = JDBCConnection.getConnection();
				
				String sql = "insert into test_board(seq, title, nickname, content) values((select nvl(max(seq),0)+1 from test_board), ?,?,?)";
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getNickname());
				stmt.setString(3, vo.getContent());

				cnt = stmt.executeUpdate();
				
				System.out.println("보드 DB삽입 완료");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(stmt, conn);
			}
			
			
			return cnt;
		}


		public ArrayList<BoardVO> getBoardList() {
			
			ArrayList<BoardVO> list = new ArrayList<>();
			
			try {
				conn = JDBCConnection.getConnection();
				
				String sql = "select * from test_board order by seq desc";
				
				stmt = conn.prepareStatement(sql);
				
				rs = stmt.executeQuery();
				
				list = new ArrayList<BoardVO>();
				
				while(rs.next()) {
					
					int seq = rs.getInt("seq");
					String title = rs.getString("title");
					String nickname = rs.getString("nickname");
					String content = rs.getString("content");
					Date regdate = rs.getDate("regdate");
					int cnt = rs.getInt("cnt");
					
					BoardVO board = new BoardVO();
					board.setSeq(seq);
					board.setTitle(title);
					board.setNickname(nickname);
					board.setContent(content);
					board.setRegdate(regdate);
					board.setCnt(cnt);
					
					// 가방 담기
					list.add(board);
				}
				
				System.out.println("리스트 가져오기 완료");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(rs, stmt, conn);
			}
			
			return list;
		}


		public BoardVO OneBoradGet(int num) {
			
			BoardVO board = null;
			
			try {
				// DB 접속
				conn = JDBCConnection.getConnection();
				// 조회수 증가
				String sql = "update test_board set cnt = (select cnt + 1 from board_board where seq = ?) where seq = ?";
				// ?
				stmt = conn.prepareStatement(sql);
				// ? 매핑
				stmt.setInt(1, num);
				stmt.setInt(2, num);
				// 실행
				stmt.executeUpdate();
				
				stmt.close();
				
				// 글 읽기
				sql = "select * from test_board where seq = ?";
				// ?
				stmt = conn.prepareStatement(sql);
				// ? 매핑
				stmt.setInt(1, num);
				// 실행
				rs = stmt.executeQuery();
				// 사용
				if(rs.next()) {
					board = new BoardVO();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setNickname(rs.getString("nickname"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getDate("regdate"));
					board.setCnt(rs.getInt("cnt"));
				}
				
				System.out.println("하나 가져오기 완료");
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(rs,stmt, conn);
			}
			
			return board;
			
		}


		public int updateBoard(BoardVO vo) {
			
			int cnt = 0;
			
			try {
				// DB 접속
				conn = JDBCConnection.getConnection();
				
				// sql
				String sql = "update test_board set title = ?, content = ? where seq = ?";
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getContent());
				stmt.setInt(3, vo.getSeq());
				
				// 실행
				cnt = stmt.executeUpdate();
					
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(stmt, conn);
			}
			
			
			
			return cnt;
		}


		public int deleteBoard(int num) {
			
			int cnt = 0;
			
			try {
				// DB 연결
				conn = JDBCConnection.getConnection();
				// sql
				String sql = "delete from test_board where seq = ?";
				// ?
				stmt = conn.prepareStatement(sql);
				// ? 매핑
				stmt.setInt(1, num);
				// 실행
				cnt = stmt.executeUpdate();
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCConnection.close(stmt, conn);
			}
			
			// 리턴
			return cnt;
			
		
		}
	
		

}
