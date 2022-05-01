package DAO;

import java.time.LocalDate;

public class bill {
	private int idBill;
	private String idCustomer;
	private String idEmployee;
	private LocalDate dateBill;
	private float sumMoney;
	private String typePayment;
	private float discountMoney;
	private float moneyPayment;
	public bill(int idBill, String idCustomer, String idEmployee, LocalDate dateBill, float sumMoney,
			float discountMoney, float moneyPayment, String typePayment) {
		super();
		this.idBill = idBill;
		this.idCustomer = idCustomer;
		this.idEmployee = idEmployee;
		this.dateBill = dateBill;
		this.sumMoney = sumMoney;
		this.discountMoney = discountMoney;
		this.moneyPayment = moneyPayment;
		this.typePayment = typePayment;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	public LocalDate getDateBill() {
		return dateBill;
	}
	public void setDateBill(LocalDate dateBill) {
		this.dateBill = dateBill;
	}
	public float getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(float sumMoney) {
		this.sumMoney = sumMoney;
	}
	public float getDiscountMoney() {
		return discountMoney;
	}
	public void setDiscountMoney(float discountMoney) {
		this.discountMoney = discountMoney;
	}
	public float getMoneyPayment() {
		return moneyPayment;
	}
	public void setMoneyPayment(float moneyPayment) {
		this.moneyPayment = moneyPayment;
	}
	public String getTypePayment() {
		return typePayment;
	}
	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}
	
}
