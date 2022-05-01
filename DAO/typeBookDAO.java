package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class typeBookDAO {
	private connection myConnection;
	
	public typeBookDAO() {
		this.setMyConnection(new connection());
	}
	public connection getMyConnection() {
		return myConnection;
	}
	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addTypeBook(typeBook tb) {
		String sSelection = "insert into typebook(idTypeBook, nameTypeBook)";
		String sTypeBook = " values ('" + tb.getIdTypeBook()+"','" + tb.getNameTypeBook() +"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sTypeBook));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyTypeBook(typeBook tb) {
		String sSelection = "update typebook "+"set nameTypeBook = ?" + " where idTypeBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, tb.getNameTypeBook());
			this.getMyConnection().getPreparedStatement().setNString(2, tb.getIdTypeBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteTypeBook(typeBook tb) {
		String sSelection = "delete from typebook" + " where idTypeBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, tb.getIdTypeBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<typeBook> readTypeBook(){
		ArrayList<typeBook> arrtb = new ArrayList<typeBook>();
		String sSelection = "selection * from typebook ";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String sId = this.getMyConnection().getResultSet().getString("idTypeBook");
				String sName = this.getMyConnection().getResultSet().getString("nameTYpeBook");
				typeBook tb = new typeBook(sId, sName);
				arrtb.add(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrtb;
	}
	public static void main(String[] args) {
		new typeBookDAO().addTypeBook(new typeBook("Truyen", "Truyen"));
	}
}
