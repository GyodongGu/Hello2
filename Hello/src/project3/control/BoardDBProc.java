package project3.control;

import java.util.List;
import java.util.Scanner;

import project3.impl.BoardDBServiceImpl;
import project3.model.BoardDB;
import project3.model.BoardDBService;

public class BoardDBProc {
	
	Scanner sc = new Scanner(System.in);
	BoardDBService service = new BoardDBServiceImpl();
	
	String loginId = null;
	String loginName = null;

	public void execute() {
		
		loginCheck();
		
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 게시글 작성 | 2. 게시글 전체 목록 | 3. 게시글 선택 조회 | 4. 게시글 수정 | 5.게시글 삭제 | 6. 종료");
			
			int menu = sc.nextInt(); sc.nextLine();
			
			if(menu == 1) {
				writeBoardDB();
			}else if(menu == 2) {
				BoardList();
			}else if(menu == 3) {
				
			}else if(menu == 4) {
				
			}else if(menu == 5) {
				
			}else if(menu == 6) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		System.out.println("프로그램 종료되었습니다.");
		
	}
	
	public void BoardList() {
		System.out.println("게시글 전체조회");
		List<BoardDB> list = service.getBoardDBList();
		
		for(BoardDB bb : list) {
			System.out.println(bb);
		}
	}
	
	public void writeBoardDB() {
		System.out.println("제목을 입력해주세요");
		String title = sc.nextLine();
		System.out.println("내용을 입력해주세요");
		String content = sc.nextLine();
		String writer = loginName;
		
		BoardDB bDB = new BoardDB();
		bDB.setTitle(title);
		bDB.setContent(content);
		bDB.setWriter(writer);
		
		service.writeBoardDB(bDB);
		
		System.out.println("글을 작성하였습니다.");
		
	}
	
	public void loginCheck() {
		String name = null;
		while(true) {
			System.out.println("아이디를 입력하세요");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력하세요");
			String pw = sc.nextLine();
			
			name = service.loginCheck(id, pw);
			if(name != null) {
				System.out.println(name + "님 환영합니다");
				loginId = id;
				loginName = name;
				break;
			}else {
				System.out.println("id와 pw를 다시 입력하세요.");
			}
		}
		
	}
	
}
