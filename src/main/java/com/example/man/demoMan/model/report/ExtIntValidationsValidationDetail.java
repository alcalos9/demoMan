package com.example.man.demoMan.model.report;
/*package ec.com.bancointernacional.model.extintvalidations;*/

public class ExtIntValidationsValidationDetail {
	
	//private String cod; //codigo formulario puede ser que se pueda sacar, pero por ahora sirve para validar cruces de la query
	
	private ExtIntValidationsCategory category; //categoria
	private float percentage; //porcentaje
	private int answer; //respuesta
	private String value; //valor
	private float ponderation; //ponderacion
	private String comment; //observacion/comentario
	
	/*public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}*/
	public ExtIntValidationsCategory getCategory() {
		return category;
	}
	public void setCategory(ExtIntValidationsCategory category) {
		this.category = category;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public float getPonderation() {
		return ponderation;
	}
	public void setPonderation(float ponderation) {
		this.ponderation = ponderation;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
