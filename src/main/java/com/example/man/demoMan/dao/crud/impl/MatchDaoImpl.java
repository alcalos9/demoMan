package com.example.man.demoMan.dao.crud.impl;
/*package ec.com.bancointernacional.dao.crud.impl;*/

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.example.man.demoMan.dao.crud.MatchDao;
import com.example.man.demoMan.model.crud.Match;
import com.example.man.demoMan.model.crud.response.MatchGetResponse;

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
public class MatchDaoImpl implements MatchDao {

	/* private CreditReqUtils utilCredit = new CreditReqUtils(); */

	private static final String QUERY_ERROR = "error al consultar";
	private static final String CLOSE_CON_ERROR = "error al cerrar coneccion";
	private static final String CLASS_NAME = "MatchDaoImpl.java";

	@Override
	public Boolean create(Match match) {
		Boolean response = false;
		/*Connection conn = null;

		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					ApplicationEjb.getString("app.insert.crud.match", ApplicationEjb.getString("aes.util.lib")));

			if (match.getMatNomComercio() != null)
				ps.setString(1, match.getMatNomComercio());
			if (match.getMatRuc() != null)
				ps.setString(2, match.getMatRuc());
			if (match.getMatReprLeg() != null)
				ps.setString(3, match.getMatReprLeg());
			if (match.getMatEstado() != null)
				ps.setString(4, match.getMatEstado());
			if (match.getMatFecCrea() != null)
				ps.setDate(5, new java.sql.Date(match.getMatFecCrea().getTime()));
			if (match.getMatFecAct() != null)
				ps.setDate(6, new java.sql.Date(match.getMatFecAct().getTime()));
			if (match.getMatUsuario() != null)
				ps.setString(7, match.getMatUsuario());

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
	public List<MatchGetResponse> getAll() {
		List<MatchGetResponse> response = new ArrayList<MatchGetResponse>();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.select.crud.match", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				MatchGetResponse match = new MatchGetResponse();
				match.setMatEstado(rs.getString("ESTMSTS"));
				match.setMatId(rs.getInt("ESTMID"));
				match.setMatNomComercio(rs.getString("ESTMNC"));
				match.setMatReprLeg(rs.getString("ESTMRLG"));
				match.setMatRuc(rs.getString("ESTMRUC"));
				match.setMatUsuario(rs.getString("ESTMUS"));
				match.setMatFecAct(rs.getDate("ESTMUP"));
				match.setMatFecCrea(rs.getDate("ESTMCR"));
		
				response.add(match);
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
	public MatchGetResponse getByName(String name) {
		MatchGetResponse response = new MatchGetResponse();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.select.crud.match", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				response.setMatEstado(rs.getString("ESTMSTS"));
				response.setMatId(rs.getInt("ESTMID"));
				response.setMatNomComercio(rs.getString("ESTMNC"));
				response.setMatReprLeg(rs.getString("ESTMRLG"));
				response.setMatRuc(rs.getString("ESTMRUC"));
				response.setMatUsuario(rs.getString("ESTMUS"));
				response.setMatFecAct(rs.getDate("ESTMUP"));
				response.setMatFecCrea(rs.getDate("ESTMCR"));
		
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
	public Boolean update(Match match) {
		Boolean response = false;
		/*Connection conn = null;

		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					ApplicationEjb.getString("app.update.crud.match", ApplicationEjb.getString("aes.util.lib")));

			if (match.getMatNomComercio() != null)
				ps.setString(1, match.getMatNomComercio());
			if (match.getMatRuc() != null)
				ps.setString(2, match.getMatRuc());
			if (match.getMatReprLeg() != null)
				ps.setString(3, match.getMatReprLeg());
			if (match.getMatEstado() != null)
				ps.setString(4, match.getMatEstado());
			if (match.getMatFecCrea() != null)
				ps.setDate(5, new java.sql.Date(match.getMatFecCrea().getTime()));
			if (match.getMatFecAct() != null)
				ps.setDate(6, new java.sql.Date(match.getMatFecAct().getTime()));
			if (match.getMatUsuario() != null)
				ps.setString(7, match.getMatUsuario());

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
	public Match getById(Integer name) {
		Match response = new Match();
		/*Connection conn = null;
		
		try {
			DataSource ds = DataSourceAs400.getDataSource();
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(ApplicationEjb.getString("app.selectId.crud.match", ApplicationEjb.getString("aes.util.lib")));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				response.setMatEstado(rs.getString("ESTMSTS"));
				response.setMatId(rs.getInt("ESTMID"));
				response.setMatNomComercio(rs.getString("ESTMNC"));
				response.setMatReprLeg(rs.getString("ESTMRLG"));
				response.setMatRuc(rs.getString("ESTMRUC"));
				response.setMatUsuario(rs.getString("ESTMUS"));
				response.setMatFecAct(rs.getDate("ESTMUP"));
				response.setMatFecCrea(rs.getDate("ESTMCR"));
		
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
