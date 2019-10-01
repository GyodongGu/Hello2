package project1.impl;

import project1.model.Board;
import project1.model.BoardService;

public class BoardServiceImpl implements BoardService{

	@Override
	public void writeBoard(Board board, Board[] boards) {
		// TODO Auto-generated method stub
		for(int i = 0; i<boards.length; i++) {
			if(boards[i]== null) {
				boards[i] = board;
				break;
			}
		}
		
		
	}

	@Override
	public Board getBoard(int boardNo, Board[] boards) {
		// TODO Auto-generated method stub
		
		Board board = null;
		for(int i = 0; i<boards.length; i++) {
			if(boards[i] != null &&boards[i].getBoardNo() == boardNo) {
				board = boards[i];
			}
		}
		return board;
	}

	@Override
	public Board[] getBoardList(Board[] boards) {
		// TODO Auto-generated method stub
		Board[] boardAry = new Board[boards.length];
		
		for(int i =0; i<boards.length; i++) {
			boardAry[i] = boards[i];
		}
		
		return boardAry;
	}

	@Override
	public void updateBoard(Board board, Board[] boards) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<boards.length; i++) {
			if(boards[i] != null&& board.getBoardNo() == boards[i].getBoardNo()) {
				boards[i].setContent(board.getContent());
			}
		}
		
	}

	@Override
	public void deleteBoard(int boardNo, Board[] boards) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<boards.length; i++) {
			if(boards[i] != null && boardNo == boards[i].getBoardNo()) {
				boards[i] = null;
			}
		}
		
		
	}

	

}
