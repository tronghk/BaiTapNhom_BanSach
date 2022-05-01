package DAO;

public class detailCoupon {
	private String idBook;
	private int idCoupon;
	private int quantityImport;
	private float unitPrice;
	private float intoMoney;
	public detailCoupon(String idBook, int idCoupon, int quantityImport, float unitPrice, float intoMoney) {
		super();
		this.idBook = idBook;
		this.idCoupon = idCoupon;
		this.quantityImport = quantityImport;
		this.unitPrice = unitPrice;
		this.intoMoney = intoMoney;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public int getIdCoupon() {
		return idCoupon;
	}
	public void setIdCoupon(int idCoupon) {
		this.idCoupon = idCoupon;
	}
	public int getQuantityImport() {
		return quantityImport;
	}
	public void setQuantityImport(int quantityImport) {
		this.quantityImport = quantityImport;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getIntoMoney() {
		return intoMoney;
	}
	public void setIntoMoney(float intoMoney) {
		this.intoMoney = intoMoney;
	}
	
}
