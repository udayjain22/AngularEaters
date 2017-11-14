package com.capeat.DAO;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capeat.beans.History;

@Repository
public class HistoryDAOImpl implements HistoryDAO {

	private JdbcTemplate jdbcTemplate;
	History temp = new History();

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public History history(int sid) {
		try {
			String sql = "SELECT * from capcafe.orders WHERE capcafe.orders.sid = " + sid;
			temp = (History) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<History>(History.class));
			return temp;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	

	public HistoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}