package Hello;

public class ShopService {
	
	private static ShopService singleton = new ShopService();
	
	static ShopService getInstance() {
		
		return singleton;
	}

}
