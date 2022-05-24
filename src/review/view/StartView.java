package review.view;

import java.util.Scanner;
import review.controller.TradeController;
import review.model.db.Data;

public class StartView {
	public static void main(String[] args) {
		Data db = Data.getInstance();
		System.out.println("*** 00. 관리자 계정으로 로그인 ***");
		int rn = 0;
		Scanner sc = new Scanner(System.in);
		int tradeNum = 0;

		while (rn < 4) {
			rn++;
			if (TradeController.managerLogin() == true) {
				System.out.println("*** 01. 완료된 거래 목록이 생성되었습니다. ***");
				TradeController.tradeInsert(db.getTradeSoju());
				TradeController.tradeInsert(db.getTradeImac());
				TradeController.tradeInsert(db.getTradeSangchu());
				System.out.print(
						"관리자님, 환영합니다! \n 1 : 모든 거래를 검색 \n 2 : 거래고유번호로 거래를 검색 \n 3 : 거래목록의 구매자를 변경 \n 4 : 거래목록을 삭제 \n 5 : 오래된 거래목록을 삭제 \n 6 : 거래목록 텍스트 파일로 출력 \n 원하는 행동을 숫자로 입력하세요 : ");

				int requestNum = sc.nextInt();
				switch (requestNum) {

				case 1:
					System.out.println("\n***모든 거래를 검색합니다. ***");
					TradeController.getTradesList();
					break;

				case 2:
					System.out.print("검색하고 싶은 거래의 고유번호를 입력해주세요 : ");
					tradeNum = sc.nextInt();
					System.out.println("\n***거래 고유번호" + tradeNum + "검색 ***");
					TradeController.getTrade(tradeNum);
					break;

				case 3:
					System.out.print("검색하고 싶은 거래의 고유번호를 입력해주세요 : ");
					tradeNum = sc.nextInt();
					System.out.print("변경하고 싶은 구매자 아이디를 작성해주세요 : ");
					String buyerId = sc.next();
					TradeController.tradeBuyerUpdate(tradeNum, db.getBuyersMap().get(buyerId));
					System.out.println("\n***거래 고유번호" + tradeNum + "검색 ***");
					TradeController.getTrade(tradeNum);
					break;

				case 4:
					System.out.print("지우고 싶은 거래의 고유번호를 입력해주세요 : ");
					tradeNum = sc.nextInt();
					System.out.println("\n*** 거래 고유번호" + tradeNum + "인 거래 삭제 후 삭제한 거래 기록 검색합니다. ***");
					TradeController.tradeDelete(tradeNum);
					TradeController.getTrade(tradeNum);
					break;

				case 5:
					System.out.print("개인정보 보호를 위해 오래된 거래목록을 자동 삭제합니다. 남아 있는 기록을 표시합니다.");
					TradeController.discardOldList();
					TradeController.getTradesList();
					break;
					
				case 6:
					System.out.println("남아 있는 거래목록을 텍스트 파일로 저장해 드립니다.");
					TradeController.txtGenerate();
					break;

				default:
					System.out.println("웁스! 잘못 입력하셨나봐요! 로그인 단계부터 다시 시도해주세요.");
					break;

				}
				break;
			} else {
				if (rn == 4) {
					System.out.println("입력회수초과");
				} else {
					System.out.println("재실행" + rn);
				}

			}
		}

	}
}
