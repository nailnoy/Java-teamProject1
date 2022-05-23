package review.model.dto;

public class Product {
	/** 물품 이름 */
	private String produtName; 
	
	/** 물품 종류 */
	private String productType; 
	
	/** 물품 판매자 */
	private Seller productSeller;
	
	/** 물품 가격*/
	private int price;

	public Product() {}
	public Product(String produtName, String productType, Seller productSeller, int price) {
		super();
		this.produtName = produtName;
		this.productType = productType;
		this.productSeller = productSeller;
		this.price = price;
	}

	public String getProdutName() {
		return produtName;
	}
	public void setProdutName(String produtName) {
		this.produtName = produtName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Seller getProductSeller() {
		return productSeller;
	}
	public void setProductSeller(Seller productSeller) {
		this.productSeller = productSeller;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("물품 이름 : ");
		builder.append(produtName);
		builder.append(", 물품 종류 : ");
		builder.append(productType);
		builder.append(", 물품 판매자 : ");
		builder.append(productSeller);
		builder.append(", 물품 가격 : ");
		builder.append(price);
		builder.append("원");
		return builder.toString();
	}
}
