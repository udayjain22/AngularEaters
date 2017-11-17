package com.capeat.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.util.SystemPropertyUtils;


import com.capeat.beans.CreditCard;
import com.capeat.beans.Order;
import com.capeat.beans.UserSignIn;
import com.capeat.beans.Wrapper;

public class OrderDAOImpl implements OrderDAO {

	private JdbcTemplate jdbcTemplate;
	int orderid = 0;
	public OrderDAOImpl(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	public OrderDAOImpl() {
		super();
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertorder(List<Order> o, Double amount, Integer sid) {
		Random random = new Random();
     
        orderid =Math.abs(random.nextInt());
   
		String sql = "insert into capcafe.orders(orderid,orderdt,ordercount,spice,productid,productname,price,location,amount,sid)"
				+ "values(?,current_date,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Order order = o.get(i);
				ps.setInt(1, orderid);
				ps.setInt(2, order.getOrderCount());
				ps.setInt(3, order.getSpice());
				ps.setInt(4, order.getProductId());
				ps.setString(5, order.getProductName());
				ps.setDouble(6, order.getPrice());
				ps.setString(7, order.getLocation());
				ps.setDouble(8, amount);
				ps.setInt(9, sid);

			}

			@Override
			public int getBatchSize() {
				return o.size();
			}

		});
		return orderid;

	}

	public void insertCredit(CreditCard c, Integer sid) {
		String sql = "";
	//	System.out.println(sid);
	//	System.out.println(c.getDecision());
		if (c.getDecision().equals("insert")) {
			sql = "insert into capcafe.carddetails(nameoncard,cardnum,cardtype,exp,cvc,zipcode,sid)"
					+ "values(?,?,'Visa',?,?,?,?)";
		}
		if (c.getDecision().equals("update")) {
			sql= "update capcafe.carddetails set nameoncard=?,cardnum=?,cardtype='amex',exp=?,cvc=?,zipcode=? where sid=?";
		
		}
		
			jdbcTemplate.update(sql, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, c.getNameOnCard());
					ps.setString(2, c.getCardNum());
					ps.setString(3, c.getExp());
					ps.setInt(4, c.getCvc());
					ps.setString(5, c.getZipCode());
					ps.setInt(6, sid);
				}
			});

	}
	public void deleteCredit(Integer sid) {
		jdbcTemplate.update("delete from capcafe.carddetails where sid ="+ sid);
	}

}