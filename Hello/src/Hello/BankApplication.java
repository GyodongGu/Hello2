package Hello;

import java.util.Scanner;

public class BankApplication {
	
	private static Account[] accountArray = new Account[10];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3. 예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = sc.nextInt();
			
			
			if(selectNo ==1) {
				createAccount();
			}else if(selectNo ==2) {
				accountList();
			}else if(selectNo ==3) {
				deposit();
			}else if(selectNo == 4) {
				withdraw();
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	//계좌생성하기
	private static void createAccount() {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");
		
		System.out.print("계좌번호 : ");
		String no =sc.next();
		System.out.println();
		System.out.print("계좌주 : ");
		String owner = sc.next();
		System.out.println();
		System.out.print("초기입금액 : ");
		int balance = sc.nextInt();
		System.out.println();
		
		Account NewAccount = new Account(no, owner, balance);
		
		for(int i =0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = NewAccount;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}		
		}
				
	}
	//계좌 목록 보기
	private static void accountList() {
		
		System.out.println("-----------");
		System.out.println("계좌 목록");
		System.out.println("-----------");
		
		for(int i =0; i<accountArray.length; i++) {
			Account account = accountArray[i];
			if(account != null) {
				System.out.print(account.getAno());
				System.out.print("     ");
				System.out.print(account.getOwner());
				System.out.print("     ");
				System.out.print(account.getBalance());
				System.out.println();
			}
		}
		
	}
	//예금하기
	private static void deposit() {
		
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");
		System.out.println("계좌번호 : ");
		String ano = sc.next();
		System.out.println("예금액 : ");
		int money = sc.nextInt();
		
		Account account = findAccount(ano);
		if(account == null) {
			System.out.println("계좌가 없습니다.");
			return;
		}
		else {
			int newBalance = account.getBalance() + money;
			account.setBalance(newBalance);
		}
	}
	//출금하기
	private static void withdraw() {
		
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");
		System.out.println("계좌번호 : ");
		String ano = sc.next();
		System.out.println("출금액 : ");
		int money = sc.nextInt();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("계좌가 없습니다");
			return;
		}
		else {
			int newBalance = account.getBalance() - money;
			if(newBalance <0) {
				System.out.println("돈이 부족합니다");
			}
			else {
				account.setBalance(newBalance);
			}
		}
		
	}
	
	//Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		Account account = null;
		
		for(int i =0; i < accountArray.length; i++) {
			if(accountArray[i] != null) {
				String dbAno = accountArray[i].getAno();
				if(dbAno.equals(ano)) {
					account = accountArray[i];
					break;
				}
				
			}
		}
		return account;
	}

}
