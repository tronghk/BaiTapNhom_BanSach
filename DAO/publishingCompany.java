package DAO;

public class publishingCompany {
	private String idPublishingCompany;
	private String namePublishingCompany;
	public publishingCompany(String idPublishingCompany, String namePublishingCompany) {
		super();
		this.idPublishingCompany = idPublishingCompany;
		this.namePublishingCompany = namePublishingCompany;
	}
	public String getIdPublishingCompany() {
		return idPublishingCompany;
	}
	public void setIdPublishingCompany(String idPublishingCompany) {
		this.idPublishingCompany = idPublishingCompany;
	}
	public String getNamePublishingCompany() {
		return namePublishingCompany;
	}
	public void setNamePublishingCompany(String namePublishingCompany) {
		this.namePublishingCompany = namePublishingCompany;
	}
	
}
