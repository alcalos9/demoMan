package com.example.man.demoMan.model.crud.response;

import java.util.Date;

public class ReclamoContracargoGetResponse {

	private Integer recId;
	private String recNomComercio;
	private String recCodPais;
	private String recEstado;
	private Date recFecCrea;
	private Date recFecAct;
	private String recUsuario;
	
	public Integer getRecId() {
		return recId;
	}
	public void setRecId(Integer recId) {
		this.recId = recId;
	}
	public String getRecNomComercio() {
		return recNomComercio;
	}
	public void setRecNomComercio(String recNomComercio) {
		this.recNomComercio = recNomComercio;
	}
	public String getRecCodPais() {
		return recCodPais;
	}
	public void setRecCodPais(String recCodPais) {
		this.recCodPais = recCodPais;
	}
	public String getRecEstado() {
		return recEstado;
	}
	public void setRecEstado(String recEstado) {
		this.recEstado = recEstado;
	}
	public Date getRecFecCrea() {
		return recFecCrea;
	}
	public void setRecFecCrea(Date recFecCrea) {
		this.recFecCrea = recFecCrea;
	}
	public Date getRecFecAct() {
		return recFecAct;
	}
	public void setRecFecAct(Date recFecAct) {
		this.recFecAct = recFecAct;
	}
	public String getRecUsuario() {
		return recUsuario;
	}
	public void setRecUsuario(String recUsuario) {
		this.recUsuario = recUsuario;
	}
	
}
