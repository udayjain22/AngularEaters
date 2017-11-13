package com.capeat.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capeat.beans.Orders;



@Repository
public class OrdersDAOImpl implements OrdersDAO {
	
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	

	@Override
	public List<Orders> historyList(String eid) {
		String sql = "SELECT * from capcafe.orders WHERE capcafe.orders.sid = "
				 + Integer.parseInt(eid);
		
		List<Orders> list = jdbcTemplate.query(sql, new RowMapper<Orders>(){
            public Orders mapRow(ResultSet rs, int nRows) throws SQLException {
            	Orders temp = new Orders();
            	
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

}

