package project3.impl;


import java.util.List;

import project3.model.BoardDB;
import project3.model.BoardDBService;

public class BoardDBServiceImpl implements BoardDBService{
	
	BoardDBDAO dao = new BoardDBDAO();

	@Override
	public String loginCheck(String id, String pw) {
		// TODO Auto-generated method stub
		String name = dao.getUserName(id, pw);
		return name;
	}

	@Override
	public void writeBoardDB(BoardDB board) {
		// TODO Auto-generated method stub
		dao.insertBoardDB(board);
	}

	@Override
	public List<BoardDB> getBoardDBList() {
		// TODO Auto-generated method stub
		List<BoardDB> list = dao.BoardDBList();
		return list;
	}

	@Override
	public BoardDB getBoardDB(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoardDB(BoardDB board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardDB(int boardNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeReplyBoardDB(BoardDB board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardDB> getReply(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
