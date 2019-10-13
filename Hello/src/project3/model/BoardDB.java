package project3.model;

public class BoardDB {
	//field
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String creationDate;
	private int origNo;
	
	//get-set method
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getOrigNo() {
		return origNo;
	}
	public void setOrigNo(int origNo) {
		this.origNo = origNo;
	}
	
	//생성자
	public BoardDB() {
		
	}
	public BoardDB(int boardNo, String title, String content, String writer, String creationDate, int origNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.creationDate = creationDate;
		this.origNo = origNo;
	}
	@Override
	public String toString() {
		return "BoardDB [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", creationDate=" + creationDate + ", origNo=" + origNo + "]";
	}
	
	

}
