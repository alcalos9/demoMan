package com.example.man.demoMan.dao.crud.impl;
/*package ec.com.bancointernacional.dao.crud.impl;*/

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.example.man.demoMan.dao.crud.ReclamoContracargoDao;
import com.example.man.demoMan.model.crud.ReclamoContracargo;
import com.example.man.demoMan.model.crud.response.ReclamoContracargoGetResponse;

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
public class ReclamoContracargoDaoImpl implements ReclamoContracargoDao {

	/* private CreditReqUtils utilCredit = new CreditReqUtils(); */

	private static final String QUERY_ERROR = "error al consultar";
	private static final String CLOSE_CON_ERROR = "error al cerrar coneccion";
	private static final String CLASS_NAME = "ReclamoContracargoDaoImpl.java";

	@Override
	public Boolean create(ReclamoContracargo reclamoContracargo) {
		Boolean response = false;
		/*Connection conn = null;

		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					ApplicationEjb.getString("app.insert.crud.reclamo", ApplicationEjb.getString("aes.util.lib")));

			if (reclamoContracargo.getRecNomComercio() != null)
				ps.setString(1, reclamoContracargo.getRecNomComercio());
			if (reclamoContracargo.getRecCodPais() != null)
				ps.setString(2, reclamoContracargo.getRecCodPais());
			if (reclamoContracargo.getRecEstado() != null)
				ps.setString(3, reclamoContracargo.getRecEstado());
			if (reclamoContracargo.getRecUsuario() != null)
				ps.setString(4, reclamoContracargo.getRecUsuario());
			if (reclamoContracargo.getRecFecCrea() != null)
				ps.setDate(5, new java.sql.Date(reclamoContracargo.getRecFecCrea().getTime()));
			if (reclamoContracargo.getRecFecAct() != null)
				ps.setDate(6, new java.sql.Date(reclamoContracargo.getRecFecAct().getTime()));

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
	public List<ReclamoContracargoGetResponse> getAll() {
		List<ReclamoContracargoGetResponse> response = new ArrayList<ReclamoContracargoGetResponse>();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.select.crud.reclamo", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ReclamoContracargoGetResponse rec = new ReclamoContracargoGetResponse();
				rec.setRecId(rs.getInt("ESTRCID"));
				rec.setRecNomComercio(rs.getString("ESTRCNC"));
				rec.setRecCodPais(rs.getString("ESTRCCT"));
				rec.setRecEstado(rs.getString("ESTRSTS"));
				rec.setRecFecCrea(rs.getDate("ESTRCCR"));
				rec.setRecFecAct(rs.getDate("ESTRCUP"));
				rec.setRecUsuario(rs.getString("ESTRCUS"));
		
				response.add(rec);
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
	public ReclamoContracargoGetResponse getByName(String name) {
		ReclamoContracargoGetResponse response = new ReclamoContracargoGetResponse();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.select.crud.reclamo", ApplicationEjb.getString("aes.util.lib")));
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				response.setRecId(rs.getInt("ESTRCID"));
				response.setRecNomComercio(rs.getString("ESTRCNC"));
				response.setRecCodPais(rs.getString("ESTRCCT"));
				response.setRecEstado(rs.getString("ESTRSTS"));
				response.setRecFecCrea(rs.getDate("ESTRCCR"));
				response.setRecFecAct(rs.getDate("ESTRCUP"));
				response.setRecUsuario(rs.getString("ESTRCUS"));
		
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
	public Boolean update(ReclamoContracargo reclamoContracargo) {
		Boolean response = false;
		/*Connection conn = null;

		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					ApplicationEjb.getString("app.update.crud.reclamo", ApplicationEjb.getString("aes.util.lib")));

			if (reclamoContracargo.getRecNomComercio() != null)
				ps.setString(1, reclamoContracargo.getRecNomComercio());
			if (reclamoContracargo.getRecCodPais() != null)
				ps.setString(2, reclamoContracargo.getRecCodPais());
			if (reclamoContracargo.getRecEstado() != null)
				ps.setString(3, reclamoContracargo.getRecEstado());
			if (reclamoContracargo.getRecUsuario() != null)
				ps.setString(4, reclamoContracargo.getRecUsuario());
			if (reclamoContracargo.getRecFecCrea() != null)
				ps.setDate(5, new java.sql.Date(reclamoContracargo.getRecFecCrea().getTime()));
			if (reclamoContracargo.getRecFecAct() != null)
				ps.setDate(6, new java.sql.Date(reclamoContracargo.getRecFecAct().getTime()));
			if (reclamoContracargo.getRecId() != null)
				ps.setInt(7, reclamoContracargo.getRecId());

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
	public ReclamoContracargo getById(Integer id) {
		ReclamoContracargo response = new ReclamoContracargo();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.selectId.crud.reclamo", ApplicationEjb.getString("aes.util.lib")));
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				response.setRecId(rs.getInt("ESTRCID"));
				response.setRecNomComercio(rs.getString("ESTRCNC"));
				response.setRecCodPais(rs.getString("ESTRCCT"));
				response.setRecEstado(rs.getString("ESTRSTS"));
				response.setRecFecCrea(rs.getDate("ESTRCCR"));
				response.setRecFecAct(rs.getDate("ESTRCUP"));
				response.setRecUsuario(rs.getString("ESTRCUS"));
		
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
