package review.controller;

import java.util.ArrayList;

import review.exception.NotFoundException;
import review.model.dto.Buyer;
import review.model.dto.Product;
import review.model.dto.TradeList;
import review.service.TradeModel;
import review.view.FailView;
import review.view.SuccessView;

public class TradeController {

	private static TradeModel service = TradeModel.getInstance();

	/* StartView가 직접 호출하는 기능(메소드)
	 * 발생가능한 경우의 수
	 * 경우의 1 - 데이터가 있다.SuccesView
	 * 경우의 2 - 단 하나의 데이터가 없다.FailView
	 */
	public static void  getTradesList() {
		ArrayList<TradeList> trades = service.getTradesList();
		if(trades.size() != 0){
			SuccessView.tradeListView(trades);
		}else {
			FailView.printFail("생성된 거래가 없습니다");
		}
	}
	
	public static void getTrade(int tradeNum) {
		try {
			SuccessView.tradeView(service.getTrade(tradeNum));
		} catch (NotFoundException e) {
			e.printStackTrace();// 개발시 확인용 또는 유지보수 관리자들 확인용 메세지
			FailView.printFail(e.getMessage()); // client에게 응답하게되는 메세지
		}
		

	}
	
	/* StartView에서 즉 보이는 요청 화면에서 데이터 입력된 정보를 받아서 Controller
	 * 입력의 유효성 검증 후 유효하다면 model의 메소드에 저장
	 * 무의미한 데이터가 입증되면 FailView의 사용자 입력 다시 하세요 라는 메세지 출력
	 * 
	 * 입력 여부 검증 - null
	 * 
	 */

	public static void tradeInsert(TradeList trade) {
		if(trade != null) {
			service.tradeInsert(trade);
		}else {
			FailView.printFail("사용자 입력 다시 하세요");
		}
	}
	
	/* StartView로 요청받고 Model의 메소드 호출해서 DB의 실제 데이터 수정
	 * 발생가능한 경우의 수
	 * 경우의 1 - Client의 정보가 유의미하다 - 업데이트 실행
	 * 경우의 2 - 입력한 정보가 의미없다 - 업데이트 실행
	 */

	public static void tradeBuyerUpdate(int tradeNum, Buyer people) {
		if(tradeNum != 0 && people != null) {
			try {
				service.tradeBuyerUpdate(tradeNum, people);
				SuccessView.successMesssage("해당 거래 구매자 정보수정 완료");
			}catch(NotFoundException e) {
				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		}else {
			FailView.printFail("갱신정보 재확인");
		}
	}

	public static void newTradeUpdate(int tradeNum, Buyer people, Product product, String tradeDate) {
		if(tradeNum != 0 && people != null && product != null && tradeDate != null) {
			try {
				service.newTradeUpdate(tradeNum, people, product, tradeDate);
				SuccessView.successMesssage("해당 거래 생성 완료");
			}catch(NotFoundException e) {
				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		}else {
			FailView.printFail("갱신정보 재확인");
		}
		
	}

	public static void tradeDelete(int tradeNum) {
		
		if(tradeNum != 0) {
			try {
				service.tradeDelete(tradeNum);
				SuccessView.successMesssage(tradeNum +" 해당 거래 삭제 완료");
			}catch(NotFoundException e) {
				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
			
		}else {
			FailView.printFail("삭제할 거래 고유번호 재확인");
		}
		
	}

	public static boolean managerLogin() {
		String id = service.inputData("아이디");
		String pw = service.inputData("비밀번호");
		if (id != null && pw != null) {
			try {
				if (service.managerLogin(id, pw)) {
					SuccessView.successMesssage("관리자로 로그인 완료");
					return true;
				}else {
					return false;
					
				}
			}catch(NotFoundException e) {
				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}		
		}else {
			FailView.printFail("아이디와 비밀번호는 공백일 수 없습니다.");
		}
		return false;
	}
	
	public static void txtGenerate() {
		service.txtGenerate();
	}
	
	public static void discardOldList() {
		service.discardOldList();
	}
	
	public static void importBuyer() {
		service.importBuyer();
	}
	

}
