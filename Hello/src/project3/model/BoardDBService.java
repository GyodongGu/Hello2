package project3.model;

import java.util.List;

public interface BoardDBService {

	
	public String loginCheck(String id, String pw);//로그인
	public void writeBoardDB(BoardDB board);//글작성
	public List<BoardDB> getBoardDBList();//글 전체목록
	public BoardDB getBoardDB(int boardNo);//글 단건 조회
	public void updateBoardDB(BoardDB board);//게시글 수정
	public void deleteBoardDB(int boardNo);//게시글 삭제
	
	public void writeReplyBoardDB(BoardDB board);//댓글작성
	public List<BoardDB> getReply(int boardNo);//댓글조회
	
}
