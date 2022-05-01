package DAO;

public class detailPromotion {
	private String idBook;
	private String idPromotion;
	private int discount;
	public detailPromotion(String idBook, String idPromotion, int discount) {
		super();
		this.idBook = idBook;
		this.idPromotion = idPromotion;
		this.discount = discount;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public String getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(String idPromotion) {
		this.idPromotion = idPromotion;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
