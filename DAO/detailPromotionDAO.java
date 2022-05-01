package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class detailPromotionDAO {
	private connection myConnection;

	public detailPromotionDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addDetailPromotion(detailPromotion dP) {
		String sSelection = "insert into detailpromotion(idPromotion, idBook, discount)";
		String sValuePromotion = " values('"+ dP.getIdPromotion()+"','" + dP.getIdBook()+"','"
		+dP.getDiscount()+"')";
		try {
			
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValuePromotion));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}
	public void modifyDetailPromotion(detailPromotion dP) {
		String sSelection = "update detailpromotion "+ "set " + " discount = ?" + " where idPromotion = ? and idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			
			this.getMyConnection().getPreparedStatement().setInt(1, dP.getDiscount());
			this.getMyConnection().getPreparedStatement().setNString(2, dP.getIdPromotion());
			this.getMyConnection().getPreparedStatement().setNString(3, dP.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void deleteDetailPromotion(detailPromotion dP) {
		String sSelection = "delete from detailpromotion "+ " where idPromotion  = ? and idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1,dP.getIdPromotion());
			this.getMyConnection().getPreparedStatement().setNString(2,dP.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<detailPromotion> readDetailPromotion(){
		ArrayList<detailPromotion> arrDetailPromotion = new ArrayList<detailPromotion>();
		String sSelection = "select * from detailpromotion";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idPromotion = this.getMyConnection().getResultSet().getNString("idPromotion");
				String idBook = this.getMyConnection().getResultSet().getNString("idBook");
				int discount = this.getMyConnection().getResultSet().getInt("discount");
				detailPromotion dP = new detailPromotion(idBook, idPromotion, discount);
				arrDetailPromotion.add(dP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrDetailPromotion;
	}
	public static void main(String[] args) {
		new detailPromotionDAO().modifyDetailPromotion(new detailPromotion("01", "1", 1));
	}
}
