package ec.com.bancointernacional.service.crud;

import ec.com.bancointernacional.model.crud.request.EstablecimientoCerradoRequest;
import ec.com.bancointernacional.model.crud.response.EstablecimientoCerradoResponse;

/*
import javax.ejb.Local;

@Local
 */
public interface EstablecimientoCerradoService {

	public EstablecimientoCerradoResponse create(EstablecimientoCerradoRequest establecimientoCerradoRequest);
}
