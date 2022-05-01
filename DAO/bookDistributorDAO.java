package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class bookDistributorDAO {
	private connection myConnection;
	
	public bookDistributorDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addBookDistributor(bookDistributor bD) {
		String sSelection = "insert into bookdistributor(idBookDistributor, nameDistributor, phoneNumber, addressDistributor, email)";
		String sValueBookDistributor = " values('" + bD.getIdBookDistributor() + "','"+ bD.getNameDistributor()+ "','"
				+bD.getPhoneNumber()+"','"+ bD.getAddressDistributor()+ "','"+ bD.getEmail() +"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValueBookDistributor));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyBooDistributor(bookDistributor bD) {
		String sSelection = "update bookdistributor" + " set nameDistributor = ?, phoneNumber = ?, addressDistributor = ?, email = ?"
	+" where idBookDistributor = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setString(1, bD.getNameDistributor());
			this.getMyConnection().getPreparedStatement().setString(2, bD.getPhoneNumber());
			this.getMyConnection().getPreparedStatement().setString(3, bD.getAddressDistributor());
			this.getMyConnection().getPreparedStatement().setString(4, bD.getEmail());
			this.getMyConnection().getPreparedStatement().setString(5, bD.getIdBookDistributor());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteBookDistributor(bookDistributor bD) {
		String sSelection = "delete from bookdistributor" + " where idBookDistributor = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, bD.getIdBookDistributor());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<bookDistributor> readBookDistributor (){
		ArrayList<bookDistributor> arrBD = new ArrayList<bookDistributor>();
		String sSelection = "select * from bookdistributor";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idBookDistributor = this.getMyConnection().getResultSet().getNString("idBookDistributor");
				String nameDistributor = this.getMyConnection().getResultSet().getNString("nameDistributor");
				String phoneNumber = this.getMyConnection().getResultSet().getNString("phoneNumber");
				String addressDistributor = this.getMyConnection().getResultSet().getNString("addressDistributor");
				String email = this.getMyConnection().getResultSet().getNString("email");
				bookDistributor bD = new bookDistributor(idBookDistributor, nameDistributor, phoneNumber, addressDistributor, email);
				arrBD.add(bD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrBD;
	}
	public static void main(String[] args) {
		new bookDistributorDAO().addBookDistributor(new bookDistributor("a", "b", "c", "d", "e"));
	}
}
