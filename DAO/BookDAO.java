package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDAO {
	private connection myConnection;
	public BookDAO() {
		this.setMyConnection(new connection());
	}
	public connection getMyConnection() {
		return myConnection;
	}
	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addBook(book b) {
		String sSelection = "insert into book(idBook, nameBook, unitPrice, 	datePublishing,"
				+ " quantityBook, idTypeBook, idPublishingCompany )";
		String sValueBook = " values('"+ b.getIdBook()+"','"+b.getNameBook()+"','"
				+b.getUnitPrice()+"','"+b.getDatePublishing()+"','"+b.getQuantityBook()+"','"+b.getIdTypeBook()
				+"','"+b.getIdPublishingCompany()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValueBook));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modifyBook(book b) {
		String sSelection = "update book" + "set nameBook = ?, unitPrice = ?, datePublishing = ?, quantityBook = ?"
				+ ", idTypeBook = ?, idPublishingCompany = ?" + "where idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, b.getNameBook());
			this.getMyConnection().getPreparedStatement().setFloat(2, b.getUnitPrice());
			this.getMyConnection().getPreparedStatement().setNString(3, b.getDatePublishing().toString());
			this.getMyConnection().getPreparedStatement().setInt(4, b.getQuantityBook());
			this.getMyConnection().getPreparedStatement().setNString(5, b.getIdTypeBook());
			this.getMyConnection().getPreparedStatement().setNString(6, b.getIdPublishingCompany());
			this.getMyConnection().getPreparedStatement().setNString(7, b.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBook(book b) {
		String sSelection = "delete from book" +" where idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, b.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<book> readBook(){
		ArrayList<book> arrBook = new ArrayList<book>();
		String sSelection = "select * from book";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idBook = this.getMyConnection().getResultSet().getString("idBook");
				String nameBook = this.getMyConnection().getResultSet().getString("nameBook");
				float unitPrice = this.getMyConnection().getResultSet().getFloat("unitPrice");
				LocalDate datePublishing = LocalDate.parse(this.getMyConnection().getResultSet().getString("datePublishing")) ;
				int quantityBook = this.getMyConnection().getResultSet().getInt("quantityBook");
				String idTypeBook = this.getMyConnection().getResultSet().getString("idTypeBook");
				String idPublishingCompany = this.getMyConnection().getResultSet().getString("idPublishingCompany");
				book b = new  book(idBook, nameBook, unitPrice, datePublishing, quantityBook, idTypeBook, idPublishingCompany);
				arrBook.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrBook;
	}
	public static void main(String[] args) {
		new  BookDAO().addBook(new book("01", "01", 10000, LocalDate.parse("1900-12-01"), 10, "Truyen", "KimDong"));
	}
	
}
