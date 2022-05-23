package review.model.dto;

public class Buyer {
	/** 구매자 아이디 */
	private String id;
	
	/** 구매자 비밀번호 */
	private int password;

	/** 구매자 이름 */
	private String name;

	/** 구매자 연락처 */
	private String contactInformation;

	public Buyer() {}
	public Buyer(String id, int password, String name, String contactInformation) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.contactInformation = contactInformation;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("구매자  아이디 : ");
		builder.append(id);
		builder.append(", 구매자 이름 : ");
		builder.append(name);
		builder.append(", 구매자 비밀번호 : ");
		builder.append(password);
		builder.append(", 구매자 연락처 : ");
		builder.append(contactInformation);
		return builder.toString();
	}
}