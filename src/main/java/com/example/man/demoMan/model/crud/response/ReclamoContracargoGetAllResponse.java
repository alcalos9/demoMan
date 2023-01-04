package com.example.man.demoMan.model.crud.response;

import java.util.List;

public class ReclamoContracargoGetAllResponse {

	private List<ReclamoContracargoGetResponse> reclamos;

	/**
	 * @return the reclamos
	 */
	public List<ReclamoContracargoGetResponse> getReclamos() {
		return reclamos;
	}

	/**
	 * @param reclamos the reclamos to set
	 */
	public void setReclamos(List<ReclamoContracargoGetResponse> reclamos) {
		this.reclamos = reclamos;
	}

}
