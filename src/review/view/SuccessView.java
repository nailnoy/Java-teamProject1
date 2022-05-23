/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  EndView.java
 * DESC  : 재능 기부 정보 출력 클래스
 * 
 * @author  
 * @version 1.0
*/

package review.view;
        
import java.util.ArrayList;

import review.model.dto.TradeList;

public class SuccessView {
	
	//진행중인 특정 거래 출력 
	public static void tradeView(TradeList trade){
		if(trade != null) {
			System.out.println(trade);		
		}else {
			System.out.println("거래는 존재하지 않습니다.");
		}
	}
	
	//완료된 모든 거래 출력
	public static void tradeListView(ArrayList<TradeList> allTradeList){

		int index = 0;
		
		//for each 반복문 
		//ArrayList내에 데이터가 있는 수만큼만 반복 수행
		for(TradeList trade : allTradeList) {
			System.out.println("[완료된 거래들 : " + (index+1) + "] " + trade.toString());
			index++;
		}
	}

	public static void successMesssage(String message) {
		System.out.println("진행 사항 : " + message);
	}
	
}




