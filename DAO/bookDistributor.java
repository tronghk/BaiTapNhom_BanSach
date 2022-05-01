package DAO;

public class bookDistributor {
	private String idBookDistributor;
	private String nameDistributor;
	private String phoneNumber;
	private String addressDistributor;
	private String email;
	public bookDistributor(String idBookDistributor, String nameDistributor, String phoneNumber,
			String addressDistributor, String email) {
		super();
		this.idBookDistributor = idBookDistributor;
		this.nameDistributor = nameDistributor;
		this.phoneNumber = phoneNumber;
		this.addressDistributor = addressDistributor;
		this.email = email;
	}
	public String getIdBookDistributor() {
		return idBookDistributor;
	}
	public void setIdBookDistributor(String idBookDistributor) {
		this.idBookDistributor = idBookDistributor;
	}
	public String getNameDistributor() {
		return nameDistributor;
	}
	public void setNameDistributor(String nameDistributor) {
		this.nameDistributor = nameDistributor;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressDistributor() {
		return addressDistributor;
	}
	public void setAddressDistributor(String addressDistributor) {
		this.addressDistributor = addressDistributor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
