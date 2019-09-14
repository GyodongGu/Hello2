package Hello;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int x=0; x<5; x++) {
			for(int y=1; y<10; y++) {
				if((y<=5+x) && (y>=5-x)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i = 1; i<=5; i++) {
			for(int j=1; j<(10-i); j++) {
				if(i >= j) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		

	}

}
