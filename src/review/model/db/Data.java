 //Database라 가정

package review.model.db;

import review.model.dto.Buyer;
import review.model.dto.Manager;
import review.model.dto.Seller;
import review.model.dto.TradeList;
import review.model.dto.Product;

public class Data {
	private static Data instance = new Data();	//SingleTon 패턴 이점 : 메모리 효율, 데이 공유에 쉬
	
	//모든 요청하는 user들이 공유하는 단일 데이터라 가정
	private static Manager manager = new Manager("omomo", "12345", "이관용", "010-1210-4424");
	
	
	
	private static Buyer buyer1 = new Buyer("dvcev", 177777, "김의사", "010-111-7777");
	private static Buyer buyer2 = new Buyer("fefef", 277777, "신예능", "010-222-7777");
	private static Buyer buyer3 = new Buyer("eecef", 377777, "이레사", "010-333-7777");
	private static Buyer buyer4 = new Buyer("rfeff", 477777, "박메너", "010-444-7777");
			
	//판매자
	private static Seller seller1 = new Seller("dwdn", 111111, "이송", "010-111-1111");
	private static Seller seller2 = new Seller("cnde", 222222, "이건강", "010-222-2222");
	private static Seller seller3 = new Seller("wdew", 333333, "김미모", "010-555-5555");
	private static Seller seller4 = new Seller("dcdd", 444444, "맘아픔", "010-333-3333");
	
	//판매 물품
	private static Product soju = new Product("소주", "주류", seller1, 3000);
	private static Product imac = new Product("아이맥", "컴퓨터", seller2, 1300000);
	private static Product sangchu = new Product("상추", "식품", seller3, 1000);
	private static Product dress = new Product("드레스", "의류", seller3, 20000);
	private static Product bag = new Product("가방", "의류 잡화", seller4, 40000);
	
	//거래 목록
	//프로젝트명, 기부자, 수혜자, 재능기부종류, 시작일, 종료일, 재능기부 실제 내용
	private static TradeList tradeSoju = new TradeList(1234, buyer1, soju, "2020-03-31");		
	private static TradeList tradeImac = new TradeList(5678, buyer2, imac, "2020-04-03");	
	private static TradeList tradeSangchu = new TradeList(9012, buyer3, sangchu, "2020-04-05");

	
	private Data() {}
	public static Data getInstance() {
		return instance;
	}
	public Manager getManager() {
		return manager;
	}
	public TradeList getTradeSoju() {
		return tradeSoju;
	}
	public TradeList getTradeImac() {
		return tradeImac;
	}
	public TradeList getTradeSangchu() {
		return tradeSangchu;
	}
	public Buyer getBuyer4() {
		return buyer4;
	}
	public  Product getBag() {
		return bag;
	}
	public static Product getDress() {
		return dress;
	}
	

	
}