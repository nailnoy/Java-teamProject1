package review.model.dto;

public class Manager {
	/** 관리자 아이디 */
	private String id;
	
	/** 관리자 비밀번호 */
	private String password;

	/** 관리자 이름 */
	private String name;

	/** 관리자 연락처 */
	private String contactInformation;

	public Manager() {}
	public Manager(String id, String password, String name, String contactInformation) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
		builder.append("관리  아이디 : ");
		builder.append(id);
		builder.append(", 관리자 비밀번호 : ");
		builder.append(name);
		builder.append(", 관리자 이름 : ");
		builder.append(contactInformation);
		builder.append(", 관리자 연락처 : ");
		builder.append(contactInformation);
		return builder.toString();
	}
}