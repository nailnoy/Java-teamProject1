package review.view;

import review.controller.TradeController;
import review.model.db.Data;


public class StartView {
	
	public static void main(String[] args) {
		Data db = Data.getInstance();
		System.out.println("*** 00. 관리자 계정으로 로그인 ***");

		if(TradeController.managerLogin()) {
		
		System.out.println("*** 01. 완료된 거래 생성 ***");
		TradeController.tradeInsert(db.getTradeSoju());
		TradeController.tradeInsert(db.getTradeImac());
		TradeController.tradeInsert(db.getTradeSangchu());
		
//		// *************
		System.out.println("\n*** 02. 모든 거래 검색 ***");
		TradeController.getTradesList();		
		
		System.out.println("\n*** 03. 거래 고유번호 '1234' 검색 ***");
		TradeController.getTrade(1234);
		
//		//구매자 변경하기 
		System.out.println("\n*** 04. 거래 고유번호 '1234'의 구매자 변경(수정) 후 해당 거래 기록 검색 ***");
		TradeController.tradeBuyerUpdate(1234, db.getBuyer4());
		TradeController.getTrade(1234);
		
		//새로운 거래 생성하기
		System.out.println("\n*** 05. '박메너'의 가방 구매 기록 생성 후 해당 거래 기록 검색  ***");
		TradeController.newTradeUpdate(3245, db.getBuyer4(), db.getBag(), "2022-05-18");
		TradeController.getTrade(3245);
		
//		//재능 기부자 삭제하기 
		System.out.println("\n*** 06. 거래 고유번호 '1234'인 거래 삭제 후 삭제한 거래 기록 검색 ***");
		TradeController.tradeDelete(1234);
		TradeController.getTrade(1234);
		
		System.out.println("\n*** 07. 거래 내역 텍스트 파일 생성 ***");
		TradeController.txtGenerate();
		
		}else {
			System.out.println("재실행 부탁드립니다.");
		}
	}
}
