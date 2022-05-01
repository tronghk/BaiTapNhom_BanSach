package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class customerDAO {
	private connection myconConnection;

	public customerDAO() {
		this.setMyconConnection(new connection());
	}

	public connection getMyconConnection() {
		return myconConnection;
	}

	public void setMyconConnection(connection myconConnection) {
		this.myconConnection = myconConnection;
	}
	public void addCustomer(customer cu) {	
		String sSelection = "insert into customer(	idCustomer, name, phoneNumber, address, typeCustomer)";
		String sValueCustomer = " values('"+cu.getIdCustomer()+"','" + cu.getName()+"','" + cu.getPhoneNumber()
		+"','" + cu.getAddress()+"','" +cu.getTypeCustomer()+"')";
		try {
			this.getMyconConnection().setPreparedStatement(this.getMyconConnection().getConn().prepareStatement(sSelection+sValueCustomer));
			this.getMyconConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyCustomer(customer cu) {
		String sSelection = "update customer" + " set name = ?, phoneNumber = ?, address = ?, typeCustomer = ?" + "where idCustomer = ?";
		try {
			this.getMyconConnection().setPreparedStatement(this.getMyconConnection().getConn().prepareStatement(sSelection));
			this.getMyconConnection().getPreparedStatement().setNString(1, cu.getName());
			this.getMyconConnection().getPreparedStatement().setNString(2, cu.getPhoneNumber());
			this.getMyconConnection().getPreparedStatement().setNString(3, cu.getAddress());
			this.getMyconConnection().getPreparedStatement().setNString(4, cu.getTypeCustomer());
			this.getMyconConnection().getPreparedStatement().setNString(5, cu.getIdCustomer());
			this.getMyconConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteCustomer(customer cu) {
		String sSelection = "delete from customer" + " where idCustomer = ?";
		try {
			this.getMyconConnection().setPreparedStatement(this.getMyconConnection().getConn().prepareStatement(sSelection));
			this.getMyconConnection().getPreparedStatement().setNString(1, cu.getIdCustomer());
			this.getMyconConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<customer> readCustomer(){
		ArrayList<customer> arrCustomer = new ArrayList<customer>();
		String sSelection = "select * from customer";
		try {
			this.getMyconConnection().setStatement(this.getMyconConnection().getConn().createStatement());
			this.getMyconConnection().setResultSet(this.getMyconConnection().getStatement().executeQuery(sSelection));
			while(this.getMyconConnection().getResultSet().next()) {
				String idCustomer = this.getMyconConnection().getResultSet().getNString("idCustomer");
				String name = this.getMyconConnection().getResultSet().getNString("name");
				String phoneNumber = this.getMyconConnection().getResultSet().getNString("phoneNumber");
				String address = this.getMyconConnection().getResultSet().getNString("address");
				String typeCustomer = this.getMyconConnection().getResultSet().getNString("typeCustomer");
				customer cu = new customer(idCustomer, name, phoneNumber, address, typeCustomer);
				arrCustomer.add(cu);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrCustomer;
	}
	public static void main(String[] args) {
		new customerDAO().addCustomer(new customer("trong", "tien", "trong", "trong", "trong"));
	}
}
