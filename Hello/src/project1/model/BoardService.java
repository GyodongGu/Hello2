package project1.model;

public interface BoardService {

	public void writeBoard(Board board, Board[] boards);
	public Board getBoard(int boardNo, Board[] boards);
	public Board[] getBoardList(Board[] boards);
	public void updateBoard(Board board, Board[] boards);
	public void deleteBoard(int boardNo, Board[] boards);
	
}
