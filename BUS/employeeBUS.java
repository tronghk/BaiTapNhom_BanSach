package BUS;

import java.util.ArrayList;

import DAO.employee;
import DAO.employeeDAO;

public class employeeBUS {
	static ArrayList<employee> arrEmployee = new ArrayList<employee>();
	private employeeDAO employeeDAO;
	
	
	public employeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(employeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
}	
