package com.example.man.demoMan.model.report;
/*package ec.com.bancointernacional.model.creditreq;*/

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditReqFormRequest {
	private String ecAct; // actividad economica
	private String ident; //identificacion
	private String dactCod; //codigo dactilar
	private String secNac; //segunda nacionalidad
	@JsonProperty("pep")
	private boolean isPep; //es pep
	@JsonProperty("extTax")
	private boolean isExtTax; //es impuesto en el exterior
	private float monInc; //ingresos mensuales
	private String neig; //Barrio, Sector o Referencia
	private int provCod; //codigo provincia
	private int cityCod; //codigo ciudad
	private String prStrName; //nombre calle principal
	private String scStrName; //nombre calle secundaria
	private String homeNumber; //numero casa o edificio
	private String phoneNumber; //numero telefono convencional
	private String email; //correo electronico
	
	public String getEcAct() {
		return ecAct;
	}
	public void setEcAct(String ecAct) {
		this.ecAct = ecAct;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getDactCod() {
		return dactCod;
	}
	public void setDactCod(String dactCod) {
		this.dactCod = dactCod;
	}
	public String getSecNac() {
		return secNac;
	}
	public void setSecNac(String secNac) {
		this.secNac = secNac;
	}
	public boolean isPep() {
		return isPep;
	}
	public void setPep(boolean isPep) {
		this.isPep = isPep;
	}
	public boolean isExtTax() {
		return isExtTax;
	}
	public void setExtTax(boolean isExtTax) {
		this.isExtTax = isExtTax;
	}
	public float getMonInc() {
		return monInc;
	}
	public void setMonInc(float monInc) {
		this.monInc = monInc;
	}
	public String getNeig() {
		return neig;
	}
	public void setNeig(String neig) {
		this.neig = neig;
	}
	public int getProvCod() {
		return provCod;
	}
	public void setProvCod(int provCod) {
		this.provCod = provCod;
	}
	public int getCityCod() {
		return cityCod;
	}
	public void setCityCod(int cityCod) {
		this.cityCod = cityCod;
	}
	public String getPrStrName() {
		return prStrName;
	}
	public void setPrStrName(String prStrName) {
		this.prStrName = prStrName;
	}
	public String getScStrName() {
		return scStrName;
	}
	public void setScStrName(String scStrName) {
		this.scStrName = scStrName;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
