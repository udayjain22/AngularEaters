package com.capeat.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.dao.EmptyResultDataAccessException;
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

	
	public List<History> historyList(String sid) {
		String sql = "SELECT * from capcafe.orders WHERE capcafe.orders.sid = "
				 + Integer.parseInt(sid);
		
		List<History> list = jdbcTemplate.query(sql, new RowMapper<History>(){
            public History mapRow(ResultSet rs, int nRows) throws SQLException {            	
            	temp.setOrderId(rs.getInt("orderid"));
            	temp.setItemName(rs.getString("productname"));
            	temp.setItemDesc(rs.getString("productdesc"));
            	temp.setItemPrice(rs.getString("productprice"));
            	temp.setOrderLocation(rs.getString("orderlocation"));
            	temp.setOrderDate(rs.getDate("orderdt"));
            	temp.setSpiceLevel(rs.getInt("spicelevel"));
            	System.out.println(temp);
				return temp;
			}
		});
		return list;
	}


	

	public HistoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}