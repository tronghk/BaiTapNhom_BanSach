package DAO;

public class employee extends person{
	private String idEmployee;
	private String email;
	private float turnover;
	private int totalSales;
	public employee(String name, String phoneNumber, String address, String idEmployee, String email, float turnover,
			int totalSales) {
		super(name, phoneNumber, address);
		this.idEmployee = idEmployee;
		this.email = email;
		this.turnover = turnover;
		this.totalSales = totalSales;
	}
	public String getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getTurnover() {
		return turnover;
	}
	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	
}
