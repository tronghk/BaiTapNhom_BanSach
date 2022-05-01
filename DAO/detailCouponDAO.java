package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class detailCouponDAO {
	private connection myConnection;

	public detailCouponDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addDetailCoupon(detailCoupon dc) {
		String sSelection = "insert into detailcoupon(idBook, quantityImport, unitPrice, intoMoney, idCoupon)";
		String sValuePromotion = " values('"+ dc.getIdBook()+"','" + dc.getQuantityImport()+"','"
		+dc.getUnitPrice()+"','" + dc.getIntoMoney()+"','" + dc.getIdCoupon()+"')";
		try {
			
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValuePromotion));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}
	public void modifyDetailCoupon(detailCoupon dc) {
		String sSelection = "update detailcoupon "+ "set quantityImport = ?, "
				+ "unitPrice = ?, intoMoney = ? " + " where idCoupon = ? and idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			
			this.getMyConnection().getPreparedStatement().setInt(1, dc.getQuantityImport());
			this.getMyConnection().getPreparedStatement().setFloat(2, dc.getUnitPrice());
			this.getMyConnection().getPreparedStatement().setFloat(3, dc.getIntoMoney());
			this.getMyConnection().getPreparedStatement().setInt(4, dc.getIdCoupon());
			this.getMyConnection().getPreparedStatement().setNString(5, dc.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void deleteDetailCoupon(detailCoupon dc) {
		String sSelection = "delete from detailpromotion "+ " where idCoupon  = ? and idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setInt(1,dc.getIdCoupon());
			this.getMyConnection().getPreparedStatement().setNString(2,dc.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<detailCoupon> readDetailCoupon(){
		ArrayList<detailCoupon> arrDetailCoupon = new ArrayList<detailCoupon>();
		String sSelection = "select * from detailcoupon";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				float unitPrice = this.getMyConnection().getResultSet().getFloat("unitPrice");
				float intoMoney = this.getMyConnection().getResultSet().getFloat("intoMoney");
				String idBook = this.getMyConnection().getResultSet().getNString("idBook");
				int quantityImport	 = this.getMyConnection().getResultSet().getInt("quantityImport	");
				int idCoupon = this.getMyConnection().getResultSet().getInt("idCoupon");
				
				detailCoupon dc = new detailCoupon(idBook, idCoupon, quantityImport, unitPrice, intoMoney);
				arrDetailCoupon.add(dc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrDetailCoupon;
	}
	public static void main(String[] args) {
		new detailCouponDAO().modifyDetailCoupon(new detailCoupon("01", 0, 20, 10000, 1100));
	}
	
}
