package com.example.man.demoMan.model.report;
/*package ec.com.bancointernacional.model.extintvalidations;*/

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/*import ec.com.bancointernacional.model.creditreq.CreditReqFormRequest;*/

public class ExtIntValidationsDetail {
	
	private CreditReqFormRequest formInfo;
	private String cod; //codigo formulario
	private ExtIntValidationsFormStatus formStatus; //estado formulario
	private ExtIntValidationsSemaphoreStatus semaphoreStatus; //estado semaforo
	private ExtIntValidationsSemaphoreStatus semphoreStatusAnalist; //estado semaforo analista
	private String commerceName; // nombre comercio
	private String ruc; //ruc
	private String giro; //giro comercio
	private String analistComment; //comentario analista
	private String calificationDate; //fecha calificacion
	private String legalRepresentative; //representante legal
	private String commercialAssesor; //asesor comercial
	private String afiliationPos; //afiliacion POS
	private String mPos; //MPOS
	private String upfAnalist; //analista UPF
	private String upfComment; //comentarios UPF
	private float totalScore; //puntaje total
	private String analist; //analista
	private List<ExtIntValidationsValidationDetail> categoryDetailList; //lista de detalle por categoria
	
	public CreditReqFormRequest getFormInfo() {
		return formInfo;
	}
	public void setFormInfo(CreditReqFormRequest formInfo) {
		this.formInfo = formInfo;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}

	public ExtIntValidationsFormStatus getFormStatus() {
		return formStatus;
	}
	public void setFormStatus(ExtIntValidationsFormStatus formStatus) {
		this.formStatus = formStatus;
	}
	public ExtIntValidationsSemaphoreStatus getSemaphoreStatus() {
		return semaphoreStatus;
	}
	public void setSemaphoreStatus(ExtIntValidationsSemaphoreStatus semaphoreStatus) {
		this.semaphoreStatus = semaphoreStatus;
	}
	public ExtIntValidationsSemaphoreStatus getSemphoreStatusAnalist() {
		return semphoreStatusAnalist;
	}
	public void setSemphoreStatusAnalist(ExtIntValidationsSemaphoreStatus semphoreStatusAnalist) {
		this.semphoreStatusAnalist = semphoreStatusAnalist;
	}
	public String getCommerceName() {
		return commerceName;
	}
	public void setCommerceName(String commerceName) {
		this.commerceName = commerceName;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getGiro() {
		return giro;
	}
	public void setGiro(String giro) {
		this.giro = giro;
	}
	public String getAnalistComment() {
		return analistComment;
	}
	public void setAnalistComment(String analistComment) {
		this.analistComment = analistComment;
	}
	public String getCalificationDate() {
		return calificationDate;
	}
	public void setCalificationDate(String calificationDate) {
		this.calificationDate = calificationDate;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	public String getCommercialAssesor() {
		return commercialAssesor;
	}
	public void setCommercialAssesor(String commercialAssesor) {
		this.commercialAssesor = commercialAssesor;
	}
	public String getAfiliationPos() {
		return afiliationPos;
	}
	public void setAfiliationPos(String afiliationPos) {
		this.afiliationPos = afiliationPos;
	}
	public String getmPos() {
		return mPos;
	}
	public void setmPos(String mPos) {
		this.mPos = mPos;
	}
	public String getUpfAnalist() {
		return upfAnalist;
	}
	public void setUpfAnalist(String upfAnalist) {
		this.upfAnalist = upfAnalist;
	}
	public String getUpfComment() {
		return upfComment;
	}
	public void setUpfComment(String upfComment) {
		this.upfComment = upfComment;
	}
	public float getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}
	public String getAnalist() {
		return analist;
	}
	public void setAnalist(String analist) {
		this.analist = analist;
	}
	
	public List<ExtIntValidationsValidationDetail> getCategoryDetailList() {
		return categoryDetailList;
	}
	public void setCategoryDetailList(List<ExtIntValidationsValidationDetail> categoryDetailList) {
		this.categoryDetailList = categoryDetailList;
	}
	
}
