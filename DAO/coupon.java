package DAO;

import java.time.LocalDate;

public class coupon {
	private int idCoupon;
	private LocalDate dateAdded;
	private float intoMoney;
	private String idBookDistributor;
	public coupon(int idCoupon, LocalDate dateAdded, float intoMoney, String idBookDistributor) {
		super();
		this.idCoupon = idCoupon;
		this.dateAdded = dateAdded;
		this.intoMoney = intoMoney;
		this.idBookDistributor = idBookDistributor;
	}
	public int getIdCoupon() {
		return idCoupon;
	}
	public void setIdCoupon(int idCoupon) {
		this.idCoupon = idCoupon;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public float getIntoMoney() {
		return intoMoney;
	}
	public void setIntoMoney(float intoMoney) {
		this.intoMoney = intoMoney;
	}
	public String getIdBookDistributor() {
		return idBookDistributor;
	}
	public void setIdBookDistributor(String idBookDistributor) {
		this.idBookDistributor = idBookDistributor;
	}
	
}
