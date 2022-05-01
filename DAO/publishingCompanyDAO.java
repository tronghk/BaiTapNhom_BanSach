package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class publishingCompanyDAO {
	private connection myConnection;
	
	public publishingCompanyDAO() {
		this.setMyConnection(new connection());
	}
	public connection getMyConnection() {
		return myConnection;
	}
	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addPublishingCompany(publishingCompany pc) {
		String sSelection = "insert into publishingcompany(idPublishingCompany, namePublishingCompany)";
		String sValue = " values ('"+pc.getIdPublishingCompany()+"','" + pc.getNamePublishingCompany()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValue));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyPublishingCompany(publishingCompany pc) {
		String sSelection = "update publishingcompany ";
		String sValue = "set namePublishingCompany = ?" + " where idPublishingCompany = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValue));
			this.getMyConnection().getPreparedStatement().setNString(1,pc.getNamePublishingCompany() );
			this.getMyConnection().getPreparedStatement().setNString(2,pc.getIdPublishingCompany() );
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deletePublishingCompany(publishingCompany pc) {
		String sSelection = "delete from publishingcompany" +" where idPublishingCompany = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, pc.getIdPublishingCompany());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<publishingCompany> writePublishingCompany(){
		ArrayList<publishingCompany> arrpc = new ArrayList<publishingCompany>();
		String sSelection = "selection * from publishingCompany";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String sId = this.getMyConnection().getResultSet().getNString("idPublishingCompany");
				String sName = this.getMyConnection().getResultSet().getNString("namePublishingCompany");
				publishingCompany pc = new publishingCompany(sId, sName);
				arrpc.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrpc;
	}
	public static void main(String[] args) {
		new publishingCompanyDAO().addPublishingCompany(new publishingCompany("KimDong", "111"));
	}
	
	
}
