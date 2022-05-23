/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProject.java
 * DESC  :  진행중인 프로젝트 정보(Data)
 * 
 * @author  
 * @version 1.0
*/
package review.model.dto;

public class TradeList {

	/** 거래 고유 번호 */
	private int tradeNum;

	/** 거래 구매자*/
	private Buyer tradeBuyer;

	/** 거래 물품 */
	private Product tradeProduct;

	/** 거래 완료일 */
	private String tradeDate;

	public TradeList() {
		super();
	}
	public TradeList(int tradeNum, Buyer tradeBuyer, Product tradeProduct, String tradeDate) {
		super();
		this.tradeNum = tradeNum;
		this.tradeBuyer = tradeBuyer;
		this.tradeProduct = tradeProduct;
		this.tradeDate = tradeDate;
	}

	public int getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}
	public Buyer getTradeBuyer() {
		return tradeBuyer;
	}
	public void setTradeBuyer(Buyer tradeBuyer) {
		this.tradeBuyer = tradeBuyer;
	}
	public Product getTradeProduct() {
		return tradeProduct;
	}
	public void setTradeProduct(Product tradeProduct) {
		this.tradeProduct = tradeProduct;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("거래 고유 번호 : ");
		builder.append(tradeNum);
		builder.append(", 거래 구매자 : ");
		builder.append(tradeBuyer);
		builder.append(", 거래 물품 : ");
		builder.append(tradeProduct);
		builder.append(", 거래 완료일 : ");
		builder.append(tradeDate);
		return builder.toString();
	}
}