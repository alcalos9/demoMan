package com.example.man.demoMan.model.crud.response;
/*package ec.com.bancointernacional.model.crud.response;*/

import java.util.Date;

public class MatchGetResponse {

	private Integer matId;
	private String matNomComercio;
	private String matRuc;
	private String matReprLeg;
	private String matEstado;
	private Date matFecCrea;
	private Date matFecAct;
	private String matUsuario;
	
	public Integer getMatId() {
		return matId;
	}
	public void setMatId(Integer matId) {
		this.matId = matId;
	}
	public String getMatNomComercio() {
		return matNomComercio;
	}
	public void setMatNomComercio(String matNomComercio) {
		this.matNomComercio = matNomComercio;
	}
	public String getMatRuc() {
		return matRuc;
	}
	public void setMatRuc(String matRuc) {
		this.matRuc = matRuc;
	}
	public String getMatReprLeg() {
		return matReprLeg;
	}
	public void setMatReprLeg(String matReprLeg) {
		this.matReprLeg = matReprLeg;
	}
	public String getMatEstado() {
		return matEstado;
	}
	public void setMatEstado(String matEstado) {
		this.matEstado = matEstado;
	}
	public Date getMatFecCrea() {
		return matFecCrea;
	}
	public void setMatFecCrea(Date matFecCrea) {
		this.matFecCrea = matFecCrea;
	}
	public Date getMatFecAct() {
		return matFecAct;
	}
	public void setMatFecAct(Date matFecAct) {
		this.matFecAct = matFecAct;
	}
	public String getMatUsuario() {
		return matUsuario;
	}
	public void setMatUsuario(String matUsuario) {
		this.matUsuario = matUsuario;
	}
	
}
