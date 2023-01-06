package com.example.man.demoMan.dao.crud.impl;
/*package ec.com.bancointernacional.dao.crud.impl;*/

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.example.man.demoMan.dao.crud.EstablecimientoCerradoDao;
import com.example.man.demoMan.model.crud.EstablecimientoCerrado;
import com.example.man.demoMan.model.crud.response.EstablecimientoCerradoGetResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
import ec.com.bancointernacional.util.ApplicationEjb;
import ec.com.bancointernacional.util.CreditReqUtils;
import ec.com.ibm.connector.as400.DataSourceAs400;


@Stateless
* */

@Service
public class EstablecimientoCerradoDaoImpl implements EstablecimientoCerradoDao {

	/* private CreditReqUtils utilCredit = new CreditReqUtils(); */

	private static final String QUERY_ERROR = "error al consultar";
	private static final String CLOSE_CON_ERROR = "error al cerrar coneccion";
	private static final String CLASS_NAME = "EstablecimientoCerradoDaoImpl.java";

	@Override
	public Boolean create(EstablecimientoCerrado establecimientoCerrado) {
		Boolean response = false;
		/*Connection conn = null;

		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					ApplicationEjb.getString("app.insert.crud.establecimiento", ApplicationEjb.getString("aes.util.lib")));

			if (establecimientoCerrado.getEstNombre() != null)
				ps.setString(1, establecimientoCerrado.getEstNombre());
			if (establecimientoCerrado.getEstNomProp() != null)
				ps.setString(2, establecimientoCerrado.getEstNomProp());
			if (establecimientoCerrado.getEstDireccion() != null)
				ps.setString(3, establecimientoCerrado.getEstDireccion());
			if (establecimientoCerrado.getEstCodCiudad() != null)
				ps.setInt(4, establecimientoCerrado.getEstCodCiudad());
			if (establecimientoCerrado.getEstTelefono() != null)
				ps.setString(5, establecimientoCerrado.getEstTelefono());
			if (establecimientoCerrado.getEstCodActEco() != null)
				ps.setString(6, establecimientoCerrado.getEstCodActEco());
			if (establecimientoCerrado.getEstCedProp() != null)
				ps.setString(7, establecimientoCerrado.getEstCedProp());
			if (establecimientoCerrado.getEstRucProp() != null)
				ps.setString(8, establecimientoCerrado.getEstRucProp());
			if (establecimientoCerrado.getEstFecCierre() != null)
				ps.setDate(9, new java.sql.Date(establecimientoCerrado.getEstFecCierre().getTime()));
			if (establecimientoCerrado.getEstCodigo() != null)
				ps.setString(10, establecimientoCerrado.getEstCodigo());
			if (establecimientoCerrado.getEstAsesor() != null)
				ps.setString(11, establecimientoCerrado.getEstAsesor());
			if (establecimientoCerrado.getEstGR() != null)
				ps.setInt(12, establecimientoCerrado.getEstGR());
			if (establecimientoCerrado.getEstBancoInt() != null)
				ps.setBoolean(13, establecimientoCerrado.getEstBancoInt());
			if (establecimientoCerrado.getEstEstado() != null)
				ps.setString(14, establecimientoCerrado.getEstEstado());
			if (establecimientoCerrado.getEstFecCrea() != null)
				ps.setDate(15, new java.sql.Date(establecimientoCerrado.getEstFecCrea().getTime()));
			if (establecimientoCerrado.getEstFecAct() != null)
				ps.setDate(16, new java.sql.Date(establecimientoCerrado.getEstFecAct().getTime()));
			if (establecimientoCerrado.getEstUsuario() != null)
				ps.setString(17, establecimientoCerrado.getEstUsuario());

			int row = ps.executeUpdate();

			if (row == 1) {
				response = true;
			}

			ps.close();
			conn.close();
		} catch (Exception e) {
			utilCredit.errorLog(QUERY_ERROR, CLASS_NAME, e);
		} finally {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				utilCredit.errorLog(CLOSE_CON_ERROR, CLASS_NAME, e);
			}
		}*/
		
		return response;

	}

	@Override
	public List<EstablecimientoCerradoGetResponse> getAll() {
		List<EstablecimientoCerradoGetResponse> response = new ArrayList<EstablecimientoCerradoGetResponse>();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.select.crud.establecimientos", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				EstablecimientoCerradoGetResponse est = new EstablecimientoCerradoGetResponse();
				est.setEstAsesor(rs.getString("ESTCLAS"));
				est.setEstBancoInt(rs.getBoolean("ESTCLAS"));
				est.setEstCedProp(rs.getString("ESTCLID"));
				est.setEstCodActEco(rs.getString("ESTCLBU"));
				est.setEstCodCiudad(rs.getInt("ESTCLCTY"));
				est.setEstCodigo(rs.getString("ESTCLCO"));
				est.setEstDireccion(rs.getString("ESTCLAD"));
				est.setEstEstado(rs.getString("ESTCSTS"));
				est.setEstFecAct(rs.getDate("ESTCLUP"));
				est.setEstGR(rs.getInt("ESTCLGR"));
				est.setEstId(rs.getInt("ESTCLID"));
				est.setEstNombre(rs.getString("ESTCLNA"));
				est.setEstNomProp(rs.getString("ESTCLOW"));
				est.setEstRucProp(rs.getString("ESTCLRU"));
				est.setEstTelefono(rs.getString("ESTCLPH"));
				est.setEstUsuario(rs.getString("ESTCLUS"));
				est.setEstFecCierre(rs.getDate("ESTCLDC"));
				est.setEstFecCrea(rs.getDate("ESTCLCR"));
		
				response.add(est);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			utilCredit.errorLog(QUERY_ERROR, CLASS_NAME, e);
		} finally {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				utilCredit.errorLog(CLOSE_CON_ERROR, CLASS_NAME, e);
			}
		}*/
		return response;
	}

	@Override
	public EstablecimientoCerradoGetResponse getByName(String name) {
		EstablecimientoCerradoGetResponse response = new EstablecimientoCerradoGetResponse();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.select.crud.establecimiento", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				response.setEstAsesor(rs.getString("ESTCLAS"));
				response.setEstBancoInt(rs.getBoolean("ESTCLBI"));
				response.setEstCedProp(rs.getString("ESTCLID"));
				response.setEstCodActEco(rs.getString("ESTCLBU"));
				response.setEstCodCiudad(rs.getInt("ESTCLCTY"));
				response.setEstCodigo(rs.getString("ESTCLCO"));
				response.setEstDireccion(rs.getString("ESTCLAD"));
				response.setEstEstado(rs.getString("ESTCSTS"));
				response.setEstFecAct(rs.getDate("ESTCLUP"));
				response.setEstGR(rs.getInt("ESTCLGR"));
				response.setEstId(rs.getInt("ESTCLID"));
				response.setEstNombre(rs.getString("ESTCLNA"));
				response.setEstNomProp(rs.getString("ESTCLOW"));
				response.setEstRucProp(rs.getString("ESTCLRU"));
				response.setEstTelefono(rs.getString("ESTCLPH"));
				response.setEstUsuario(rs.getString("ESTCLUS"));
				response.setEstFecCierre(rs.getDate("ESTCLDC"));
				response.setEstFecCrea(rs.getDate("ESTCLCR"));
		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			utilCredit.errorLog(QUERY_ERROR, CLASS_NAME, e);
		} finally {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				utilCredit.errorLog(CLOSE_CON_ERROR, CLASS_NAME, e);
			}
		}*/
		return response;
	}

	@Override
	public Boolean update(EstablecimientoCerrado establecimientoCerrado) {
		Boolean response = false;
		/*Connection conn = null;

		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					ApplicationEjb.getString("app.update.crud.establecimiento", ApplicationEjb.getString("aes.util.lib")));

			if (establecimientoCerrado.getEstNombre() != null)
				ps.setString(1, establecimientoCerrado.getEstNombre());
			if (establecimientoCerrado.getEstNomProp() != null)
				ps.setString(2, establecimientoCerrado.getEstNomProp());
			if (establecimientoCerrado.getEstDireccion() != null)
				ps.setString(3, establecimientoCerrado.getEstDireccion());
			if (establecimientoCerrado.getEstCodCiudad() != null)
				ps.setInt(4, establecimientoCerrado.getEstCodCiudad());
			if (establecimientoCerrado.getEstTelefono() != null)
				ps.setString(5, establecimientoCerrado.getEstTelefono());
			if (establecimientoCerrado.getEstCodActEco() != null)
				ps.setString(6, establecimientoCerrado.getEstCodActEco());
			if (establecimientoCerrado.getEstCedProp() != null)
				ps.setString(7, establecimientoCerrado.getEstCedProp());
			if (establecimientoCerrado.getEstRucProp() != null)
				ps.setString(8, establecimientoCerrado.getEstRucProp());
			if (establecimientoCerrado.getEstFecCierre() != null)
				ps.setDate(9, new java.sql.Date(establecimientoCerrado.getEstFecCierre().getTime()));
			if (establecimientoCerrado.getEstCodigo() != null)
				ps.setString(10, establecimientoCerrado.getEstCodigo());
			if (establecimientoCerrado.getEstAsesor() != null)
				ps.setString(11, establecimientoCerrado.getEstAsesor());
			if (establecimientoCerrado.getEstGR() != null)
				ps.setInt(12, establecimientoCerrado.getEstGR());
			if (establecimientoCerrado.getEstBancoInt() != null)
				ps.setBoolean(13, establecimientoCerrado.getEstBancoInt());
			if (establecimientoCerrado.getEstEstado() != null)
				ps.setString(14, establecimientoCerrado.getEstEstado());
			if (establecimientoCerrado.getEstFecCrea() != null)
				ps.setDate(15, new java.sql.Date(establecimientoCerrado.getEstFecCrea().getTime()));
			if (establecimientoCerrado.getEstFecAct() != null)
				ps.setDate(16, new java.sql.Date(establecimientoCerrado.getEstFecAct().getTime()));
			if (establecimientoCerrado.getEstUsuario() != null)
				ps.setString(17, establecimientoCerrado.getEstUsuario());

			int row = ps.executeUpdate();

			if (row == 1) {
				response = true;
			}

			ps.close();
			conn.close();
		} catch (Exception e) {
			utilCredit.errorLog(QUERY_ERROR, CLASS_NAME, e);
		} finally {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				utilCredit.errorLog(CLOSE_CON_ERROR, CLASS_NAME, e);
			}
		}*/
		
		return response;
	}

	@Override
	public EstablecimientoCerrado getById(Integer name) {
		EstablecimientoCerrado response = new EstablecimientoCerrado();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.selectId.crud.establecimiento", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				response.setEstAsesor(rs.getString("ESTCLAS"));
				response.setEstBancoInt(rs.getBoolean("ESTCLBI"));
				response.setEstCedProp(rs.getString("ESTCLID"));
				response.setEstCodActEco(rs.getString("ESTCLBU"));
				response.setEstCodCiudad(rs.getInt("ESTCLCTY"));
				response.setEstCodigo(rs.getString("ESTCLCO"));
				response.setEstDireccion(rs.getString("ESTCLAD"));
				response.setEstEstado(rs.getString("ESTCSTS"));
				response.setEstFecAct(rs.getDate("ESTCLUP"));
				response.setEstGR(rs.getInt("ESTCLGR"));
				response.setEstId(rs.getInt("ESTCLID"));
				response.setEstNombre(rs.getString("ESTCLNA"));
				response.setEstNomProp(rs.getString("ESTCLOW"));
				response.setEstRucProp(rs.getString("ESTCLRU"));
				response.setEstTelefono(rs.getString("ESTCLPH"));
				response.setEstUsuario(rs.getString("ESTCLUS"));
				response.setEstFecCierre(rs.getDate("ESTCLDC"));
				response.setEstFecCrea(rs.getDate("ESTCLCR"));
		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			utilCredit.errorLog(QUERY_ERROR, CLASS_NAME, e);
		} finally {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				utilCredit.errorLog(CLOSE_CON_ERROR, CLASS_NAME, e);
			}
		}*/
		return response;
	}

}
