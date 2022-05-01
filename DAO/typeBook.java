package DAO;

public class typeBook {
	private String idTypeBook;
	private String nameTypeBook;
	public typeBook(String idTypeBook, String nameTypeBook) {
		super();
		this.idTypeBook = idTypeBook;
		this.nameTypeBook = nameTypeBook;
	}
	public String getIdTypeBook() {
		return idTypeBook;
	}
	public void setIdTypeBook(String idTypeBook) {
		this.idTypeBook = idTypeBook;
	}
	public String getNameTypeBook() {
		return nameTypeBook;
	}
	public void setNameTypeBook(String nameTypeBook) {
		this.nameTypeBook = nameTypeBook;
	}
	
}
