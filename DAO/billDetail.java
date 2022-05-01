package DAO;

public class billDetail {
	private int idBill;
	private String idBook;
	private int quantityBook;
	private float unitPrice;
	private float intoMoney;
	private String idPromotion;
	private float moneyDown;
	public billDetail(int idBill, String idBook, int quantityBook, float unitPrice, float intoMoney, String idPromotion,
			float moneyDown) {
		super();
		this.idBill = idBill;
		this.idBook = idBook;
		this.quantityBook = quantityBook;
		this.unitPrice = unitPrice;
		this.intoMoney = intoMoney;
		this.idPromotion = idPromotion;
		this.moneyDown = moneyDown;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public int getQuantityBook() {
		return quantityBook;
	}
	public void setQuantityBook(int quantityBook) {
		this.quantityBook = quantityBook;
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
	public String getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(String idPromotion) {
		this.idPromotion = idPromotion;
	}
	public float getMoneyDown() {
		return moneyDown;
	}
	public void setMoneyDown(float moneyDown) {
		this.moneyDown = moneyDown;
	}
	
}
