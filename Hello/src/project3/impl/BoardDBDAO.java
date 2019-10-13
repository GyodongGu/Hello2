package project3.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project3.common.DAO;
import project3.model.BoardDB;

public class BoardDBDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<BoardDB> BoardDBList() {
		conn = DAO.getConnect();
		List<BoardDB> list = new ArrayList<>();
		String sql = "select * from boards where orig_no is null order by board_no desc";

		BoardDB board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new BoardDB();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setCreationDate(rs.getString("creation_date"));
				board.setOrigNo(rs.getInt("orig_no"));

				list.add(board);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// 게시글 작성
	public void insertBoardDB(BoardDB board) {
		conn = DAO.getConnect();
		String sql = "insert into boards values ((select nvl(max(board_no),0)+1 from boards), ?, ?, ?, sysdate, null)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 작성했습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 로그인
	public String getUserName(String id, String passwd) {
		conn = DAO.getConnect();
		String sql = "select * from user_login where id = ? and passwd = ?";
		String name = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return name;
	}

}
