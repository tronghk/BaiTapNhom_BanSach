package DAO;

public class customer extends person {
	private String idCustomer;
	private String typeCustomer;
	public customer(String idCustomer, String name, String phoneNumber, String address, String typeCustomer) {
		super(name, phoneNumber, address);
		this.idCustomer = idCustomer;
		this.typeCustomer = typeCustomer;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getTypeCustomer() {
		return typeCustomer;
	}
	public void setTypeCustomer(String typeCustomer) {
		this.typeCustomer = typeCustomer;
	}
	
}
