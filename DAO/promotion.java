package DAO;

import java.time.LocalDate;

public class promotion {
	private String idPromotion;
	private String namePromotion;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	public promotion(String idPromotion, String namePromotion, LocalDate dateStart, LocalDate dateEnd) {
		super();
		this.idPromotion = idPromotion;
		this.namePromotion = namePromotion;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	public String getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(String idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getNamePromotion() {
		return namePromotion;
	}
	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}
	public LocalDate getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	public LocalDate getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	
}
