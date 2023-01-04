package com.example.man.demoMan.model.crud.response;

import java.util.List;

public class EstablecimientoCerradoGetAllResponse {

	private List<EstablecimientoCerradoGetResponse> establecimientos;

	/**
	 * @return the establecimientos
	 */
	public List<EstablecimientoCerradoGetResponse> getEstablecimientos() {
		return establecimientos;
	}

	/**
	 * @param establecimientos the establecimientos to set
	 */
	public void setEstablecimientos(List<EstablecimientoCerradoGetResponse> establecimientos) {
		this.establecimientos = establecimientos;
	}
	
	
}
