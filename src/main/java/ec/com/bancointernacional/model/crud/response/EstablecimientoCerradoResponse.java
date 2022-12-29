package ec.com.bancointernacional.model.crud.response;

import ec.com.bancointernacional.model.crud.request.EstablecimientoCerradoRequest;

public class EstablecimientoCerradoResponse {

	private int messageId;
	
	private String messageDescr;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageDescr() {
		return messageDescr;
	}

	public void setMessageDescr(String messageDescr) {
		this.messageDescr = messageDescr;
	}
	
	
}
