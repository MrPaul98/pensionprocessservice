/**
 * 
 */
package com.pension.processpensionmodule.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author SAYANDIP PAUL
 *
 */
public class ProcessPensionDetails {

	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	private String panNumber;
	
	private String pensionType;
	
	private double pensionAmount;

	private double bankServiceCharge;
	
	private String message;
	
	private Integer status;
	
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the panNumber
	 */
	public String getPanNumber() {
		return panNumber;
	}

	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	/**
	 * @return the pensionType
	 */
	public String getPensionType() {
		return pensionType;
	}

	/**
	 * @param pensionType the pensionType to set
	 */
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}

	/**
	 * @return the pensionAmount
	 */
	public double getPensionAmount() {
		return pensionAmount;
	}

	/**
	 * @param pensionAmount the pensionAmount to set
	 */
	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	/**
	 * @return the bankServiceCharge
	 */
	public double getBankServiceCharge() {
		return bankServiceCharge;
	}

	/**
	 * @param bankServiceCharge the bankServiceCharge to set
	 */
	public void setBankServiceCharge(double bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}

	

	/**
	 * @param name
	 * @param dateOfBirth
	 * @param panNumber
	 * @param pensionType
	 * @param pensionAmount
	 * @param bankServiceCharge
	 * @param message
	 * @param status
	 */
	public ProcessPensionDetails(String name, LocalDate dateOfBirth, String panNumber, String pensionType,
			double pensionAmount, double bankServiceCharge, String message, Integer status) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.pensionType = pensionType;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
		this.message = message;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProcessPensionDetails [name=" + name + ", dateOfBirth=" + dateOfBirth + ", panNumber=" + panNumber
				+ ", pensionType=" + pensionType + ", pensionAmount=" + pensionAmount + ", bankServiceCharge="
				+ bankServiceCharge + ", message=" + message + ", status=" + status + "]";
	}

	/**
	 * 
	 */
	public ProcessPensionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
