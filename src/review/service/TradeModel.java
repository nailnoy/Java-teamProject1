/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProjectService.java
 * DESC  :  재능 기부 프로젝트를 저장, 수정, 삭제, 검색하는 서비스 로직
 * 
 * @author  
 * @version 1.0
*/

package review.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
//step03
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import review.exception.NotFoundException;
import review.model.db.Data;
import review.model.dto.Buyer;
import review.model.dto.Product;
import review.model.dto.TradeList;

public class TradeModel {

	private static TradeModel instance = new TradeModel();

	/** 진행중인 Project를 저장하는 배열 */
	private ArrayList<TradeList> tradeList = new ArrayList<TradeList>();
	Data db = Data.getInstance();

	private TradeModel() {
	}

	public static TradeModel getInstance() {
		return instance;
	}

	/*
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public ArrayList<TradeList> getTradesList() {
		return tradeList;
	}

	/*
	 * 거래 고유 번호로 검색 - 존재할 경우 trade 반환하기, 없을 경우 null 반환
	 * 
	 * @param tradeNum 거래 고유 번호
	 * 
	 * @return trade 검색된 프로젝트
	 * 
	 * @exception 검색하는 거래가 미 존재할 경우 NotFoundProjectException 발생
	 */

	public boolean managerLogin(String id, String pw) throws NotFoundException {
		if (db.getManager().getId().equals(id) && db.getManager().getPassword().equals(pw)) {
			return true;
		}
		throw new NotFoundException("아이디나 비밀번호가 일치하지 않습니다!");
	}

	public TradeList getTrade(int tradeNum) throws NotFoundException {

		for (TradeList trade : tradeList) {
			if (trade.getTradeNum() == tradeNum) {
				// break : 반복문만 종료
				return trade; // 반복문 내부에 return이 있는 경우 메소드 자체를 종료
			}
		}

		// 이 line 이후에는 어떤한 로직도 실행 불가(로직 구현 불가)
		throw new NotFoundException("고객님 검색하는 거래는 미존재합니다 재확인 하셔요");
//		return null;  코딩시 에러 발생 
	}

	/*
	 * 새로운 거래 생성
	 */
	public void tradeInsert(TradeList trade) {
		tradeList.add(trade); // 데이터 자동으로 index 적용하면서 저장
	}

	/*
	 * 거래의 구매자 수정 - 프로젝트 명으로 검색해서 해당 구매자 변경
	 * 
	 * @param tradeNum 거래 고유 번호
	 * 
	 * @param people 구매자
	 */
	public void tradeBuyerUpdate(int tradeNum, Buyer people) throws NotFoundException {

		for (TradeList trade : tradeList) {
			if (trade.getTradeNum() == tradeNum) {
				trade.setTradeBuyer(people);
				return;
			}
		}
		throw new NotFoundException(tradeNum + "라는 거래 고유번호를 가진 거래는 미존재");
	}

	/*
	 * Project의 수혜자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 수혜자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * 
	 * @param people 수혜자
	 */
	public void newTradeUpdate(int tradeNum, Buyer people, Product product, String tradeDate) throws NotFoundException {

		for (TradeList trade : tradeList) {
			if (trade.getTradeNum() != tradeNum && trade.getTradeProduct() != product) {
				tradeList.add(new TradeList(tradeNum, people, product, tradeDate));
				return;
			}
		}
		throw new NotFoundException("입력된 값에 오류가 있습니다.");
	}

	/*
	 * Project 삭제 - 프로젝트 명으로 해당 프로젝트 삭제
	 * 
	 * @param projectName 삭제하고자 하는 프로젝트 이름
	 */
	// service.donationProjectDelete("01슈바이처----");
	public void tradeDelete(int tradeNum) throws NotFoundException {

		// 배열과 list에 사용 가능한 반복문
		for (TradeList trade : tradeList) {
			if (trade.getTradeNum() == tradeNum) {
				tradeList.remove(trade);
//				break;
				return; // 값이 없는 상태의 return; 문장 void를 반환하는 메소드 종료를 의미
			}
		}
		throw new NotFoundException(tradeNum + "라는 거래 고유번호를 가진 거래는 미존재");
	}

	public String inputData(String type) {
		Scanner sc = new Scanner(System.in);
		System.out.print(type + " : ");
		String input = sc.next();
		return input;
	}

	public void txtGenerate() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("playdata.txt"));
			int index = 0;

			for (TradeList trade : tradeList) {
				out.write("[완료된 거래들 : " + (index + 1) + "] " + trade.toString() + "\n");
				index++;
			}
		} catch (IOException e) { // IOException은 FileNotFoundException의 상위타입, 다형성
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();//
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void discardOldList() {
		Date d1 = null;
		Date d2 = null;
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			ArrayList<Integer> tradeNums = new ArrayList<Integer>();
			for (TradeList trade : tradeList) {
				d1 = f.parse("2022-02-23");
				d2 = f.parse(trade.getTradeDate());
				if (d2.before(d1)) {
					tradeNums.add(trade.getTradeNum());
					System.out.println(trade.getTradeNum() + "거래 삭제");
				}
			}
			for (Integer num : tradeNums) {
				tradeDelete(num);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void importBuyer() {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader("buyer.txt"));

			// read한 데이터를 대입받는 변수, 데이터가 있으면 String객체, 없을 경우 null
			String readData = null;
			int i = 0;

			while ((readData = in.readLine()) != null) {
				if (i == 0) {
					continue; // 조건식이 true일 경우 해당 로직 생략 후에 다시 i++영역으로 실행 유지 
				}
				String [] row = readData.split(", ");
				System.out.println(row[0]);
				i++;
			}

		} catch (FileNotFoundException e) { // file이 없을 경우 실행
			e.printStackTrace();
			// file이 없을 경우에만 실행되는 예외처리 화면 지정

		} catch (IOException e) { // 데이터 read시에 예외 발생시 실행
			e.printStackTrace();
			// 데이터 read시에 예외 처리 화면 지정
		} finally {
			try {
				if (in != null) {
					in.close();// 예외발생 여부와 무관하게 실행되는 블록
					in = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

//	public void wqfew() {
//		JSONObject obj = new JSONObject();
//
//		try {
//			JSONArray jArray = new JSONArray();
//			for (int i = 0; i < tradeList.size(); i++)// 배열
//			{
//				obj.put("tradeNum", (Object)tradeList.get(i).getTradeNum());
//				
//				JSONObject sObject = new JSONObject();// 배열 내에 들어갈 json
//				sObject.put("contentid", tradeList.get(i).getTradeNum());
//				sObject.put("contenttypeid", tradeList.get(i).getTradeBuyer());
//				sObject.put("mapx",tradeList.get(i).getTradeProduct());
//				sObject.put("mapy", tradeList.get(i).getTradeDate());
//				jArray.put(sObject);
//			}
//			obj.put("planName", "planA");
//			obj.put("id", "userID");
//			obj.put("item", jArray);// 배열을 넣음
//
//			System.out.println(obj.toString());
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//	}

	/*
	 * 진행중인 Project 총 개수 반환
	 * 
	 * @return 개수
	 */
	public int tradeListSize() {
		return tradeList.size();
	}
}
