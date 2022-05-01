package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class bilDetailDAO {
	private connection myConnection;

	public bilDetailDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addBillDetail(billDetail bD) {
		String sSelection = "insert into billdetail( idBill, idBook ,quantityBook, unitPrice, intoMoney,idPromotion ,moneyDown)";
		String sValueBillDetail = " values('" + bD.getIdBill()+"','"+bD.getIdBook()+"','"+bD.getQuantityBook()+"','"+bD.getUnitPrice()
		+"','"+bD.getIntoMoney()+"','"+bD.getIdPromotion()+"','"+bD.getMoneyDown()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValueBillDetail));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyBillDetail(billDetail bD) {
		String sSelection = "update billdetail" + "set quantityBook = ?, unitPrice = ?, "
				+ "intoMoney = ?, idPromotion = ?, moneyDown = ?" + " where idBill = ? and idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			
			this.getMyConnection().getPreparedStatement().setInt(1, bD.getQuantityBook());
			this.getMyConnection().getPreparedStatement().setFloat(2, bD.getUnitPrice());
			this.getMyConnection().getPreparedStatement().setFloat(3, bD.getIntoMoney());
			this.getMyConnection().getPreparedStatement().setNString(4, bD.getIdPromotion());
			this.getMyConnection().getPreparedStatement().setFloat(5, bD.getMoneyDown());
			this.getMyConnection().getPreparedStatement().setInt(6, bD.getIdBill());
			this.getMyConnection().getPreparedStatement().setNString(7, bD.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBillDetail(billDetail bD) {
		String sSelection = "delete from billdetail" + " where idBill = ? and idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setInt(1, bD.getIdBill());
			this.getMyConnection().getPreparedStatement().setNString(2, bD.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<billDetail> readBillDetail(){ 
		ArrayList<billDetail> arrBillDetail = new ArrayList<billDetail>();
		String sSelection = " select * from billdetail";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				int idBill = this.getMyConnection().getResultSet().getInt("idBill");
				int quantityBook = this.getMyConnection().getResultSet().getInt("quantityBook");
				String idBook = this.getMyConnection().getResultSet().getNString("idBook");
				String idPromotion = this.getMyConnection().getResultSet().getNString("idPromotion");
				float unitPrice =this.getMyConnection().getResultSet().getFloat("unitPrice");
				float intoMoney =this.getMyConnection().getResultSet().getFloat("intoMoney");
				float moneyDown  =this.getMyConnection().getResultSet().getFloat("moneyDown");
				billDetail bD = new billDetail(idBill, idBook, quantityBook, unitPrice, intoMoney, idPromotion, moneyDown);
				arrBillDetail.add(bD);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrBillDetail;
	}
	
}
